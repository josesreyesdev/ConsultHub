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

         repeat(5) {
            items.addAll(
                listOf(
                    GetMedicResponse(7, "Juan Pérez", Specialty.PEDIATRIA, "12345"),
                    GetMedicResponse(8, "Ana González", Specialty.ORTOPEDIA, "67890-Axx-67890"),
                    GetMedicResponse(9, "Carlos Rodriguez", Specialty.GINECOLOGIA, "54321"),
                    GetMedicResponse(10, "Laura Hernandez", Specialty.ODONTOLOGIA, "98765"),
                    GetMedicResponse(11, "Javier Gutierrez", Specialty.CARDIOLOGIA, "246-Abv80"),
                    GetMedicResponse(12, "Sofía López", Specialty.PEDIATRIA, "97531"),
                    GetMedicResponse(13, "Andrés Smith", Specialty.ORTOPEDIA, "86420"),
                    GetMedicResponse(14, "Isabel García", Specialty.GINECOLOGIA, "64239"),
                    GetMedicResponse(15, "Roberto Navarro", Specialty.ODONTOLOGIA, "87456")
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