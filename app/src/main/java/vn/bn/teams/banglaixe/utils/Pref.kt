package vn.bn.teams.banglaixe.utils

import android.content.Context
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDelegate


open class Pref {

    companion object {


        private const val FILE_NAME = "PREF"
        const val INTRO = "PREF_Intro"
        const val FILTER = "PREF_Filter"
        const val REQUEST_FILTER = "PREF_Request_Filter"
        const val REQUEST_SETTING = "PREF_Request_Setting"



        fun setString(context: Context, key: String, value: String) {
            val preferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
            preferences.edit().putString(key, value).apply()
        }

        fun getString(context: Context, key: String, default: String): String {
            val preferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
            return preferences.getString(key, default).toString()
        }

        fun setBoolean(context: Context, key: String, value: Boolean) {
            val preferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
            preferences.edit().putBoolean(key, value).apply()
        }

        fun getBoolean(context: Context, key: String, default: Boolean): Boolean {
            val preferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
            return preferences.getBoolean(key, default)
        }

        fun setInt(context: Context, key: String, value: Int) {
            val preferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
            preferences.edit().putInt(key, value).apply()
        }

        fun getInt(context: Context, key: String, default: Int): Int {
            val preferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
            return preferences.getInt(key, default)
        }

        fun setLong(context: Context, key: String, value: Long) {
            val preferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
            preferences.edit().putLong(key, value).apply()
        }

        fun getLong(context: Context, key: String, default: Long): Long {
            val preferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
            return preferences.getLong(key, default)
        }
        fun setFullScreen(window :Window,hideNavigation :Boolean){
            if (hideNavigation){
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            }else{
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            }

        }
        fun setNavigationBarColor(window :Window,color:Int){
            window.navigationBarColor = color
        }
        fun setNavigationAndStatusBarColor(window :Window,color:Int){
            window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
            window.statusBarColor = color
            window.navigationBarColor = color
        }



    }

}


