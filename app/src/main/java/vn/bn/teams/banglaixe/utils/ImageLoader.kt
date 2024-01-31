package vn.bn.teams.banglaixe.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.IOException

fun loadImageFromAssets(context: Context, fileName: String): Bitmap? {
    val assetManager = context.assets
    val inputStream = try {
        assetManager.open("imv/$fileName")
    } catch (e: IOException) {
        e.printStackTrace()
        return null
    }

    return BitmapFactory.decodeStream(inputStream)
}