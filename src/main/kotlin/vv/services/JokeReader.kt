package vv.services

import vv.model.Joke
import java.net.URL

internal interface JokeReader {
    fun randomJoke(url: URL): Joke
}