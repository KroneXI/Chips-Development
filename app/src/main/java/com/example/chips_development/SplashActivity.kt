package com.example.chips_development

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import java.io.FileOutputStream

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {

    private var prefs: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        prefs = getSharedPreferences("com.example.chips_development", MODE_PRIVATE)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler(Looper.getMainLooper()).postDelayed({
        val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

    override fun onResume() {
        super.onResume()
        if (prefs!!.getBoolean("firstrun", true)) {
            // Do first run stuff here then set 'firstrun' as false
            // using the following line to edit/commit prefs
            prefs!!.edit().putBoolean("firstrun", false).commit()

            writeFileOnInternalStorage(file = "users.json", data = "[\n" +
                    "  {\n" +
                    "    \"file\": \"false\",\n" +
                    "    \"status\": \"false\",\n" +
                    "    \"login\": \"root\",\n" +
                    "    \"password\": \"toor\"\n" +
                    "  }\n" +
                    "]", context = applicationContext)

            writeFileOnInternalStorage(file = "shops.json", data = "[\n" +
                    "  {\n" +
                    "    \"name\": \"name1\",\n" +
                    "    \"link\": \"https://www.chipdip.ru/\",\n" +
                    "    \"image\": \"https://s.rbk.ru/v1_companies_s3/resized/550xH/media/trademarks/86b2d8ca-8c46-4d25-a8e8-3336c7ade6f1.jpg\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"name2\",\n" +
                    "    \"link\": \"https://stackoverflow.com/questions/2201917/how-can-i-open-a-url-in-androids-web-browser-from-my-application\",\n" +
                    "    \"image\": \"https://thumb.tildacdn.com/tild3730-6439-4131-b461-353766363539/-/resize/600x/-/format/webp/pic_5.jpg\"\n" +
                    "  }\n" +
                    "]", context = applicationContext)
        }
    }

    private fun writeFileOnInternalStorage(file:String, data:String, context: Context) {
        val fOut: FileOutputStream = context.openFileOutput(file, MODE_PRIVATE
        )
        fOut.write(data.toByteArray())
        fOut.close()
    }
}