package vn.bn.teams.banglaixe.roomdata.learn

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RawQuery
import androidx.room.Transaction
import androidx.sqlite.db.SupportSQLiteQuery

@Dao
interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(data: QuestionEntity): Long

    @Query("SELECT * FROM question WHERE topic = :topic limit :limit ")
    suspend fun getData(topic: Long, limit: Int): MutableList<QuestionEntity>

    @Query("SELECT * FROM question WHERE topic = :topic AND :type =:a1 ORDER BY RANDOM() limit :limit ")
    fun getDataRandomByTopicA1(
        topic: Long,
        limit: Int,
        type: String,
        a1: Int,
    ): MutableList<QuestionEntity>

    @RawQuery
    fun getDataRandomByTopicAndDynamicColumn(query: SupportSQLiteQuery): MutableList<QuestionEntity>

    @Query("SELECT * FROM question WHERE required = :required ORDER BY RANDOM() limit :limit ")
    fun getDataRandomByRequired(required: Long, limit: Int): MutableList<QuestionEntity>

    @Transaction
    @Query("SELECT * FROM question WHERE topic = :topic ORDER BY RANDOM() limit :limit ")
    fun getDataWithAnswers(
        topic: Long,
        limit: Int
    ): List<DataWithAnswers>

    @Query("SELECT COUNT(*) FROM question")
    fun getNumberOfItems(): Int

}