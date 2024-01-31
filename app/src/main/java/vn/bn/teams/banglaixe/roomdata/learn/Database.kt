package vn.bn.teams.banglaixe.roomdata.learn

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [QuestionEntity::class, AnswerEntity::class], version = 1, exportSchema = true)
abstract class Database : RoomDatabase() {
    abstract fun questionDao(): QuestionDao
    abstract fun answerDao(): AnswerDao
}