package io.github._4kleiber.bootstrap

import io.github._4kleiber.bootstrap.internal.classNames
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.div
import kotlinx.html.span

/** https://getbootstrap.com/docs/5.3/components/spinners/ */
public enum class SpinnerType(internal val cssClass: String) {
    Border("spinner-border"),
    Grow("spinner-grow"),
}

/** https://getbootstrap.com/docs/5.3/components/spinners/#color-variants */
public enum class SpinnerVariant(internal val cssClass: String) {
    Primary("text-primary"),
    Secondary("text-secondary"),
    Success("text-success"),
    Danger("text-danger"),
    Warning("text-warning"),
    Info("text-info"),
    Light("text-light"),
    Dark("text-dark"),
}

/**
 * A Bootstrap loading spinner. https://getbootstrap.com/docs/5.3/components/spinners/
 */
public fun FlowContent.bsSpinner(
    type: SpinnerType = SpinnerType.Border,
    variant: SpinnerVariant? = null,
    small: Boolean = false,
    visuallyHiddenText: String = "Loading...",
    classes: String? = null,
    block: DIV.() -> Unit = {},
): Unit {
    div(
        classes = classNames(type.cssClass, variant?.cssClass, if (small) "${type.cssClass}-sm" else null, classes),
    ) {
        attributes["role"] = "status"
        span(classes = "visually-hidden") { +visuallyHiddenText }
        block()
    }
}
