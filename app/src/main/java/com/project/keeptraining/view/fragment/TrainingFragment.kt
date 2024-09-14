package com.project.keeptraining.view.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.project.keeptraining.databinding.FragmentTrainingBinding
import com.project.keeptraining.model.enum.GrupoMuscularEnum
import com.project.keeptraining.viewmodel.TreinoViewModel.TreinoViewModel

class TrainingFragment : Fragment() {

    private var _binding: FragmentTrainingBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val trainingViewModel =
            ViewModelProvider(this).get(TreinoViewModel::class.java)

        _binding = FragmentTrainingBinding.inflate(inflater, container, false)

        val root: View = binding.root

        val inputExercicio: EditText = binding.inptExercicio
        val inputPeso: EditText = binding.inptPeso
        val radioGroup: RadioGroup = binding.radioGroup
        val btnRegistrar: Button = binding.btnRegistrar

        trainingViewModel.valueExercicio.observe(viewLifecycleOwner){ value ->
            if(inputExercicio.text.toString() != value)
                inputExercicio.setText(value)
        }

        trainingViewModel.valuePeso.observe(viewLifecycleOwner){ value ->
            if(inputPeso.text.toString() != value)
                inputPeso.setText(value)
        }

        trainingViewModel.radioSelect.observe(viewLifecycleOwner) { value ->
            if(radioGroup.checkedRadioButtonId != value)
                radioGroup.check(value)
        }

        radioGroup.setOnCheckedChangeListener{group, checkedInt ->
            trainingViewModel.setarSelectedGrupoMuscular(checkedInt)

            if(GrupoMuscularEnum.PEITO.IdGrupoMuscular == checkedInt)
                trainingViewModel.setarNomeGrupoMuscular("Peito");
            else if(GrupoMuscularEnum.COSTAS.IdGrupoMuscular == checkedInt)
                trainingViewModel.setarNomeGrupoMuscular("Costas")
            else if(GrupoMuscularEnum.PERNA.IdGrupoMuscular == checkedInt)
                trainingViewModel.setarNomeGrupoMuscular("Perna")
            else if(GrupoMuscularEnum.BICEPS.IdGrupoMuscular == checkedInt)
                trainingViewModel.setarNomeGrupoMuscular("Bíceps")
            else if(GrupoMuscularEnum.TRICEPS.IdGrupoMuscular == checkedInt)
                trainingViewModel.setarNomeGrupoMuscular("Tríceps")
        }

        inputExercicio.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?){
                trainingViewModel.setarInputExercicio(s.toString())
            }
        })

        inputPeso.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?){
                trainingViewModel.setarInputPeso(s.toString())
            }
        })

        btnRegistrar.setOnClickListener{
            trainingViewModel.registrarExercicio()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}