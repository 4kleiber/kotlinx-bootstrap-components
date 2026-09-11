package io.github._4kleiber.bootstrap.internal

/**
 * Joins non-null, non-blank CSS class fragments into a single space-separated
 * `class` attribute value. Every component function in this library funnels
 * its class composition through here so the assembly rule stays uniform.
 */
internal fun classNames(vararg classes: String?): String =
    classes.filterNotNull().filter { it.isNotBlank() }.joinToString(" ")
