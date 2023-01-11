package com.example.islami.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.example.islami.R
import com.example.islami.databinding.FragmentTasbehBinding


class TasbehFragment : Fragment() {
    lateinit var binding: FragmentTasbehBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTasbehBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var counterClickTasbiha = 0
        var counterSumTasbiha=0
        var counter_lap = 0
        var num_lap = 0
        binding.tasbih.setOnClickListener {
            counterSumTasbiha++
            counterClickTasbiha++
            counter_lap++
            binding.sumTasbiha.setText(counterSumTasbiha.toString())
            binding.clickTasbiha.setText(counterClickTasbiha.toString())
            if (counter_lap == 33) {
                num_lap++
                binding.lap.setText(num_lap.toString())
                counter_lap = 0
            }
        }
        binding.refresh.setOnClickListener {
            counterSumTasbiha = 0
            counterClickTasbiha=0
            counter_lap = 0
            num_lap = 0
            binding.clickTasbiha.setText(counterClickTasbiha.toString())
            binding.sumTasbiha.setText(counterSumTasbiha.toString())
            binding.lap.setText(num_lap.toString())
        }
        binding.tasbihSpinner.setOnItemSelectedListener(object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //Toast.makeText(context, "Something changed", LENGTH_SHORT).show()
                counterClickTasbiha = 0
                binding.clickTasbiha.setText(counterClickTasbiha.toString())

            } // to close the onItemSelected

            override fun onNothingSelected(parent: AdapterView<*>?) {


            }
        })
    }

}



