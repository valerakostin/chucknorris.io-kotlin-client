package vv.services.impl

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import vv.model.Joke
import vv.services.JokeReader
import java.net.URL

internal class JSONJokeReader : JokeReader {
    override fun randomJoke(url: URL): Joke {
        val json = url.readText()
        val mapper = jacksonObjectMapper()
        return mapper.readValue(json)
    }
}