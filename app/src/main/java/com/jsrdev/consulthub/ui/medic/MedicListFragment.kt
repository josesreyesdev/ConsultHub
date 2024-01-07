package com.jsrdev.consulthub.ui.medic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jsrdev.consulthub.core.Specialty
import com.jsrdev.consulthub.data.network.model.GetMedicResponse
import com.jsrdev.consulthub.databinding.FragmentMedicListBinding
import com.jsrdev.consulthub.ui.adapters.MedicAdapter

class MedicListFragment : Fragment() {

    private var _binding: FragmentMedicListBinding? = null
    private val binding by lazy { requireNotNull(_binding) }

    private lateinit var adapter: MedicAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMedicListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MedicAdapter {
            val action = MedicListFragmentDirections.actionMedicListFragment2ToMedicDetailFragment()
            this.findNavController().navigate(action)
        }

        val items = mutableListOf<GetMedicResponse>()

         repeat(10) {
            items.addAll(
                listOf(
                    GetMedicResponse(1, "San José", Specialty.CARDIOLOGIA, "31233", "sanjose@example.com"),
                    GetMedicResponse(2, "San Marcos", Specialty.PEDIATRIA, "41241", "sanmarcos@example.com"),
                    GetMedicResponse(3, "San Piter", Specialty.ORTOPEDIA, "624432", "sanpiter@example.com"),
                    GetMedicResponse(3, "Santa Maria", Specialty.GINECOLOGIA, "89890", "santamaria@example.com"),
                    GetMedicResponse(3, "Santa Ines", Specialty.ODONTOLOGIA, "88080", "santaines@example.com")
                )
            )
        }

        binding.recyclerView.adapter = adapter
        adapter.submitList(items)
        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}