package vv.services

import java.net.URL

internal interface CategoryReader {
    fun readCategories(url: URL): List<String>
}