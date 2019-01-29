package com.example.agerasimenko.demoproject.data.dto

import com.google.gson.annotations.SerializedName

@Generated
data class Currency(
        @SerializedName("Cur_ID")val id: Int,
        @SerializedName("Cur_ParentID")val parentId: Int,
        @SerializedName("Cur_Code")val code: String,
        @SerializedName("Cur_Abbreviation")val abbreviation: String,
        @SerializedName("Cur_Name_Eng")val name: String,
        @SerializedName("Cur_QuotName_Eng")val quoteName: String,
        @SerializedName("Cur_Name_EngMulti")val multiName: String,
        @SerializedName("Cur_Scale")val scale: Int,
        @SerializedName("Cur_Periodicity")val periodicity: Int,
        @SerializedName("Cur_DateStart")val dateStart: String,
        @SerializedName("Cur_DateEnd")val dateEnd: String
)

annotation class Generated