package com.root14.img2ascii_art

import android.graphics.Bitmap
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class LoadImg {

    companion object {
        val default =
            "https://w7.pngwing.com/pngs/823/717/png-transparent-rick-and-morty-illustration-morty-smith-rick-sanchez-tote-bag-handbag-dancing-child-hand-accessories.png"

        fun loadImg(url: String = default): Flow<Bitmap> = flow {
            emit(Picasso.get().load(url).get())
        }
    }
}