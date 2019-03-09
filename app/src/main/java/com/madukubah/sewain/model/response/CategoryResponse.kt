package com.madukubah.sewain.model.response

import com.google.gson.annotations.SerializedName
import com.madukubah.sewain.model.Category

data class CategoryResponse (
        @field:SerializedName("data")
        val categories : List<Category>
)