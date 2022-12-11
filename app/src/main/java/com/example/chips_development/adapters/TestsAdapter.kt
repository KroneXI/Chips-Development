package com.example.chips_development.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
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
        val currentItem = testsList[position]
//        holder.linearLayout1.isVisible = false
        holder.theme_name.text = currentItem.theme_name
        holder.status.setImageResource(R.drawable.ic_baseline_circle_grey)

        holder.question1.text = currentItem.question1
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

        holder.status_question1.setImageResource(R.drawable.ic_baseline_circle_grey)
        holder.var1_question1.text = currentItem.var1_question1
        holder.status_var1_question1.text = currentItem.status_var1_question1
        holder.var1_question1Button.setImageResource(R.drawable.background)
        holder.var2_question1.text = currentItem.var2_question1
        holder.status_var2_question1.text = currentItem.status_var2_question1
        holder.var2_question1Button.setImageResource(R.drawable.background)
        holder.var3_question1.text = currentItem.var3_question1
        holder.status_var3_question1.text = currentItem.status_var3_question1
        holder.var3_question1Button.setImageResource(R.drawable.background)
        holder.var4_question1.text = currentItem.var4_question1
        holder.status_var4_question1.text = currentItem.status_var4_question1
        holder.var4_question1Button.setImageResource(R.drawable.background)
        holder.question2.text = currentItem.question2
        holder.status_question2.setImageResource(R.drawable.ic_baseline_circle_grey) //
        holder.var1_question2.text = currentItem.var1_question2
        holder.status_var1_question2.text = currentItem.status_var1_question2
        holder.var1_question2Button.setImageResource(R.drawable.background)
        holder.var2_question2.text = currentItem.var2_question2
        holder.status_var2_question2.text = currentItem.status_var2_question2
        holder.var2_question2Button.setImageResource(R.drawable.background)
        holder.var3_question2.text = currentItem.var3_question2
        holder.status_var3_question2.text = currentItem.status_var3_question2
        holder.var3_question2Button.setImageResource(R.drawable.background)
        holder.var4_question2.text = currentItem.var4_question2
        holder.status_var4_question2.text = currentItem.status_var4_question2
        holder.var4_question2Button.setImageResource(R.drawable.background)
        holder.question3.text = currentItem.question3
        holder.status_question3.setImageResource(R.drawable.ic_baseline_circle_grey) //
        holder.var1_question3.text = currentItem.var1_question3
        holder.status_var1_question3.text = currentItem.status_var1_question3
        holder.var1_question3Button.setImageResource(R.drawable.background)
        holder.var2_question3.text = currentItem.var2_question3
        holder.status_var2_question3.text = currentItem.status_var2_question3
        holder.var2_question3Button.setImageResource(R.drawable.background)
        holder.var3_question3.text = currentItem.var3_question3
        holder.status_var3_question3.text = currentItem.status_var3_question3
        holder.var3_question3Button.setImageResource(R.drawable.background)
        holder.var4_question3.text = currentItem.var4_question3
        holder.status_var4_question3.text = currentItem.status_var4_question3
        holder.var4_question3Button.setImageResource(R.drawable.background)
        holder.question4.text = currentItem.question4
        holder.status_question4.setImageResource(R.drawable.ic_baseline_circle_grey) //
        holder.var1_question4.text = currentItem.var1_question4
        holder.status_var1_question4.text = currentItem.status_var1_question4
        holder.var1_question4Button.setImageResource(R.drawable.background)
        holder.var2_question4.text = currentItem.var2_question4
        holder.status_var2_question4.text = currentItem.status_var2_question4
        holder.var2_question4Button.setImageResource(R.drawable.background)
        holder.var3_question4.text = currentItem.var3_question4
        holder.status_var3_question4.text = currentItem.status_var3_question4
        holder.var3_question4Button.setImageResource(R.drawable.background)
        holder.var4_question4.text = currentItem.var4_question4
        holder.status_var4_question4.text = currentItem.status_var4_question4
        holder.var4_question4Button.setImageResource(R.drawable.background)
        holder.question5.text = currentItem.question5
        holder.status_question5.setImageResource(R.drawable.ic_baseline_circle_grey) //
        holder.var1_question5.text = currentItem.var1_question5
        holder.status_var1_question5.text = currentItem.status_var1_question5
        holder.var1_question5Button.setImageResource(R.drawable.background)
        holder.var2_question5.text = currentItem.var2_question5
        holder.status_var2_question5.text = currentItem.status_var2_question5
        holder.var2_question5Button.setImageResource(R.drawable.background)
        holder.var3_question5.text = currentItem.var3_question5
        holder.status_var3_question5.text = currentItem.status_var3_question5
        holder.var3_question5Button.setImageResource(R.drawable.background)
        holder.var4_question5.text = currentItem.var4_question5
        holder.status_var4_question5.text = currentItem.status_var4_question5
        holder.var4_question5Button.setImageResource(R.drawable.background)
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

    private fun writeFileOnInternalStorage(data:String, context: Context) {
        val fOut: FileOutputStream = context.openFileOutput("test.json",
            AppCompatActivity.MODE_PRIVATE
        )
        fOut.write(data.toByteArray())
        fOut.close()
    }

    private fun readFromFile(context: Context): String {
        var ret = ""
        var inputStream: InputStream? = null
        try {
            inputStream = context.openFileInput("test.json")
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