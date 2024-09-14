package com.project.keeptraining.viewmodel.TreinoViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.keeptraining.model.repository.TreinoRepository.TreinoRepository
import com.project.keeptraining.model.room.treino_room.TreinoRoom

class TreinoViewModel(private val repository: TreinoRepository) : ViewModel() {
    private var textoErro: String  = ""

    private val _nomeExercicio = MutableLiveData<String>()
    private val  _valorPesoExercicio = MutableLiveData<String>()
    private val _selecionadoGrupoMuscular = MutableLiveData<Int>()
    private val _nomeGrupoMuscular = MutableLiveData<String>()

    val valueExercicio: LiveData<String> = _nomeExercicio
    val valuePeso: LiveData<String> = _valorPesoExercicio
    val radioSelect: LiveData<Int> = _selecionadoGrupoMuscular

    fun registrarExercicio(){
        val camposValidos = validarCamposInput()

        if(!camposValidos)
        {
            TreinoRoom(grupoTreinoId = _selecionadoGrupoMuscular.value!!.toInt(),
                        nomeGrupoMuscular = _nomeGrupoMuscular.value!!.toString(),
                        nomeTreino = _nomeExercicio.value!!.toString(),
                        pesoTreino = _valorPesoExercicio.value!!.toInt())
        }
    }

    fun validarCamposInput(): Boolean{
        var contemErro = false

        if(_nomeExercicio.value.isNullOrEmpty()){
            textoErro = "Por favor, digite o nome do exercício"
            contemErro = true
        }
        if(_valorPesoExercicio.value.isNullOrEmpty()){
            textoErro += "Por favor, digite o peso utilizado no exercício"
            contemErro = true
        }
        if(_nomeGrupoMuscular.value.isNullOrEmpty()){
            textoErro += "O nome do grupo muscular não pode ser nulo"
            contemErro = true
        }
        if(_selecionadoGrupoMuscular.value == 0){
            textoErro += "É necessário selecionar um grupo muscular"
            contemErro = true
        }
        return contemErro;
    }

    fun setarInputExercicio(value: String){
        _nomeExercicio.value = value
    }

    fun setarInputPeso(value: String){
        _valorPesoExercicio.value = value
    }

    fun setarSelectedGrupoMuscular(value: Int){
        _selecionadoGrupoMuscular.value = value
    }

    fun setarNomeGrupoMuscular(value: String){
        _nomeGrupoMuscular.value = value
    }
}
