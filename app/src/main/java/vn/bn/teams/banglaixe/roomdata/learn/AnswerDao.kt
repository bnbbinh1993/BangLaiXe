package vn.bn.teams.banglaixe.roomdata.learn

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AnswerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertAnswer(answer: AnswerEntity)

    @Query("SELECT * FROM answer WHERE parentId = :parentId")
     fun getAnswersForData(parentId: Long): MutableList<AnswerEntity>
}