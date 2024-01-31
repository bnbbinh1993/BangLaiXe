package vn.bn.teams.banglaixe.roomdata.learn

import vn.bn.teams.banglaixe.models.Answer
import vn.bn.teams.banglaixe.models.Question


class Repository(private val questionDao: QuestionDao, private val answerDao: AnswerDao) {

    suspend fun insertQuestion(yourDataEntity: QuestionEntity): Long {
        return questionDao.insertData(yourDataEntity)
    }

    suspend fun insertAnswer(answerEntity: AnswerEntity) {
        answerDao.insertAnswer(answerEntity)
    }

    suspend fun getData(topic: Long, limit :Int): List<Question> {
        val dataEntities = questionDao.getData(topic,limit)
        return dataEntities.map { entity ->
            Question(
                image = entity.image,
                no = entity.no,
                index = entity.index,
                text = entity.text,
                tip = entity.tip,
                answers = getAnswersForData(entity.id),
                required = entity.required,
                topic = entity.topic,
                a1 = entity.a1,
                a2 = entity.a2,
                a3 = entity.a3,
                a4 = entity.a4,
                b1 = entity.b1
            )
        }
    }

     fun getNumberOfItems(): Int {
        return questionDao.getNumberOfItems()
    }

    private suspend fun getAnswersForData(parentId: Long): List<Answer> {
        val answerEntities = answerDao.getAnswersForData(parentId)
        return answerEntities.map { answerEntity ->
            Answer(
                text = answerEntity.text,
                correct = answerEntity.correct
            )
        }
    }

}