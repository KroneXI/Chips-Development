package com.example.chips_development.fragments

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chips_development.R
import com.example.chips_development.adapters.ShopsAdapter
import com.example.chips_development.data_classes.ShopsItems
import org.json.JSONArray
import java.io.*


class ShopsFragment : Fragment() {

    private lateinit var shopRecyclerView: RecyclerView
    private lateinit var shopList: ArrayList<ShopsItems>
    private lateinit var shopsAdapter: ShopsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shops, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shopRecyclerView = view.findViewById(R.id.recyclerViewShops)
        shopRecyclerView.layoutManager = LinearLayoutManager(context)
        shopRecyclerView.setHasFixedSize(true)

        shopList = ArrayList()

        getJsonData("shops.json")

        shopsAdapter = ShopsAdapter(shopList)
        shopRecyclerView.adapter = shopsAdapter

        shopsAdapter.setOnItemClickListener(object : ShopsAdapter.onItemClickListener {
            override fun onItemClick(link: String) {
                try {
                    val browserIntent =
                        Intent(Intent.ACTION_VIEW, Uri.parse(link))
                    startActivity(browserIntent)
                } catch (e: ActivityNotFoundException) {
                    Toast.makeText(
                        context, "No application can handle this request."
                                + " Please install a webbrowser", Toast.LENGTH_SHORT
                    ).show()
                    e.printStackTrace()
                }

            }
        })
    }

    private fun getJsonData(fileName: String) {
        val jsonString = context?.let { readFromFile(it, fileName) }
        val jsonArray = JSONArray(jsonString)
        for (i in 0 until jsonArray.length()) {
            val jsonObj = jsonArray.getJSONObject(i)

            shopList.add(
                ShopsItems(
                    shopsName = jsonObj.getString("name"),
                    shopsLink = jsonObj.getString("link"),
                    shopsLogo = jsonObj.getString("image")
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
        println(ret)
        return ret
    }
}