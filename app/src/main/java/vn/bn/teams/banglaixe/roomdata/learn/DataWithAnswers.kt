package vn.bn.teams.banglaixe.roomdata.learn

import androidx.room.Embedded
import androidx.room.Relation

data class DataWithAnswers(
    @Embedded val questions: QuestionEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "parentId"
    )
    val answers: List<AnswerEntity>
)