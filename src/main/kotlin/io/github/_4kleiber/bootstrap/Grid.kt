package io.github._4kleiber.bootstrap

import io.github._4kleiber.bootstrap.internal.classNames
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.div

/** https://getbootstrap.com/docs/5.3/layout/breakpoints/ */
public enum class Breakpoint(internal val infix: String) {
    Sm("sm"),
    Md("md"),
    Lg("lg"),
    Xl("xl"),
    Xxl("xxl"),
}

/**
 * A Bootstrap grid container. https://getbootstrap.com/docs/5.3/layout/containers/
 */
public fun FlowContent.bsContainer(
    fluid: Boolean = false,
    at: Breakpoint? = null,
    classes: String? = null,
    block: DIV.() -> Unit = {},
): Unit {
    val containerClass = when {
        at != null -> "container-${at.infix}"
        fluid -> "container-fluid"
        else -> "container"
    }
    div(classes = classNames(containerClass, classes), block = block)
}

/**
 * A Bootstrap grid row. https://getbootstrap.com/docs/5.3/layout/grid/
 */
public fun FlowContent.bsRow(
    classes: String? = null,
    block: DIV.() -> Unit = {},
): Unit {
    div(classes = classNames("row", classes), block = block)
}

/**
 * A Bootstrap grid column. [span] sets the default `col-<n>` width; [at] adds
 * per-breakpoint `col-<breakpoint>-<n>` overrides.
 * https://getbootstrap.com/docs/5.3/layout/grid/
 */
public fun FlowContent.bsCol(
    span: Int? = null,
    at: Map<Breakpoint, Int> = emptyMap(),
    classes: String? = null,
    block: DIV.() -> Unit = {},
): Unit {
    val breakpointClasses = at.entries.map { (breakpoint, columns) -> "col-${breakpoint.infix}-$columns" }
    div(
        classes = classNames(span?.let { "col-$it" } ?: "col", *breakpointClasses.toTypedArray(), classes),
        block = block,
    )
}
