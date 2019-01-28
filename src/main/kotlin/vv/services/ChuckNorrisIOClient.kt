package vv.services

interface ChuckNorrisIOClient {

    val categories: List<String>
    fun randomJoke(requestedCategories: List<String> = emptyList()): String
    fun searchJokes(queryText: String): List<String>
}