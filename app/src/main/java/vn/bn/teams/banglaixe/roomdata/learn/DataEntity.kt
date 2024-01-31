package vn.bn.teams.banglaixe.roomdata.learn

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "question")
data class QuestionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val image: String,
    val no: Int,
    val index: Int,
    val text: String,
    val tip: String,
    val required: Int,
    val topic: Int,
    val a1: Int,
    val a2: Int,
    val a3: Int,
    val a4: Int,
    val b1: Int
)

@Entity(tableName = "answer")
data class AnswerEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val text: String,
    val correct: Boolean,
    val parentId: Long
)
