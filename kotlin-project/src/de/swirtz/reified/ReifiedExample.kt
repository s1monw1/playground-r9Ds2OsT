package de.swirtz.reified

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

fun <T> String.toKotlinObject(): T {
    val mapper = jacksonObjectMapper()
    //does not compile!
    return mapper.readValue(this, T::class.java)
}