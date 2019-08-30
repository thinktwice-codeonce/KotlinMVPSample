package com.bss.codebase.app.domain.service.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Posts: Serializable {

    @SerializedName("userId")
    private lateinit var userId: String

    @SerializedName("title")
    private lateinit var title: String

    @SerializedName("body")
    private lateinit var body: String
}