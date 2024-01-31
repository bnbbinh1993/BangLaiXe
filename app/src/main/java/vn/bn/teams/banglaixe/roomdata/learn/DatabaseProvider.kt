package vn.bn.teams.banglaixe.roomdata.learn

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

object DatabaseProvider {

    @Volatile
    private var INSTANCE: Database? = null

    fun getDatabase(context: Context): Database {
        val tempInstance = INSTANCE
        if (tempInstance != null) {
            return tempInstance
        }
        synchronized(RoomDatabase::class.java) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                Database::class.java,
                "data.db"
            ).allowMainThreadQueries()
                .build()
            INSTANCE = instance
            return instance
        }

    }
}
