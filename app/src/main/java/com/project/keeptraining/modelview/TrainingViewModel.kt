package com.project.keeptraining.modelview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TrainingViewModel : ViewModel() {
    private var textoErro: String  = ""

    private val _inputExercicio = MutableLiveData<String>()

    private val  _inputPeso = MutableLiveData<String>()

    val valueExercicio: LiveData<String> = _inputExercicio
    val valuePeso: LiveData<String> = _inputPeso

    fun registrarExercicio(){
        val camposValidos = validarCamposInput()

        if(camposValidos){

        }
    }

    fun validarCamposInput(): Boolean{
        if(_inputExercicio.value.isNullOrEmpty()){
            textoErro = "Por favor, digite o nome do exercício"
            return false;
        }
        if(_inputPeso.value.isNullOrEmpty()){
            textoErro += "Por favor, digite o peso utilizado no exercício"
            return false;
        }
        return true;
    }

    fun setarInputExercicio(value: String){
        _inputExercicio.value = value
    }

    fun setarInputPeso(value: String){
        _inputPeso.value = value
    }
}
