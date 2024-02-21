package com.jsrdev.consulthub.data.network.model

import com.jsrdev.consulthub.core.Specialty
import com.squareup.moshi.Json

data class GetMedicResponse(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String? = null,
    @Json(name = "specialty") val specialty: Specialty? = null,
    @Json(name = "document") val document: String? = null
)
