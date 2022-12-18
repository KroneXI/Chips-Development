package com.example.chips_development.fragments

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.chips_development.CourseActivity
import com.example.chips_development.LoginActivity
import com.example.chips_development.MainActivity
import com.example.chips_development.R
import org.json.JSONArray
import java.io.*

class AboutFragment : Fragment() {

    private var changeUser: Button? = null
    private var changeCourse: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        changeCourse = view.findViewById(R.id.changeCourse)
        changeCourse?.setOnClickListener{
            requireActivity().run{
                startActivity(Intent(this, CourseActivity::class.java))
                finish()
            }
        }
        changeUser = view.findViewById(R.id.changeUser)
        changeUser?.setOnClickListener{
            val jsonString = context?.let { readFromFile(it) }
            val jsonArray = JSONArray(jsonString)
            var writableString = ""

            for (i in 0 until jsonArray.length()) {
                val jsonObj = jsonArray.getJSONObject(i)

                val jsStatus = jsonObj.getString("status")
                if (jsStatus != "true") {
                    writableString += jsonObj.toString()
                }
                else {
                    val preResultIfCurrent = jsonObj.toString().replace(
                        "\"status\":\"true\"",
                        "\"status\":\"false\"",
                        true
                    )
                    writableString += preResultIfCurrent
                }
            }
            val preResult = writableString.replace(
                "\"}{\"",
                "\"},{\"",
                true
            )
            val result = "[$preResult]"

            writeFileOnInternalStorage(file = "users.json", data = result, context = requireContext())

            requireActivity().run{
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }

    private fun writeFileOnInternalStorage(file:String, data:String, context: Context) {
        val fOut: FileOutputStream = context.openFileOutput(file, MODE_PRIVATE
        )
        fOut.write(data.toByteArray())
        fOut.close()
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
}