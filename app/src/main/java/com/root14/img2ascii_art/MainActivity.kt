package com.root14.img2ascii_art

import android.os.Bundle
import android.text.TextUtils
import android.util.TypedValue
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runBlocking {
            withContext(Dispatchers.IO) {
                LoadImg.loadImg("https://www.vhv.rs/dpng/d/608-6083505_logo-linux-png-linux-logo-evolution-transparent-png.png")
                    .collect { bitmap ->
                        val asciiArt = ASCII.convert(bitmap)

                        val asciArea = findViewById<TextView>(R.id.tw_ascii_area)

                        asciArea.setTextSize(TypedValue.COMPLEX_UNIT_SP, 0.7F);
                        asciArea.ellipsize = TextUtils.TruncateAt.END;
                        asciArea.text = asciiArt
                    }
            }
        }
    }
}
