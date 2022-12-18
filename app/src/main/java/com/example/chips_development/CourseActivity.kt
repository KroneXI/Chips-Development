package com.example.chips_development

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import org.json.JSONArray
import java.io.*

class CourseActivity : AppCompatActivity() {

    private var statusCourse: ImageView? = null
    private var openCourseButton: ImageButton? = null
    private var courseName: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        statusCourse = findViewById(R.id.statusCourse)
        openCourseButton = findViewById(R.id.openCourseButton)
        courseName = findViewById(R.id.courseName)

        openCourseButton?.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 100)
        }
    }

    override fun onResume() {
        super.onResume()

        val percent = (getMainProgress() + getTestProgress()) / 2

        statusCourse?.setImageResource(
            if (percent.toString() != "100") R.drawable.ic_baseline_circle_grey
            else R.drawable.ic_baseline_circle_green
        )
    }

    private fun getMainProgress(): Int {
        val fileName = getFileForCurUser() + "study.json"
        val jsonString = readFromFile(applicationContext, fileName)
        val jsonArray = JSONArray(jsonString)
        var js = 0
        var count = 0
        for (i in 0 until jsonArray.length()) {
            val jsonObj = jsonArray.getJSONObject(i)
            if (jsonObj.getString("check") == "true") {
                js += 1
                count += 1
            }
            if (jsonObj.getString("check") == "false") {
                count += 1
            }
        }
        return ((js.toFloat() / count.toFloat()) * 100).toInt()
    }

    private fun getTestProgress(): Int {
        val fileName = getFileForCurUser() + "test.json"
        val jsonString = readFromFile(applicationContext, fileName)
        val jsonArray = JSONArray(jsonString)
        var js = 0
        var count = 0
        for (i in 0 until jsonArray.length()) {
            val jsonObj = jsonArray.getJSONObject(i)
            if (jsonObj.getString("status") == "true") {
                js += 1
                count += 1
            }
            if (jsonObj.getString("status") == "false") {
                count += 1
            }
        }
        return ((js.toFloat() / count.toFloat()) * 100).toInt()
    }

    private fun getFileForCurUser(): String {
        val jsonString = readFromFile(applicationContext, "users.json")
        val jsonArray = JSONArray(jsonString)
        var userName = ""
        for (i in 0 until jsonArray.length()) {
            val jsonObj = jsonArray.getJSONObject(i)
            val state = jsonObj.getString("status")
            val loginUser = jsonObj.getString("login")
            if (state == "true") {
                userName = loginUser
            }
        }
        return userName
    }

    private fun readFromFile(context: Context, fileName: String): String {
        var ret = ""
        var inputStream: InputStream? = null
        try {
            inputStream = context.openFileInput(fileName)
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