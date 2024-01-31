package vn.bn.teams.banglaixe.roomdata.learn

import android.content.Context
import android.util.Log
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import vn.bn.teams.banglaixe.models.Question

class Presenter(private val view: Contract.View, context: Context) :
    Contract.Presenter {

    val repository = Repository(
        DatabaseProvider.getDatabase(context).questionDao(),
        DatabaseProvider.getDatabase(context).answerDao()
    )

    @OptIn(DelicateCoroutinesApi::class)
    override fun insertData(dataModel: MutableList<Question>) {

        GlobalScope.launch(Dispatchers.IO) {
            for (yourDataModel in dataModel) {
                val yourDataEntity = QuestionEntity(
                    image = yourDataModel.image,
                    no = yourDataModel.no,
                    index = yourDataModel.index,
                    text = yourDataModel.text,
                    tip = yourDataModel.tip,
                    required = yourDataModel.required,
                    topic = yourDataModel.topic,
                    a1 = yourDataModel.a1,
                    a2 = yourDataModel.a2,
                    a3 = yourDataModel.a3,
                    a4 = yourDataModel.a4,
                    b1 = yourDataModel.b1
                )

                val dataId = repository.insertQuestion(yourDataEntity)

                for (answer in yourDataModel.answers) {
                    val answerEntity = AnswerEntity(
                        text = answer.text,
                        correct = answer.correct,
                        parentId = dataId
                    )
                    repository.insertAnswer(answerEntity)
                }
                Log.d("__insert", "insertData: ${yourDataModel.index} ${yourDataModel.topic}")
            }

        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun getData(topic: Long, limit :Int) {
        GlobalScope.launch(Dispatchers.IO) {
            val dataList = repository.getData(topic,limit)
            Log.d("__hihi", "getData: " + dataList.size)
            view.getTopic(dataList)
        }
    }


    override fun checkRoomDb(): Boolean {
        val numberOfItems = repository.getNumberOfItems()
        return numberOfItems >= 500
    }

}
