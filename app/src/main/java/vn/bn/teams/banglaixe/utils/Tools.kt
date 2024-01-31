package vn.bn.teams.banglaixe.utils

import android.content.Context
import androidx.sqlite.db.SimpleSQLiteQuery
import vn.bn.teams.banglaixe.R
import vn.bn.teams.banglaixe.models.Answer
import vn.bn.teams.banglaixe.models.Intro
import vn.bn.teams.banglaixe.models.Question
import vn.bn.teams.banglaixe.roomdata.learn.DatabaseProvider


open class Tools {

    companion object {
        fun getListIntro(): MutableList<Intro> {
            val it = mutableListOf<Intro>()
            it.add(
                Intro(
                    "Ngày thứ 1",
                    "Dành 8 tiếng học hết các loại biển báo hay gặp. Tập trung vào biển báo cấm, hiệu lệnh, chỉ dẫn, nguy hiểm...",
                    R.mipmap.work
                )
            )
            it.add(
                Intro(
                    "Ngày thứ 2",
                    "Dành 8 tiếng học hết các loại biển báo hay gặp. Tập trung vào biển báo cấm, hiệu lệnh, chỉ dẫn, nguy hiểm...",
                    R.mipmap.work
                )
            )
            it.add(
                Intro(
                    "Ngày thứ 3",
                    "Dành 8 tiếng học hết các loại biển báo hay gặp. Tập trung vào biển báo cấm, hiệu lệnh, chỉ dẫn, nguy hiểm...",
                    R.mipmap.work
                )
            )
            it.add(
                Intro(
                    "Ngày thứ 4",
                    "Dành 8 tiếng học hết các loại biển báo hay gặp. Tập trung vào biển báo cấm, hiệu lệnh, chỉ dẫn, nguy hiểm...",
                    R.mipmap.work
                )
            )
            it.add(
                Intro(
                    "Ngày thứ 5",
                    "Dành 8 tiếng học hết các loại biển báo hay gặp. Tập trung vào biển báo cấm, hiệu lệnh, chỉ dẫn, nguy hiểm...",
                    R.mipmap.work
                )
            )
            return it
        }

        fun generateTestRandom(context: Context): List<Question> {

            val dynamicColumnName = "a1" //a1 mà đang sai :v
            val sqlQuery1 = SimpleSQLiteQuery(
                "SELECT * FROM question WHERE topic = ? AND $dynamicColumnName = ? ORDER BY RANDOM() LIMIT ?",
                arrayOf(1, 0, 2)
            )

            val sqlQuery2 = SimpleSQLiteQuery(
                "SELECT * FROM question WHERE topic = ? AND $dynamicColumnName = ? ORDER BY RANDOM() LIMIT ?",
                arrayOf(1, 0, 7)
            )
            val sqlQuery3 = SimpleSQLiteQuery(
                "SELECT * FROM question WHERE topic = ? AND $dynamicColumnName = ? ORDER BY RANDOM() LIMIT ?",
                arrayOf(2, 0, 1)
            )
            val sqlQuery4 = SimpleSQLiteQuery(
                "SELECT * FROM question WHERE topic = ? AND $dynamicColumnName = ? ORDER BY RANDOM() LIMIT ?",
                arrayOf(3, 0, 1)
            )
            val sqlQuery5 = SimpleSQLiteQuery(
                "SELECT * FROM question WHERE topic = ? AND $dynamicColumnName = ? ORDER BY RANDOM() LIMIT ?",
                arrayOf(4, 0, 1)
            )

            val sqlQuery6 = SimpleSQLiteQuery(
                "SELECT * FROM question WHERE topic = ? AND $dynamicColumnName = ? ORDER BY RANDOM() LIMIT ?",
                arrayOf(5, 0, 1)
            )
            val sqlQuery7 = SimpleSQLiteQuery(
                "SELECT * FROM question WHERE topic = ? AND $dynamicColumnName = ? ORDER BY RANDOM() LIMIT ?",
                arrayOf(6, 0, 6)
            )
            val sqlQuery8 = SimpleSQLiteQuery(
                "SELECT * FROM question WHERE topic = ? AND $dynamicColumnName = ? ORDER BY RANDOM() LIMIT ?",
                arrayOf(7, 0, 6)
            )


            val data1 = DatabaseProvider.getDatabase(context).questionDao()
                .getDataRandomByTopicAndDynamicColumn(sqlQuery1)
            val data2 = DatabaseProvider.getDatabase(context).questionDao()
                .getDataRandomByTopicAndDynamicColumn(sqlQuery2)
            val data3 =
                DatabaseProvider.getDatabase(context).questionDao()
                    .getDataRandomByTopicAndDynamicColumn(sqlQuery3)
            val data4 =
                DatabaseProvider.getDatabase(context).questionDao()
                    .getDataRandomByTopicAndDynamicColumn(sqlQuery4)
            val data5 =
                DatabaseProvider.getDatabase(context).questionDao()
                    .getDataRandomByTopicAndDynamicColumn(sqlQuery5)
            val data6 =
                DatabaseProvider.getDatabase(context).questionDao()
                    .getDataRandomByTopicAndDynamicColumn(sqlQuery6)
            val data7 =
                DatabaseProvider.getDatabase(context).questionDao()
                    .getDataRandomByTopicAndDynamicColumn(sqlQuery7)
            val data8 =
                DatabaseProvider.getDatabase(context).questionDao()
                    .getDataRandomByTopicAndDynamicColumn(sqlQuery8)


            val lt1 = data1.map { entity ->
                Question(
                    image = entity.image,
                    no = entity.no,
                    index = entity.index,
                    text = entity.text,
                    tip = entity.tip,
                    answers = getAnswersForData(entity.id, context),
                    required = entity.required,
                    topic = entity.topic,
                    a1 = entity.a1,
                    a2 = entity.a2,
                    a3 = entity.a3,
                    a4 = entity.a4,
                    b1 = entity.b1
                )
            }
            val lt2 = data2.map { entity ->
                Question(
                    image = entity.image,
                    no = entity.no,
                    index = entity.index,
                    text = entity.text,
                    tip = entity.tip,
                    answers = getAnswersForData(entity.id, context),
                    required = entity.required,
                    topic = entity.topic,
                    a1 = entity.a1,
                    a2 = entity.a2,
                    a3 = entity.a3,
                    a4 = entity.a4,
                    b1 = entity.b1
                )
            }

            val lt3 = data3.map { entity ->
                Question(
                    image = entity.image,
                    no = entity.no,
                    index = entity.index,
                    text = entity.text,
                    tip = entity.tip,
                    answers = getAnswersForData(entity.id, context),
                    required = entity.required,
                    topic = entity.topic,
                    a1 = entity.a1,
                    a2 = entity.a2,
                    a3 = entity.a3,
                    a4 = entity.a4,
                    b1 = entity.b1
                )
            }
            val lt4 = data4.map { entity ->
                Question(
                    image = entity.image,
                    no = entity.no,
                    index = entity.index,
                    text = entity.text,
                    tip = entity.tip,
                    answers = getAnswersForData(entity.id, context),
                    required = entity.required,
                    topic = entity.topic,
                    a1 = entity.a1,
                    a2 = entity.a2,
                    a3 = entity.a3,
                    a4 = entity.a4,
                    b1 = entity.b1
                )
            }
            val lt5 = data5.map { entity ->
                Question(
                    image = entity.image,
                    no = entity.no,
                    index = entity.index,
                    text = entity.text,
                    tip = entity.tip,
                    answers = getAnswersForData(entity.id, context),
                    required = entity.required,
                    topic = entity.topic,
                    a1 = entity.a1,
                    a2 = entity.a2,
                    a3 = entity.a3,
                    a4 = entity.a4,
                    b1 = entity.b1
                )
            }
            val lt6 = data6.map { entity ->
                Question(
                    image = entity.image,
                    no = entity.no,
                    index = entity.index,
                    text = entity.text,
                    tip = entity.tip,
                    answers = getAnswersForData(entity.id, context),
                    required = entity.required,
                    topic = entity.topic,
                    a1 = entity.a1,
                    a2 = entity.a2,
                    a3 = entity.a3,
                    a4 = entity.a4,
                    b1 = entity.b1
                )
            }
            val lt7 = data7.map { entity ->
                Question(
                    image = entity.image,
                    no = entity.no,
                    index = entity.index,
                    text = entity.text,
                    tip = entity.tip,
                    answers = getAnswersForData(entity.id, context),
                    required = entity.required,
                    topic = entity.topic,
                    a1 = entity.a1,
                    a2 = entity.a2,
                    a3 = entity.a3,
                    a4 = entity.a4,
                    b1 = entity.b1
                )
            }
            val lt8 = data8.map { entity ->
                Question(
                    image = entity.image,
                    no = entity.no,
                    index = entity.index,
                    text = entity.text,
                    tip = entity.tip,
                    answers = getAnswersForData(entity.id, context),
                    required = entity.required,
                    topic = entity.topic,
                    a1 = entity.a1,
                    a2 = entity.a2,
                    a3 = entity.a3,
                    a4 = entity.a4,
                    b1 = entity.b1
                )
            }


            val lt = mutableListOf<Question>()
            lt.addAll(lt1)
            lt.addAll(lt2)
            lt.addAll(lt3)
            lt.addAll(lt4)
            lt.addAll(lt5)
            lt.addAll(lt6)
            lt.addAll(lt7)
            lt.addAll(lt8)

            return lt.shuffled()

        }

        private fun getAnswersForData(parentId: Long, context: Context): List<Answer> {
            val answerEntities =
                DatabaseProvider.getDatabase(context).answerDao().getAnswersForData(parentId)
            return answerEntities.map { answerEntity ->
                Answer(
                    text = answerEntity.text,
                    correct = answerEntity.correct
                )
            }
        }
    }
}