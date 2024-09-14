package com.project.keeptraining.model.repository.TreinoRepository

import com.project.keeptraining.model.dao.treino_dao.TreinoDao
import com.project.keeptraining.model.room.treino_room.TreinoRoom

class TreinoRepository(private val treinoDao: TreinoDao) {
    suspend fun insertTreino(treino: TreinoRoom){
        treinoDao.insertTreino(treino)
    }

    suspend fun updateTreino(treino: TreinoRoom){
        treinoDao.updateTreino(treino)
    }

    suspend fun deleteTreino(treino: TreinoRoom){
        treinoDao.deleteTreino(treino)
    }

    suspend fun getAllTreinos(): List<TreinoRoom> {
        return treinoDao.getAllTreinos()
    }
}