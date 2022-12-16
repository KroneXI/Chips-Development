package com.example.chips_development.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.chips_development.R
import com.example.chips_development.data_classes.TestsItems
import org.json.JSONArray
import java.io.*


class TestsAdapter(private val testsList: ArrayList<TestsItems>) :
    RecyclerView.Adapter<TestsAdapter.TestsViewHolder>() {

    private val collapseMap = HashMap<String, Boolean>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_tests,
            parent, false
        )
        return TestsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TestsViewHolder, position: Int) {
        var count = 0
        val resultArray: ArrayList<String> = ArrayList()
        val currentItem = testsList[position]

        holder.theme_name.text = currentItem.theme_name
        if (currentItem.status == "false") holder.status.setImageResource(R.drawable.ic_baseline_circle_grey)
        else holder.status.setImageResource(R.drawable.ic_baseline_circle_green)

        holder.question1.text = currentItem.question1
        holder.question2.text = currentItem.question2
        holder.question3.text = currentItem.question3
        holder.question4.text = currentItem.question4
        holder.question5.text = currentItem.question5

        val isCollapsed = collapseMap.getOrDefault(currentItem.question1, false)
        holder.question1.isVisible = isCollapsed
        holder.openTestButton.setImageResource(
            if (isCollapsed) R.drawable.ic_baseline_arrow_drop_up_24
            else R.drawable.ic_baseline_arrow_drop_down_24
        )
        holder.linearLayout1.isVisible = isCollapsed

        holder.openTestButton.setOnClickListener {
            val wasCollapsed = collapseMap.getOrDefault(currentItem.question1, false)
            holder.question1.isVisible = !wasCollapsed
            holder.linearLayout1.isVisible = !wasCollapsed
            collapseMap[currentItem.question1] = !wasCollapsed
            holder.openTestButton.setImageResource(
                if (wasCollapsed) R.drawable.ic_baseline_arrow_drop_down_24
                else {
                    R.drawable.ic_baseline_arrow_drop_up_24
                }
            )
        }

        holder.var1_question1.text = currentItem.var1_question1
        holder.var2_question1.text = currentItem.var2_question1
        holder.var3_question1.text = currentItem.var3_question1
        holder.var4_question1.text = currentItem.var4_question1
        holder.var1_question2.text = currentItem.var1_question2
        holder.var2_question2.text = currentItem.var2_question2
        holder.var3_question2.text = currentItem.var3_question2
        holder.var4_question2.text = currentItem.var4_question2
        holder.var1_question3.text = currentItem.var1_question3
        holder.var2_question3.text = currentItem.var2_question3
        holder.var3_question3.text = currentItem.var3_question3
        holder.var4_question3.text = currentItem.var4_question3
        holder.var1_question4.text = currentItem.var1_question4
        holder.var2_question4.text = currentItem.var2_question4
        holder.var3_question4.text = currentItem.var3_question4
        holder.var4_question4.text = currentItem.var4_question4
        holder.var1_question5.text = currentItem.var1_question5
        holder.var2_question5.text = currentItem.var2_question5
        holder.var3_question5.text = currentItem.var3_question5
        holder.var4_question5.text = currentItem.var4_question5

        holder.status_var1_question1.text = currentItem.status_var1_question1
        holder.status_var2_question1.text = currentItem.status_var2_question1
        holder.status_var3_question1.text = currentItem.status_var3_question1
        holder.status_var4_question1.text = currentItem.status_var4_question1
        holder.status_var1_question2.text = currentItem.status_var1_question2
        holder.status_var2_question2.text = currentItem.status_var2_question2
        holder.status_var3_question2.text = currentItem.status_var3_question2
        holder.status_var4_question2.text = currentItem.status_var4_question2
        holder.status_var1_question3.text = currentItem.status_var1_question3
        holder.status_var2_question3.text = currentItem.status_var2_question3
        holder.status_var3_question3.text = currentItem.status_var3_question3
        holder.status_var4_question3.text = currentItem.status_var4_question3
        holder.status_var1_question4.text = currentItem.status_var1_question4
        holder.status_var2_question4.text = currentItem.status_var2_question4
        holder.status_var3_question4.text = currentItem.status_var3_question4
        holder.status_var4_question4.text = currentItem.status_var4_question4
        holder.status_var1_question5.text = currentItem.status_var1_question5
        holder.status_var2_question5.text = currentItem.status_var2_question5
        holder.status_var3_question5.text = currentItem.status_var3_question5
        holder.status_var4_question5.text = currentItem.status_var4_question5

        if (currentItem.status == "false") {
            holder.var1_question1Button.setImageResource(R.drawable.background)
            holder.var2_question1Button.setImageResource(R.drawable.background)
            holder.var3_question1Button.setImageResource(R.drawable.background)
            holder.var4_question1Button.setImageResource(R.drawable.background)
            holder.var1_question2Button.setImageResource(R.drawable.background)
            holder.var2_question2Button.setImageResource(R.drawable.background)
            holder.var3_question2Button.setImageResource(R.drawable.background)
            holder.var4_question2Button.setImageResource(R.drawable.background)
            holder.var1_question3Button.setImageResource(R.drawable.background)
            holder.var2_question3Button.setImageResource(R.drawable.background)
            holder.var3_question3Button.setImageResource(R.drawable.background)
            holder.var4_question3Button.setImageResource(R.drawable.background)
            holder.var1_question4Button.setImageResource(R.drawable.background)
            holder.var2_question4Button.setImageResource(R.drawable.background)
            holder.var3_question4Button.setImageResource(R.drawable.background)
            holder.var4_question4Button.setImageResource(R.drawable.background)
            holder.var1_question5Button.setImageResource(R.drawable.background)
            holder.var2_question5Button.setImageResource(R.drawable.background)
            holder.var3_question5Button.setImageResource(R.drawable.background)
            holder.var4_question5Button.setImageResource(R.drawable.background)
        }
        else {
            if (currentItem.status_var1_question1 == "true") holder.var1_question1Button.setImageResource(R.drawable.ic_pre_check) else holder.var1_question1Button.setImageResource(R.drawable.background)
            if (currentItem.status_var2_question1 == "true") holder.var2_question1Button.setImageResource(R.drawable.ic_pre_check) else holder.var2_question1Button.setImageResource(R.drawable.background)
            if (currentItem.status_var3_question1 == "true") holder.var3_question1Button.setImageResource(R.drawable.ic_pre_check) else holder.var3_question1Button.setImageResource(R.drawable.background)
            if (currentItem.status_var4_question1 == "true") holder.var4_question1Button.setImageResource(R.drawable.ic_pre_check) else holder.var4_question1Button.setImageResource(R.drawable.background)
            if (currentItem.status_var1_question2 == "true") holder.var1_question2Button.setImageResource(R.drawable.ic_pre_check) else holder.var1_question2Button.setImageResource(R.drawable.background)
            if (currentItem.status_var2_question2 == "true") holder.var2_question2Button.setImageResource(R.drawable.ic_pre_check) else holder.var2_question2Button.setImageResource(R.drawable.background)
            if (currentItem.status_var3_question2 == "true") holder.var3_question2Button.setImageResource(R.drawable.ic_pre_check) else holder.var3_question2Button.setImageResource(R.drawable.background)
            if (currentItem.status_var4_question2 == "true") holder.var4_question2Button.setImageResource(R.drawable.ic_pre_check) else holder.var4_question2Button.setImageResource(R.drawable.background)
            if (currentItem.status_var1_question3 == "true") holder.var1_question3Button.setImageResource(R.drawable.ic_pre_check) else holder.var1_question3Button.setImageResource(R.drawable.background)
            if (currentItem.status_var2_question3 == "true") holder.var2_question3Button.setImageResource(R.drawable.ic_pre_check) else holder.var2_question3Button.setImageResource(R.drawable.background)
            if (currentItem.status_var3_question3 == "true") holder.var3_question3Button.setImageResource(R.drawable.ic_pre_check) else holder.var3_question3Button.setImageResource(R.drawable.background)
            if (currentItem.status_var4_question3 == "true") holder.var4_question3Button.setImageResource(R.drawable.ic_pre_check) else holder.var4_question3Button.setImageResource(R.drawable.background)
            if (currentItem.status_var1_question4 == "true") holder.var1_question4Button.setImageResource(R.drawable.ic_pre_check) else holder.var1_question4Button.setImageResource(R.drawable.background)
            if (currentItem.status_var2_question4 == "true") holder.var2_question4Button.setImageResource(R.drawable.ic_pre_check) else holder.var2_question4Button.setImageResource(R.drawable.background)
            if (currentItem.status_var3_question4 == "true") holder.var3_question4Button.setImageResource(R.drawable.ic_pre_check) else holder.var3_question4Button.setImageResource(R.drawable.background)
            if (currentItem.status_var4_question4 == "true") holder.var4_question4Button.setImageResource(R.drawable.ic_pre_check) else holder.var4_question4Button.setImageResource(R.drawable.background)
            if (currentItem.status_var1_question5 == "true") holder.var1_question5Button.setImageResource(R.drawable.ic_pre_check) else holder.var1_question5Button.setImageResource(R.drawable.background)
            if (currentItem.status_var2_question5 == "true") holder.var2_question5Button.setImageResource(R.drawable.ic_pre_check) else holder.var2_question5Button.setImageResource(R.drawable.background)
            if (currentItem.status_var3_question5 == "true") holder.var3_question5Button.setImageResource(R.drawable.ic_pre_check) else holder.var3_question5Button.setImageResource(R.drawable.background)
            if (currentItem.status_var4_question5 == "true") holder.var4_question5Button.setImageResource(R.drawable.ic_pre_check) else holder.var4_question5Button.setImageResource(R.drawable.background)
        }

        if (currentItem.status == "false") {
            holder.status_question1.setImageResource(R.drawable.ic_baseline_circle_grey)
            holder.status_question2.setImageResource(R.drawable.ic_baseline_circle_grey)
            holder.status_question3.setImageResource(R.drawable.ic_baseline_circle_grey)
            holder.status_question4.setImageResource(R.drawable.ic_baseline_circle_grey)
            holder.status_question5.setImageResource(R.drawable.ic_baseline_circle_grey)
        }
        else {
            holder.status_question1.setImageResource(R.drawable.ic_baseline_circle_green)
            holder.status_question2.setImageResource(R.drawable.ic_baseline_circle_green)
            holder.status_question3.setImageResource(R.drawable.ic_baseline_circle_green)
            holder.status_question4.setImageResource(R.drawable.ic_baseline_circle_green)
            holder.status_question5.setImageResource(R.drawable.ic_baseline_circle_green)
        }

        if (currentItem.status == "false") {
            holder.var1_question1Button.setOnClickListener {
                holder.var1_question1Button.setImageResource(R.drawable.ic_pre_check)
                firstBlockSetNonClickable(holder)
                count += 1
                if (currentItem.status_var1_question1 == "true") oneQuestionSetTrue(resultArray)
            }
            holder.var2_question1Button.setOnClickListener {
                holder.var2_question1Button.setImageResource(R.drawable.ic_pre_check)
                firstBlockSetNonClickable(holder)
                count += 1
                if (currentItem.status_var2_question1 == "true") oneQuestionSetTrue(resultArray)
            }
            holder.var3_question1Button.setOnClickListener {
                holder.var3_question1Button.setImageResource(R.drawable.ic_pre_check)
                firstBlockSetNonClickable(holder)
                count += 1
                if (currentItem.status_var3_question1 == "true") oneQuestionSetTrue(resultArray)
            }
            holder.var4_question1Button.setOnClickListener {
                holder.var4_question1Button.setImageResource(R.drawable.ic_pre_check)
                firstBlockSetNonClickable(holder)
                count += 1
                if (currentItem.status_var4_question1 == "true") oneQuestionSetTrue(resultArray)
            }

            holder.var1_question2Button.setOnClickListener {
                holder.var1_question2Button.setImageResource(R.drawable.ic_pre_check)
                secondBlockSetNonClickable(holder)
                count += 1
                if (currentItem.status_var1_question2 == "true") twoQuestionSetTrue(resultArray)
            }
            holder.var2_question2Button.setOnClickListener {
                holder.var2_question2Button.setImageResource(R.drawable.ic_pre_check)
                secondBlockSetNonClickable(holder)
                count += 1
                if (currentItem.status_var2_question2 == "true") twoQuestionSetTrue(resultArray)
            }
            holder.var3_question2Button.setOnClickListener {
                holder.var3_question2Button.setImageResource(R.drawable.ic_pre_check)
                secondBlockSetNonClickable(holder)
                count += 1
                if (currentItem.status_var3_question2 == "true") twoQuestionSetTrue(resultArray)
            }
            holder.var4_question2Button.setOnClickListener {
                holder.var4_question2Button.setImageResource(R.drawable.ic_pre_check)
                secondBlockSetNonClickable(holder)
                count += 1
                if (currentItem.status_var4_question2 == "true") twoQuestionSetTrue(resultArray)
            }
            holder.var1_question3Button.setOnClickListener {
                holder.var1_question3Button.setImageResource(R.drawable.ic_pre_check)
                thirdBlockSetNonClickable(holder)
                count += 1
                if (currentItem.status_var1_question3 == "true") threeQuestionSetTrue(resultArray)
            }
            holder.var2_question3Button.setOnClickListener {
                holder.var2_question3Button.setImageResource(R.drawable.ic_pre_check)
                thirdBlockSetNonClickable(holder)
                count += 1
                if (currentItem.status_var2_question3 == "true") threeQuestionSetTrue(resultArray)
            }
            holder.var3_question3Button.setOnClickListener {
                holder.var3_question3Button.setImageResource(R.drawable.ic_pre_check)
                thirdBlockSetNonClickable(holder)
                count += 1
                if (currentItem.status_var3_question3 == "true") threeQuestionSetTrue(resultArray)
            }
            holder.var4_question3Button.setOnClickListener {
                holder.var4_question3Button.setImageResource(R.drawable.ic_pre_check)
                thirdBlockSetNonClickable(holder)
                count += 1
                if (currentItem.status_var4_question3 == "true") threeQuestionSetTrue(resultArray)
            }

            holder.var1_question4Button.setOnClickListener {
                holder.var1_question4Button.setImageResource(R.drawable.ic_pre_check)
                forBlockSetNonClickable(holder)
                count += 1
                if (currentItem.status_var1_question4 == "true") fourQuestionSetTrue(resultArray)
            }
            holder.var2_question4Button.setOnClickListener {
                holder.var2_question4Button.setImageResource(R.drawable.ic_pre_check)
                forBlockSetNonClickable(holder)
                count += 1
                if (currentItem.status_var2_question4 == "true") fourQuestionSetTrue(resultArray)
            }
            holder.var3_question4Button.setOnClickListener {
                holder.var3_question4Button.setImageResource(R.drawable.ic_pre_check)
                forBlockSetNonClickable(holder)
                count += 1
                if (currentItem.status_var3_question4 == "true") fourQuestionSetTrue(resultArray)
            }
            holder.var4_question4Button.setOnClickListener {
                holder.var4_question4Button.setImageResource(R.drawable.ic_pre_check)
                forBlockSetNonClickable(holder)
                count += 1
                if (currentItem.status_var4_question4 == "true") fourQuestionSetTrue(resultArray)
            }

            holder.var1_question5Button.setOnClickListener {
                if (count < 4) Toast.makeText(holder.itemView.context, "Ответьте на предыдущие вопросы", Toast.LENGTH_LONG).show()
                else {
                    holder.var1_question5Button.setImageResource(R.drawable.ic_pre_check)
                    fiveBlockSetNonClickable(holder)
                    if (currentItem.status_var1_question5 == "true") fiveQuestionSetTrue(resultArray)
                    drawResult(resultArray, holder, position)
                }
            }
            holder.var2_question5Button.setOnClickListener {
                if (count < 4) Toast.makeText(holder.itemView.context, "Ответьте на предыдущие вопросы", Toast.LENGTH_LONG).show()
                else {
                    holder.var2_question5Button.setImageResource(R.drawable.ic_pre_check)
                    fiveBlockSetNonClickable(holder)
                    if (currentItem.status_var2_question5 == "true") fiveQuestionSetTrue(resultArray)
                    drawResult(resultArray, holder, position)
                }
            }
            holder.var3_question5Button.setOnClickListener {
                if (count < 4) Toast.makeText(holder.itemView.context, "Ответьте на предыдущие вопросы", Toast.LENGTH_LONG).show()
                else {
                    holder.var3_question5Button.setImageResource(R.drawable.ic_pre_check)
                    fiveBlockSetNonClickable(holder)
                    if (currentItem.status_var3_question5 == "true") fiveQuestionSetTrue(resultArray)
                    drawResult(resultArray, holder, position)
                }
            }
            holder.var4_question5Button.setOnClickListener {
                if (count < 4) Toast.makeText(holder.itemView.context, "Ответьте на предыдущие вопросы", Toast.LENGTH_LONG).show()
                else {
                    holder.var4_question5Button.setImageResource(R.drawable.ic_pre_check)
                    fiveBlockSetNonClickable(holder)
                    if (currentItem.status_var4_question5 == "true") fiveQuestionSetTrue(resultArray)
                    drawResult(resultArray, holder, position)
                }
            }
        }
        else {
            holder.var1_question1Button.isClickable = false
            holder.var2_question1Button.isClickable = false
            holder.var3_question1Button.isClickable = false
            holder.var4_question1Button.isClickable = false
            holder.var1_question2Button.isClickable = false
            holder.var2_question2Button.isClickable = false
            holder.var3_question2Button.isClickable = false
            holder.var4_question2Button.isClickable = false
            holder.var1_question3Button.isClickable = false
            holder.var2_question3Button.isClickable = false
            holder.var3_question3Button.isClickable = false
            holder.var4_question3Button.isClickable = false
            holder.var1_question4Button.isClickable = false
            holder.var2_question4Button.isClickable = false
            holder.var3_question4Button.isClickable = false
            holder.var4_question4Button.isClickable = false
            holder.var1_question5Button.isClickable = false
            holder.var2_question5Button.isClickable = false
            holder.var3_question5Button.isClickable = false
            holder.var4_question5Button.isClickable = false
        }
    }

    private fun drawResult(
        resultArray: ArrayList<String>,
        holder: TestsViewHolder,
        position: Int
    ) {
        for (result in resultArray) {
            when (result) {
                "one" -> holder.status_question1.setImageResource(R.drawable.ic_baseline_circle_green)
                "two" -> holder.status_question2.setImageResource(R.drawable.ic_baseline_circle_green)
                "three" -> holder.status_question3.setImageResource(R.drawable.ic_baseline_circle_green)
                "four" -> holder.status_question4.setImageResource(R.drawable.ic_baseline_circle_green)
                "five" -> holder.status_question5.setImageResource(R.drawable.ic_baseline_circle_green)
            }
        }
        if (resultArray.size == 5) {
            for (test in testsList) {
                if (test == testsList[position]) {
                    val fileName = getFileForCurUser(context = holder.itemView.context) + "test.json"
                    val jsonString = readFromFile(holder.itemView.context, fileName)
                    val jsonArray = JSONArray(jsonString)
                    var js = ""
                    for (i in 0 until jsonArray.length()) {
                        val jsonObj = jsonArray.getJSONObject(i)
                        if (test.theme_name != jsonObj.getString("theme_name")) {
                            js += jsonObj.toString()
                        }
                        if (test.theme_name == jsonObj.getString("theme_name")) {
                            val string = jsonObj.toString()
                            val result = string.replace(
                                "\"status\":\"false\"",
                                "\"status\":\"true\"",
                                true
                            )
                            js += result
                        }
                    }
                    val string = js

                    val preResult = string.replace(
                        "\"}{\"",
                        "\"},{\"",
                        true
                    )
                    val result = "[$preResult]"
                    print(result)

                    writeFileOnInternalStorage(file = fileName, data = result, context = holder.itemView.context)
                }
            }
            holder.status.setImageResource(R.drawable.ic_baseline_circle_green)
            Toast.makeText(holder.itemView.context, "Поздравляем! Tест пройден", Toast.LENGTH_LONG)
                .show()
        } else Toast.makeText(
            holder.itemView.context,
            "Вы неудачно завершили тест",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun oneQuestionSetTrue(
        resultArray: ArrayList<String>
    ) {
        resultArray.add("one")
    }
    private fun twoQuestionSetTrue(
        resultArray: ArrayList<String>
    ) {
        resultArray.add("two")
    }
    private fun threeQuestionSetTrue(
        resultArray: ArrayList<String>
    ) {
        resultArray.add("three")
    }
    private fun fourQuestionSetTrue(
        resultArray: ArrayList<String>
    ) {
        resultArray.add("four")
    }
    private fun fiveQuestionSetTrue(
        resultArray: ArrayList<String>
    ) {
        resultArray.add("five")
    }

    private fun firstBlockSetNonClickable(holder: TestsViewHolder) {
        holder.var1_question1Button.isClickable = false
        holder.var2_question1Button.isClickable = false
        holder.var3_question1Button.isClickable = false
        holder.var4_question1Button.isClickable = false
    }
    private fun secondBlockSetNonClickable(holder: TestsViewHolder) {
        holder.var1_question2Button.isClickable = false
        holder.var2_question2Button.isClickable = false
        holder.var3_question2Button.isClickable = false
        holder.var4_question2Button.isClickable = false
    }
    private fun thirdBlockSetNonClickable(holder: TestsViewHolder) {
        holder.var1_question3Button.isClickable = false
        holder.var2_question3Button.isClickable = false
        holder.var3_question3Button.isClickable = false
        holder.var4_question3Button.isClickable = false
    }
    private fun forBlockSetNonClickable(holder: TestsViewHolder) {
        holder.var1_question4Button.isClickable = false
        holder.var2_question4Button.isClickable = false
        holder.var3_question4Button.isClickable = false
        holder.var4_question4Button.isClickable = false
    }
    private fun fiveBlockSetNonClickable(holder: TestsViewHolder) {
        holder.var1_question5Button.isClickable = false
        holder.var2_question5Button.isClickable = false
        holder.var3_question5Button.isClickable = false
        holder.var4_question5Button.isClickable = false
    }

    override fun getItemCount(): Int {
        return testsList.size
    }

    class TestsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val linearLayout1: LinearLayout = itemView.findViewById(R.id.linearLayout1)
        val theme_name: TextView = itemView.findViewById(R.id.theme_name)
        val status: ImageView = itemView.findViewById(R.id.status)
        val openTestButton: ImageButton = itemView.findViewById(R.id.openTestButton)
        val question1: TextView = itemView.findViewById(R.id.question1)
        val status_question1: ImageView = itemView.findViewById(R.id.status_question1)
        val var1_question1: TextView = itemView.findViewById(R.id.var1_question1)
        val status_var1_question1: TextView = itemView.findViewById(R.id.status_var1_question1)
        val var1_question1Button: ImageButton = itemView.findViewById(R.id.var1_question1Button)
        val var2_question1: TextView = itemView.findViewById(R.id.var2_question1)
        val status_var2_question1: TextView = itemView.findViewById(R.id.status_var2_question1)
        val var2_question1Button: ImageButton = itemView.findViewById(R.id.var2_question1Button)
        val var3_question1: TextView = itemView.findViewById(R.id.var3_question1)
        val status_var3_question1: TextView = itemView.findViewById(R.id.status_var3_question1)
        val var3_question1Button: ImageButton = itemView.findViewById(R.id.var3_question1Button)
        val var4_question1: TextView = itemView.findViewById(R.id.var4_question1)
        val status_var4_question1: TextView = itemView.findViewById(R.id.status_var4_question1)
        val var4_question1Button: ImageButton = itemView.findViewById(R.id.var4_question1Button)
        val question2: TextView = itemView.findViewById(R.id.question2)
        val status_question2: ImageView = itemView.findViewById(R.id.status_question2)
        val var1_question2: TextView = itemView.findViewById(R.id.var1_question2)
        val status_var1_question2: TextView = itemView.findViewById(R.id.status_var1_question2)
        val var1_question2Button: ImageButton = itemView.findViewById(R.id.var1_question2Button)
        val var2_question2: TextView = itemView.findViewById(R.id.var2_question2)
        val status_var2_question2: TextView = itemView.findViewById(R.id.status_var2_question2)
        val var2_question2Button: ImageButton = itemView.findViewById(R.id.var2_question2Button)
        val var3_question2: TextView = itemView.findViewById(R.id.var3_question2)
        val status_var3_question2: TextView = itemView.findViewById(R.id.status_var3_question2)
        val var3_question2Button: ImageButton = itemView.findViewById(R.id.var3_question2Button)
        val var4_question2: TextView = itemView.findViewById(R.id.var4_question2)
        val status_var4_question2: TextView = itemView.findViewById(R.id.status_var4_question2)
        val var4_question2Button: ImageButton = itemView.findViewById(R.id.var4_question2Button)
        val question3: TextView = itemView.findViewById(R.id.question3)
        val status_question3: ImageView = itemView.findViewById(R.id.status_question3)
        val var1_question3: TextView = itemView.findViewById(R.id.var1_question3)
        val status_var1_question3: TextView = itemView.findViewById(R.id.status_var1_question3)
        val var1_question3Button: ImageButton = itemView.findViewById(R.id.var1_question3Button)
        val var2_question3: TextView = itemView.findViewById(R.id.var2_question3)
        val status_var2_question3: TextView = itemView.findViewById(R.id.status_var2_question3)
        val var2_question3Button: ImageButton = itemView.findViewById(R.id.var2_question3Button)
        val var3_question3: TextView = itemView.findViewById(R.id.var3_question3)
        val status_var3_question3: TextView = itemView.findViewById(R.id.status_var3_question3)
        val var3_question3Button: ImageButton = itemView.findViewById(R.id.var3_question3Button)
        val var4_question3: TextView = itemView.findViewById(R.id.var4_question3)
        val status_var4_question3: TextView = itemView.findViewById(R.id.status_var4_question3)
        val var4_question3Button: ImageButton = itemView.findViewById(R.id.var4_question3Button)
        val question4: TextView = itemView.findViewById(R.id.question4)
        val status_question4: ImageView = itemView.findViewById(R.id.status_question4)
        val var1_question4: TextView = itemView.findViewById(R.id.var1_question4)
        val status_var1_question4: TextView = itemView.findViewById(R.id.status_var1_question4)
        val var1_question4Button: ImageButton = itemView.findViewById(R.id.var1_question4Button)
        val var2_question4: TextView = itemView.findViewById(R.id.var2_question4)
        val status_var2_question4: TextView = itemView.findViewById(R.id.status_var2_question4)
        val var2_question4Button: ImageButton = itemView.findViewById(R.id.var2_question4Button)
        val var3_question4: TextView = itemView.findViewById(R.id.var3_question4)
        val status_var3_question4: TextView = itemView.findViewById(R.id.status_var3_question4)
        val var3_question4Button: ImageButton = itemView.findViewById(R.id.var3_question4Button)
        val var4_question4: TextView = itemView.findViewById(R.id.var4_question4)
        val status_var4_question4: TextView = itemView.findViewById(R.id.status_var4_question4)
        val var4_question4Button: ImageButton = itemView.findViewById(R.id.var4_question4Button)
        val question5: TextView = itemView.findViewById(R.id.question5)
        val status_question5: ImageView = itemView.findViewById(R.id.status_question5)
        val var1_question5: TextView = itemView.findViewById(R.id.var1_question5)
        val status_var1_question5: TextView = itemView.findViewById(R.id.status_var1_question5)
        val var1_question5Button: ImageButton = itemView.findViewById(R.id.var1_question5Button)
        val var2_question5: TextView = itemView.findViewById(R.id.var2_question5)
        val status_var2_question5: TextView = itemView.findViewById(R.id.status_var2_question5)
        val var2_question5Button: ImageButton = itemView.findViewById(R.id.var2_question5Button)
        val var3_question5: TextView = itemView.findViewById(R.id.var3_question5)
        val status_var3_question5: TextView = itemView.findViewById(R.id.status_var3_question5)
        val var3_question5Button: ImageButton = itemView.findViewById(R.id.var3_question5Button)
        val var4_question5: TextView = itemView.findViewById(R.id.var4_question5)
        val status_var4_question5: TextView = itemView.findViewById(R.id.status_var4_question5)
        val var4_question5Button: ImageButton = itemView.findViewById(R.id.var4_question5Button)
    }

    private fun writeFileOnInternalStorage(file:String, data:String, context: Context) {
        val fOut: FileOutputStream = context.openFileOutput(file,
            AppCompatActivity.MODE_PRIVATE
        )
        fOut.write(data.toByteArray())
        fOut.close()
    }

    private fun getFileForCurUser(context: Context): String {
        val jsonString = readFromFile(context, "users.json")
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