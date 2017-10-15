package de.swirtz.reified

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kotlin.reflect.KClass

data class SimpleText(val simple: String)

fun main(args: Array<String>) {
    val asObject = """{"simple": "text"}""".toKotlinObject(SimpleText::class)
    println(asObject)
}

fun <T : Any> String.toKotlinObject(c: KClass<T>): T {
    val mapper = jacksonObjectMapper()
    return mapper.readValue(this, c.java)
}