package com.project.keeptraining.model.room_database.treino

import android.content.Context
import androidx.room.Database;
import androidx.room.Room
import androidx.room.RoomDatabase;
import com.project.keeptraining.model.room.treino_room.TreinoRoom
import com.project.keeptraining.model.dao.treino_dao.TreinoDao;


@Database(entities = [TreinoRoom::class], version = 1)
abstract class AppDataBase: RoomDatabase()
{
    abstract fun treinoDao(): TreinoDao

    companion object{
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "treino_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}