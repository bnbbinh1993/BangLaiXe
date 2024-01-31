package vn.bn.teams.banglaixe.utils

import android.content.Context

import com.google.gson.Gson

import vn.bn.teams.banglaixe.models.Question
import java.io.BufferedReader

import java.io.InputStreamReader

object JsonReader {

    fun readJsonData(context: Context, fileName: String): MutableList<Question> {
        val json: String = try {
            val inputStream = context.assets.open(fileName)
            val reader = BufferedReader(InputStreamReader(inputStream))
            val stringBuilder = StringBuilder()
            var line: String? = reader.readLine()
            while (line != null) {
                stringBuilder.append(line).append("\n")
                line = reader.readLine()
            }
            stringBuilder.toString()
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }

        return Gson().fromJson(json, QuestionList::class.java).data
    }
}

data class QuestionList(val data: MutableList<Question>)