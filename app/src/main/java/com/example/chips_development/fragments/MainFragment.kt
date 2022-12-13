package com.example.chips_development.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.chips_development.R
import org.json.JSONArray
import java.io.*

class MainFragment : Fragment() {

    private var progressMain: ProgressBar? = null
    private var progressStudy: ProgressBar? = null
    private var progressTests: ProgressBar? = null

    private var appPercentProgress: TextView? = null

    private var theme1: TextView? = null
    private var theme2: TextView? = null
    private var theme3: TextView? = null
    private var theme4: TextView? = null
    private var theme5: TextView? = null
    private var theme6: TextView? = null
    private var theme7: TextView? = null
    private var theme8: TextView? = null
    private var theme9: TextView? = null
    private var theme10: TextView? = null
    private var theme11: TextView? = null
    private var theme12: TextView? = null
    private var theme13: TextView? = null
    private var theme14: TextView? = null

    private var test1: TextView? = null
    private var test2: TextView? = null
    private var test3: TextView? = null
    private var test4: TextView? = null
    private var test5: TextView? = null
    private var test6: TextView? = null
    private var test7: TextView? = null
    private var test8: TextView? = null
    private var test9: TextView? = null
    private var test10: TextView? = null
    private var test11: TextView? = null
    private var test12: TextView? = null
    private var test13: TextView? = null
    private var test14: TextView? = null
    private var test15: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onResume() {
        super.onResume()

        getStudyTextView()
        getTestTextView()
        setProgress(
            appPercentProgress = appPercentProgress,
            progressbarMain = progressMain,
            progressbarStudy = progressStudy,
            progressbarTest = progressTests
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getItemsFromView(view)
        setInvisible()
    }

    private fun setProgress(
        appPercentProgress: TextView?,
        progressbarMain: ProgressBar?,
        progressbarStudy: ProgressBar?,
        progressbarTest: ProgressBar?
    ) {
        val percent = (getMainProgress() + getTestProgress())/2
        appPercentProgress?.text = "$percent%"
        progressbarMain?.progress = (getMainProgress() + getTestProgress())/2
        progressbarStudy?.progress = getMainProgress()
        progressbarTest?.progress = getTestProgress()
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

    private fun getMainProgress(): Int {
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

    private fun getTestProgress(): Int {
        val jsonString = context?.let { readFromFile(it, "test.json") }
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
        return ((js.toFloat()/count.toFloat())*100).toInt()
    }

    private fun getStudyTextView() {
        val jsonString = context?.let { readFromFile(it, "study.json") }
        val jsonArray = JSONArray(jsonString)
        for (i in 0 until jsonArray.length()) {
            val jsonObj = jsonArray.getJSONObject(i)
            when (i) {
                0 -> theme1?.isVisible = jsonObj.getString("check") == "true"
                1 -> theme2?.isVisible = jsonObj.getString("check") == "true"
                2 -> theme3?.isVisible = jsonObj.getString("check") == "true"
                3 -> theme4?.isVisible = jsonObj.getString("check") == "true"
                4 -> theme5?.isVisible = jsonObj.getString("check") == "true"
                5 -> theme6?.isVisible = jsonObj.getString("check") == "true"
                6 -> theme7?.isVisible = jsonObj.getString("check") == "true"
                7 -> theme8?.isVisible = jsonObj.getString("check") == "true"
                8 -> theme9?.isVisible = jsonObj.getString("check") == "true"
                9 -> theme10?.isVisible = jsonObj.getString("check") == "true"
                10 -> theme11?.isVisible = jsonObj.getString("check") == "true"
                11 -> theme12?.isVisible = jsonObj.getString("check") == "true"
                12 -> theme13?.isVisible = jsonObj.getString("check") == "true"
                13 -> theme14?.isVisible = jsonObj.getString("check") == "true"
                else -> print("")
            }
        }
    }

    private fun getTestTextView() {
        val jsonString = context?.let { readFromFile(it, "test.json") }
        val jsonArray = JSONArray(jsonString)
        for (i in 0 until jsonArray.length()) {
            val jsonObj = jsonArray.getJSONObject(i)
            when (i) {
                0 -> test1?.isVisible = jsonObj.getString("status") == "true"
                1 -> test2?.isVisible = jsonObj.getString("status") == "true"
                2 -> test3?.isVisible = jsonObj.getString("status") == "true"
                3 -> test4?.isVisible = jsonObj.getString("status") == "true"
                4 -> test5?.isVisible = jsonObj.getString("status") == "true"
                5 -> test6?.isVisible = jsonObj.getString("status") == "true"
                6 -> test7?.isVisible = jsonObj.getString("status") == "true"
                7 -> test8?.isVisible = jsonObj.getString("status") == "true"
                8 -> test9?.isVisible = jsonObj.getString("status") == "true"
                9 -> test10?.isVisible = jsonObj.getString("status") == "true"
                10 -> test11?.isVisible = jsonObj.getString("status") == "true"
                11 -> test12?.isVisible = jsonObj.getString("status") == "true"
                12 -> test13?.isVisible = jsonObj.getString("status") == "true"
                13 -> test14?.isVisible = jsonObj.getString("status") == "true"
                else -> print("")
            }
        }
    }

    private fun setInvisible() {
        theme1?.isVisible = false
        theme2?.isVisible = false
        theme3?.isVisible = false
        theme4?.isVisible = false
        theme5?.isVisible = false
        theme6?.isVisible = false
        theme7?.isVisible = false
        theme8?.isVisible = false
        theme9?.isVisible = false
        theme10?.isVisible = false
        theme11?.isVisible = false
        theme12?.isVisible = false
        theme13?.isVisible = false
        theme14?.isVisible = false

        test1?.isVisible = false
        test2?.isVisible = false
        test3?.isVisible = false
        test4?.isVisible = false
        test5?.isVisible = false
        test6?.isVisible = false
        test7?.isVisible = false
        test8?.isVisible = false
        test9?.isVisible = false
        test10?.isVisible = false
        test11?.isVisible = false
        test12?.isVisible = false
        test13?.isVisible = false
        test14?.isVisible = false
        test15?.isVisible = false
    }

    private fun getItemsFromView(view: View) {
        progressMain = view.findViewById(R.id.progress_bar)
        progressStudy = view.findViewById(R.id.verticalProgressbar)
        progressTests = view.findViewById(R.id.verticalProgressbar1)

        appPercentProgress = view.findViewById(R.id.appPercentProgress)

        theme1 = view.findViewById(R.id.theme1)
        theme2 = view.findViewById(R.id.theme2)
        theme3 = view.findViewById(R.id.theme3)
        theme4 = view.findViewById(R.id.theme4)
        theme5 = view.findViewById(R.id.theme5)
        theme6 = view.findViewById(R.id.theme6)
        theme7 = view.findViewById(R.id.theme7)
        theme8 = view.findViewById(R.id.theme8)
        theme9 = view.findViewById(R.id.theme9)
        theme10 = view.findViewById(R.id.theme10)
        theme11 = view.findViewById(R.id.theme11)
        theme12 = view.findViewById(R.id.theme12)
        theme13 = view.findViewById(R.id.theme13)
        theme14 = view.findViewById(R.id.theme14)

        test1 = view.findViewById(R.id.test1)
        test2 = view.findViewById(R.id.test2)
        test3 = view.findViewById(R.id.test3)
        test4 = view.findViewById(R.id.test4)
        test5 = view.findViewById(R.id.test5)
        test6 = view.findViewById(R.id.test6)
        test7 = view.findViewById(R.id.test7)
        test8 = view.findViewById(R.id.test8)
        test9 = view.findViewById(R.id.test9)
        test10 = view.findViewById(R.id.test10)
        test11 = view.findViewById(R.id.test11)
        test12 = view.findViewById(R.id.test12)
        test13 = view.findViewById(R.id.test13)
        test14 = view.findViewById(R.id.test14)
        test15 = view.findViewById(R.id.test15)
    }
}