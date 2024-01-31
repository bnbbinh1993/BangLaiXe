package vn.bn.teams.banglaixe.models

import androidx.room.Ignore


data class Answer(
    val text: String,
    val correct: Boolean,

    ) {
    @Ignore
    var isSelect: Boolean = false
}


data class Question(
    val image: String,
    val no: Int,
    val index: Int,
    val text: String,
    val tip: String,
    val answers: List<Answer>,
    val required: Int,
    val topic: Int,
    val a1: Int,
    val a2: Int,
    val a3: Int,
    val a4: Int,
    val b1: Int,

    ) {
    @Ignore
    var selected: Int = -1
}

data class Intro(
    val title: String,
    val des: String,
    val logo: Int
)
