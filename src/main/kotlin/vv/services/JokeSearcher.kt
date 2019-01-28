package vv.services

import java.net.URL

interface JokeSearcher {
    fun searchJokes(url: URL): List<String>
}