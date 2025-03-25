package com.example.data.responses

import com.example.data.models.RecipeDto
import com.google.gson.annotations.SerializedName

data class RecipeSearchResponse(
    @SerializedName("count") var count: Int? = null,
    @SerializedName("results") var recipes : List<RecipeDto>,
    @SerializedName("next") var next : String? = null,
    @SerializedName("previous") var previous : String? = null

)