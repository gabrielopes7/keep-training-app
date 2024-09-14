package com.project.keeptraining.model.dao.treino_dao

import androidx.room.*
import com.project.keeptraining.model.room.treino_room.TreinoRoom

@Dao
interface TreinoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTreino(treino: TreinoRoom)
    @Update
    suspend fun updateTreino(treino: TreinoRoom)
    @Delete
    suspend fun deleteTreino(treino: TreinoRoom)
    @Query("Select * FROM treino")
    suspend fun getAllTreinos(): List<TreinoRoom>
}