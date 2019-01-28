package vv

import vv.services.ChuckNorrisIOClient
import vv.services.impl.ChuckNorrisIOClientImpl

object ChuckNorrisClientFactory {
    fun chuckNorrisIOClient(): ChuckNorrisIOClient = ChuckNorrisIOClientImpl()
}
