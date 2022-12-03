package com.example.chips_development.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.example.chips_development.R
import org.json.JSONArray
import java.io.*

class MainFragment : Fragment() {

    private var verticalProgressbar: ProgressBar? = null
    private var verticalProgressbar1: ProgressBar? = null
    private var verticalProgressbar2: ProgressBar? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        verticalProgressbar = view.findViewById(R.id.verticalProgressbar)
        verticalProgressbar1 = view.findViewById(R.id.verticalProgressbar1)
        verticalProgressbar2 = view.findViewById(R.id.progress_bar)

        verticalProgressbar?.progress = getMainProgress()
        verticalProgressbar1?.progress = getMainProgress()
        verticalProgressbar2?.progress = getMainProgress()
    }

    override fun onResume() {
        verticalProgressbar?.progress = getMainProgress()
        verticalProgressbar1?.progress = getMainProgress()
        verticalProgressbar2?.progress = getMainProgress()
        super.onResume()
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

    fun getMainProgress(): Int {
        val jsonString = context?.let { readFromFile(it, "study.json") }
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
        return ((js.toFloat()/count.toFloat())*100).toInt()
    }
}