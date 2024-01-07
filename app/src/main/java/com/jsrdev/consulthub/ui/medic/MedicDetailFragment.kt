package com.jsrdev.consulthub.ui.medic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jsrdev.consulthub.databinding.FragmentMedicDetailBinding

class MedicDetailFragment : Fragment() {

    private var _binding: FragmentMedicDetailBinding? = null
    private val binding by lazy { requireNotNull(_binding) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMedicDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}