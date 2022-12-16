package com.example.chips_development

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import org.json.JSONArray
import java.io.*

class CreateUserActivity : AppCompatActivity() {

    private var login: EditText? = null
    private var password: EditText? = null
    private var btLogin: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)

        btLogin = findViewById(R.id.btLogin)
        btLogin?.setOnClickListener {
            login = findViewById(R.id.loginUser)
            password = findViewById(R.id.passwordUser)
            val log = login?.text.toString()
            val pas = password?.text.toString()

            if (log != "" || pas != "") {
                val jsonString = readFromFile(context = applicationContext)
                val jsonArray = JSONArray(jsonString)
                var writableString = ""

                for (i in 0 until jsonArray.length()) {
                    val jsonObj = jsonArray.getJSONObject(i)

                    writableString += jsonObj.toString()
                    writableString = "$writableString{\"file\":\"false\",\"status\":\"false\",\"login\":\"$log\",\"password\":\"$pas\"}"
                    print(writableString)
                }
                val preResult = writableString.replace(
                    "\"}{\"",
                    "\"},{\"",
                    true
                )
                val result = "[$preResult]"

                writeFileOnInternalStorage(file = "users.json", data = result, context = applicationContext)

                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }, 100)
            }
            else {
                Toast.makeText(applicationContext, "Заполните все поля", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readFromFile(context: Context): String {
        var ret = ""
        var inputStream: InputStream? = null
        try {
            inputStream = context.openFileInput("users.json")
            if (inputStream != null) {
                val inputStreamReader = InputStreamReader(inputStream)
                val bufferedReader = BufferedReader(inputStreamReader)
                var receiveString: String? = ""
                val stringBuilder = StringBuilder()
                while (bufferedReader.readLine().also { receiveString = it } != null) {
                    stringBuilder.append(receiveString)
                }
                ret = stringBuilder.toString()
            }
        } catch (e: FileNotFoundException) {
            Log.e("login activity", "File not found: " + e.toString())
        } catch (e: IOException) {
            Log.e("login activity", "Can not read file: $e")
        } finally {
            try {
                inputStream!!.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return ret
    }

    private fun writeFileOnInternalStorage(file:String, data:String, context: Context) {
        val fOut: FileOutputStream = context.openFileOutput(file, MODE_PRIVATE
        )
        fOut.write(data.toByteArray())
        fOut.close()
    }
}