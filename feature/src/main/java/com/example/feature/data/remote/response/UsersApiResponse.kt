package com.example.feature.data.remote.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
class UsersApiResponse : ArrayList<UsersApiResponse.UsersApiResponseItem>(){
    @Keep
    data class UsersApiResponseItem(
        @SerializedName("email")
        val email: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("username")
        val username: String
    )
}
