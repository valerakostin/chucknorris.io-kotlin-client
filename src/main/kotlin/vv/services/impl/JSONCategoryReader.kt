package vv.services.impl

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import vv.services.CategoryReader
import java.net.URL

internal class JSONCategoryReader : CategoryReader {
    override fun readCategories(url: URL): List<String> {
        val json = url.readText()
        val mapper = jacksonObjectMapper()
        return mapper.readValue(json)
    }
}