package com.example.chips_development.fragments

import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chips_development.R
import com.example.chips_development.adapters.ShopsAdapter
import com.example.chips_development.data_classes.ShopsItems

class ShopsFragment : Fragment() {
//    private var link:TextView? = null

    private lateinit var shopRecyclerView: RecyclerView
    private lateinit var shopArrayList: ArrayList<ShopsItems>
    lateinit var nameId: Array<String>
    lateinit var linkId: Array<String>
    lateinit var logoId: Array<Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shops, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameId = arrayOf(
            "test0",
            "test1",
            "test2",
            "test3",
            "test4",
            "test5",
            "test6",
            "test7",
            "test8",
            "test9",
            "test10"
        )
        linkId = arrayOf(
            "https://yandex.ru/maps/-/CCUbbYC9gC",
            "https://yandex.ru/maps/-/CCUbbYC9gC",
            "https://yandex.ru/maps/-/CCUbbYC9gC",
            "https://yandex.ru/maps/-/CCUbbYC9gC",
            "https://yandex.ru/maps/-/CCUbbYC9gC",
            "https://yandex.ru/maps/-/CCUbbYC9gC",
            "https://yandex.ru/maps/-/CCUbbYC9gC",
            "https://yandex.ru/maps/-/CCUbbYC9gC",
            "https://yandex.ru/maps/-/CCUbbYC9gC",
            "https://yandex.ru/maps/-/CCUbbYC9gC",
            "https://yandex.ru/maps/-/CCUbbYC9gC"
        )
        logoId = arrayOf(
            R.drawable.ic_baseline_account_circle_24,
            R.drawable.ic_baseline_account_circle_24,
            R.drawable.ic_baseline_account_circle_24,
            R.drawable.ic_baseline_account_circle_24,
            R.drawable.ic_baseline_account_circle_24,
            R.drawable.ic_baseline_account_circle_24,
            R.drawable.ic_baseline_account_circle_24,
            R.drawable.ic_baseline_account_circle_24,
            R.drawable.ic_baseline_account_circle_24,
            R.drawable.ic_baseline_account_circle_24,
            R.drawable.ic_baseline_account_circle_24
        )

        shopRecyclerView = view.findViewById(R.id.recyclerViewShops)
        shopRecyclerView.layoutManager = LinearLayoutManager(context)
        shopRecyclerView.setHasFixedSize(true)

        shopArrayList = arrayListOf<ShopsItems>()
        getUserData()
    }

    private fun getUserData() {
        for (i in nameId.indices) {
            val shops = ShopsItems(nameId[i], linkId[i], logoId[i])
            shopArrayList.add(shops)
        }
        shopRecyclerView.adapter = ShopsAdapter(shopArrayList)
    }
}