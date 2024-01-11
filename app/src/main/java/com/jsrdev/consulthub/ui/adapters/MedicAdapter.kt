package com.jsrdev.consulthub.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.jsrdev.consulthub.R
import com.jsrdev.consulthub.core.Constants
import com.jsrdev.consulthub.data.network.model.GetMedicResponse
import com.jsrdev.consulthub.databinding.MedicListItemBinding

class MedicAdapter(private val onItemClicked: (GetMedicResponse) -> Unit )
    : ListAdapter<GetMedicResponse, MedicAdapter.MedicViewHolder>(DiffCallback) {
    class MedicViewHolder(private var binding: MedicListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(medic: GetMedicResponse) {
            val imgUrl: String = Constants.TEMPORAL_URL_IMAGE
            imgUrl.let {
                val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
                binding.medicImage.load(imgUri) {
                    placeholder(R.drawable.loading_animation)
                    error(R.drawable.ic_broken_image)
                }
            }

            binding.apply {
                name.text = medic.name
                specialty.text = medic.specialty?.name ?: "Not Found Specialty"
                document.text = medic.document
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicViewHolder {
        return MedicViewHolder(MedicListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MedicViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener { onItemClicked(current) }
        holder.bind(current)
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<GetMedicResponse>() {
            override fun areItemsTheSame(
                oldItem: GetMedicResponse,
                newItem: GetMedicResponse
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: GetMedicResponse,
                newItem: GetMedicResponse
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}