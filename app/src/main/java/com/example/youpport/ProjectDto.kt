package com.example.youpport

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProjectDto(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("region")
    val region: String,
    @SerialName("organization")
    val organization: String,
    @SerialName("startPeriod")
    val startPeriod: String,
    @SerialName("endPeriod")
    val endPeriod: String,
    @SerialName("links")
    val links: String
)