package com.project.keeptraining.model.room.treino_room
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "treino")
data class TreinoRoom (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val grupoTreinoId: Int,
    val nomeGrupoMuscular: String,
    val nomeTreino: String,
    val pesoTreino: Int
)
