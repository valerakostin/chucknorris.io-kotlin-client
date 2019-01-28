package vv.services.impl

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import vv.model.SearchResult
import vv.services.JokeSearcher
import java.net.URL

internal class JSONJokeSearcher : JokeSearcher {
    override fun searchJokes(url: URL): List<String> {
        try {
            val json = url.readText()
            val mapper = jacksonObjectMapper()
            val jokes = mapper.readValue<SearchResult>(json).result
            return jokes?.let { jokes.map { item -> item.value } } ?: emptyList()
        } catch (th: Throwable) {
            println("Unable to process query: ${th.message}")
        }
        return emptyList()
    }
}