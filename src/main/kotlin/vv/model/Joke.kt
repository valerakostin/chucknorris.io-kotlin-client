package vv.model

import java.net.URL

internal data class Joke(
    val id: String,
    val url: URL,
    val value: String,
    val category: List<String>?,
    val icon_url: URL
)