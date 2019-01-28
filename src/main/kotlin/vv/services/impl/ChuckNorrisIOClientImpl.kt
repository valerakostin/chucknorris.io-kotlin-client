package vv.services.impl

import vv.services.ChuckNorrisIOClient
import java.net.URL
import java.util.concurrent.ThreadLocalRandom

internal class ChuckNorrisIOClientImpl : ChuckNorrisIOClient {
    override val categories: List<String>
        get() {
            val reader = JSONCategoryReader()
            return reader.readCategories(URL("${BASE_URL}categories"))
        }

    companion object {
        const val BASE_URL = "https://api.chucknorris.io/jokes/"
    }

    override fun randomJoke(requestedCategories: List<String>): String {
        val reader = JSONJokeReader()
        val url = URL("${BASE_URL}random")

        fun randomJokeInt() = reader.randomJoke(url).value

        fun randomJokeWithCategory(requestedCategories: List<String>): String {
            val category = getCategory(requestedCategories)
            val categoryUrl = URL(url, "random?category=$category")
            val joke = reader.randomJoke(categoryUrl)
            return joke.value
        }

        if (requestedCategories.isEmpty())
            return randomJokeInt()
        return randomJokeWithCategory(requestedCategories)
    }

    private fun getCategory(requestedCategories: List<String>): String {

        fun getValidCategories(categories: List<String>): List<String> {
            val allCategories = HashSet(categories)
            val validCategories = categories
                .filter { allCategories.contains(it) }
                .toList()

            if (categories.size != validCategories.size) {
                val invalidCategories = categories.toMutableSet()
                invalidCategories.removeAll(validCategories)
                throw IllegalArgumentException("Invalid categories were found: ${invalidCategories.joinToString()}")
            }
            return validCategories
        }

        fun List<String>.randomCategory(): String {
            val randomGenerator = ThreadLocalRandom.current()
            return this[randomGenerator.nextInt(0, this.size)]
        }

        val validCategories = getValidCategories(requestedCategories)
        return (if (validCategories.isEmpty()) categories else validCategories).randomCategory()
    }


    override fun searchJokes(queryText: String): List<String> {
        val searcher = JSONJokeSearcher()
        return searcher.searchJokes(URL("${BASE_URL}search?query=$queryText"))
    }
}