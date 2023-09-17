package com.root14.img2ascii_art

import android.graphics.Bitmap
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red

class ASCII {
    companion object {
        fun convert(bitmap: Bitmap, negative: Boolean = false): String {

            val sb = StringBuilder((bitmap.width + 1) * bitmap.height)
            for (y in 0 until bitmap.height) {
                if (sb.length != 0) sb.append("\n")
                for (x in 0 until bitmap.width) {
                    val pixelColor = bitmap.getPixel(x, y)
                    val gValue =
                        pixelColor.red.toDouble() * 0.2989 + pixelColor.blue.toDouble() * 0.5870 + pixelColor.green.toDouble() * 0.1140
                    val s = if (negative) returnStrNeg(gValue) else returnStrPos(gValue)
                    sb.append(s)
                }
            }
            return sb.toString()
        }

        private fun returnStrPos(g: Double): Char //takes the grayscale value as parameter
        {
            val str: Char
            str = if (g >= 230.0) {
                ' '
            } else if (g >= 200.0) {
                '.'
            } else if (g >= 180.0) {
                '*'
            } else if (g >= 160.0) {
                ':'
            } else if (g >= 130.0) {
                'o'
            } else if (g >= 100.0) {
                '&'
            } else if (g >= 70.0) {
                '8'
            } else if (g >= 50.0) {
                '#'
            } else {
                '@'
            }
            return str // return the character
        }

        private fun returnStrNeg(g: Double): Char {
            val str: Char
            str = if (g >= 230.0) {
                '@'
            } else if (g >= 200.0) {
                '#'
            } else if (g >= 180.0) {
                '8'
            } else if (g >= 160.0) {
                '&'
            } else if (g >= 130.0) {
                'o'
            } else if (g >= 100.0) {
                ':'
            } else if (g >= 70.0) {
                '*'
            } else if (g >= 50.0) {
                '.'
            } else {
                ' '
            }
            return str
        }
    }


}