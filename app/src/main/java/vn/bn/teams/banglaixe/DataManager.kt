package vn.bn.teams.banglaixe

import android.content.Context
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import vn.bn.teams.banglaixe.models.Question
import vn.bn.teams.banglaixe.roomdata.learn.Contract
import vn.bn.teams.banglaixe.roomdata.learn.DatabaseProvider
import vn.bn.teams.banglaixe.roomdata.learn.Repository
import vn.bn.teams.banglaixe.utils.JsonReader


object DataManager {
    enum class Loaded {
        SUCCESS, FAILED
    }

    interface OnLoadListener {
        fun onSuccess()
        fun onFailure(e: String)
    }

    var listQuestion: MutableList<Question> = mutableListOf()

    @OptIn(DelicateCoroutinesApi::class)
    fun initialize(
        context: Context,
        onComplete: OnLoadListener
    ) {
        GlobalScope.launch(Dispatchers.IO) {
            listQuestion = JsonReader.readJsonData(context, "json/data.json")
            onComplete.onSuccess()
        }

    }
    private lateinit var presenter: Contract.Presenter

    fun loadDataFromRoom(context: Context,view : Contract.View){
        val repository = Repository(
            DatabaseProvider.getDatabase(context).questionDao(),
            DatabaseProvider.getDatabase(context).answerDao()
        )

    }


}