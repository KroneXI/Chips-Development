package com.example.chips_development.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chips_development.R
import com.example.chips_development.adapters.StudyMainAdapter
import com.example.chips_development.data_classes.StudyMainItems
import org.json.JSONArray
import java.io.*


class StudyFragment : Fragment() {

    private lateinit var studyMainRecyclerView: RecyclerView
    private lateinit var studyMainArrayList: ArrayList<StudyMainItems>
    private lateinit var studyMainAdapter: StudyMainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_study, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        studyMainRecyclerView = view.findViewById(R.id.recyclerViewStudyMain)
        studyMainRecyclerView.layoutManager = LinearLayoutManager(context)
        studyMainRecyclerView.setHasFixedSize(true)

        studyMainArrayList = ArrayList()

        getJsonData()

        studyMainAdapter = StudyMainAdapter(studyMainArrayList)
        studyMainRecyclerView.adapter = studyMainAdapter
    }

    private fun getFileForCurUser(): String {
        val jsonString = context?.let { readFromFile(it, "users.json") }
        val jsonArray = JSONArray(jsonString)
        var userName = ""
        for (i in 0 until jsonArray.length()) {
            val jsonObj = jsonArray.getJSONObject(i)
            val state = jsonObj.getString("status")
            val loginUser = jsonObj.getString("login")
            if (state == "true") {
                userName  = loginUser
            }
        }
        return userName
    }

    private fun getJsonData() {
        val fileName = getFileForCurUser() + "study.json"
        val jsonString = context?.let { readFromFile(it, fileName) }
        val jsonArray = JSONArray(jsonString)
        for (i in 0 until jsonArray.length()) {
            val jsonObj = jsonArray.getJSONObject(i)

            studyMainArrayList.add(
                StudyMainItems(
                    name = jsonObj.getString("name"),
                    themes = jsonObj.getString("themes"),
                    check = jsonObj.getString("check"),
                    lessonTextStart = jsonObj.getString("lessonTextStart"),
                    lessonImageStart = jsonObj.getString("lessonImageStart"),
                    lessonTextMid = jsonObj.getString("lessonTextMid"),
                    lessonImageMid = jsonObj.getString("lessonImageMid")
                )
            )
        }
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