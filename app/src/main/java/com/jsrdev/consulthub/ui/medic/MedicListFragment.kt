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
                    GetMedicResponse(1, "San José José", Specialty.CARDIOLOGIA, "A2-3233"),
                    GetMedicResponse(2, "San Marcos San Marcos", Specialty.PEDIATRIA, "41-AD241"),
                    GetMedicResponse(3, "San Piter San Piter", Specialty.ORTOPEDIA, "6244FS2"),
                    GetMedicResponse(4, "Santa Maria Santa Maria", Specialty.GINECOLOGIA, "89-D890"),
                    GetMedicResponse(5, "Santa Ines Santa Ines", Specialty.ODONTOLOGIA, "88-EF080")
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