package io.github._4kleiber.bootstrap

import io.github._4kleiber.bootstrap.internal.classNames
import kotlinx.html.FlowContent
import kotlinx.html.SPAN
import kotlinx.html.span

/** https://getbootstrap.com/docs/5.3/components/badge/#background-colors */
public enum class BadgeVariant(internal val cssClass: String) {
    Primary("text-bg-primary"),
    Secondary("text-bg-secondary"),
    Success("text-bg-success"),
    Danger("text-bg-danger"),
    Warning("text-bg-warning"),
    Info("text-bg-info"),
    Light("text-bg-light"),
    Dark("text-bg-dark"),
}

/**
 * A Bootstrap badge. https://getbootstrap.com/docs/5.3/components/badge/
 */
public fun FlowContent.bsBadge(
    variant: BadgeVariant = BadgeVariant.Primary,
    pill: Boolean = false,
    classes: String? = null,
    block: SPAN.() -> Unit = {},
): Unit {
    span(
        classes = classNames("badge", variant.cssClass, if (pill) "rounded-pill" else null, classes),
        block = block,
    )
}
