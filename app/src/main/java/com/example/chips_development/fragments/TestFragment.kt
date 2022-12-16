package com.example.chips_development.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chips_development.R
import com.example.chips_development.adapters.TestsAdapter
import com.example.chips_development.data_classes.TestsItems
import org.json.JSONArray
import java.io.*

class TestFragment : Fragment() {

    private lateinit var testsRecyclerView: RecyclerView
    private lateinit var testsArrayList: ArrayList<TestsItems>
    private lateinit var testsAdapter: TestsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        testsRecyclerView = view.findViewById(R.id.recyclerViewTests)
        testsRecyclerView.layoutManager = LinearLayoutManager(context)
        testsRecyclerView.setHasFixedSize(true)

        testsArrayList = ArrayList()

        getJsonData()

        testsAdapter = TestsAdapter(testsArrayList)
        testsRecyclerView.adapter = testsAdapter
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
        val fileName = getFileForCurUser() + "test.json"
        val jsonString = context?.let { readFromFile(it, fileName) }
        val jsonArray = JSONArray(jsonString)
        for (i in 0 until jsonArray.length()) {
            val jsonObj = jsonArray.getJSONObject(i)

            testsArrayList.add(
                TestsItems(
                    theme_name = jsonObj.getString("theme_name"),
                    status = jsonObj.getString("status"),
                    question1 = jsonObj.getString("question1"),
                    status_question1 = jsonObj.getString("status_question1"),
                    var1_question1 = jsonObj.getString("var1_question1"),
                    status_var1_question1 = jsonObj.getString("status_var1_question1"),
                    var2_question1 = jsonObj.getString("var2_question1"),
                    status_var2_question1 = jsonObj.getString("status_var2_question1"),
                    var3_question1 = jsonObj.getString("var3_question1"),
                    status_var3_question1 = jsonObj.getString("status_var3_question1"),
                    var4_question1 = jsonObj.getString("var4_question1"),
                    status_var4_question1 = jsonObj.getString("status_var4_question1"),
                    question2 = jsonObj.getString("question2"),
                    status_question2 = jsonObj.getString("status_question2"),
                    var1_question2 = jsonObj.getString("var1_question2"),
                    status_var1_question2 = jsonObj.getString("status_var1_question2"),
                    var2_question2 = jsonObj.getString("var2_question2"),
                    status_var2_question2 = jsonObj.getString("status_var2_question2"),
                    var3_question2 = jsonObj.getString("var3_question2"),
                    status_var3_question2 = jsonObj.getString("status_var3_question2"),
                    var4_question2 = jsonObj.getString("var4_question2"),
                    status_var4_question2 = jsonObj.getString("status_var4_question2"),
                    question3 = jsonObj.getString("question3"),
                    status_question3 = jsonObj.getString("status_question3"),
                    var1_question3 = jsonObj.getString("var1_question3"),
                    status_var1_question3 = jsonObj.getString("status_var1_question3"),
                    var2_question3 = jsonObj.getString("var2_question3"),
                    status_var2_question3 = jsonObj.getString("status_var2_question3"),
                    var3_question3 = jsonObj.getString("var3_question3"),
                    status_var3_question3 = jsonObj.getString("status_var3_question3"),
                    var4_question3 = jsonObj.getString("var4_question3"),
                    status_var4_question3 = jsonObj.getString("status_var4_question3"),
                    question4 = jsonObj.getString("question4"),
                    status_question4 = jsonObj.getString("status_question4"),
                    var1_question4 = jsonObj.getString("var1_question4"),
                    status_var1_question4 = jsonObj.getString("status_var1_question4"),
                    var2_question4 = jsonObj.getString("var2_question4"),
                    status_var2_question4 = jsonObj.getString("status_var2_question4"),
                    var3_question4 = jsonObj.getString("var3_question4"),
                    status_var3_question4 = jsonObj.getString("status_var3_question4"),
                    var4_question4 = jsonObj.getString("var4_question4"),
                    status_var4_question4 = jsonObj.getString("status_var4_question4"),
                    question5 = jsonObj.getString("question5"),
                    status_question5 = jsonObj.getString("status_question5"),
                    var1_question5 = jsonObj.getString("var1_question5"),
                    status_var1_question5 = jsonObj.getString("status_var1_question5"),
                    var2_question5 = jsonObj.getString("var2_question5"),
                    status_var2_question5 = jsonObj.getString("status_var2_question5"),
                    var3_question5 = jsonObj.getString("var3_question5"),
                    status_var3_question5 = jsonObj.getString("status_var3_question5"),
                    var4_question5 = jsonObj.getString("var4_question5"),
                    status_var4_question5 = jsonObj.getString("status_var4_question5")
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