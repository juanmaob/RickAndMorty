package com.seventhson.rickandmorty.utils

import java.net.URLEncoder
import java.nio.charset.StandardCharsets

/**
 * URLs deben ser codificadas para pasarlas como argumento, si no, salta una excepción.
 */
fun String.encodeURL(): String = URLEncoder.encode(this, StandardCharsets.UTF_8.toString())