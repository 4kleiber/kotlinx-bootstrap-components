package io.github._4kleiber.bootstrap

import io.github._4kleiber.bootstrap.internal.classNames
import kotlinx.html.A
import kotlinx.html.BUTTON
import kotlinx.html.ButtonType
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.a
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.id

/**
 * A Bootstrap collapse toggle rendered as a `<button>`. [target] is the id of
 * the [bsCollapse] panel it controls (without a leading `#`).
 * https://getbootstrap.com/docs/5.3/components/collapse/
 */
public fun FlowContent.bsCollapseToggleButton(
    target: String,
    variant: ButtonVariant = ButtonVariant.Primary,
    size: ButtonSize? = null,
    expanded: Boolean = false,
    classes: String? = null,
    block: BUTTON.() -> Unit = {},
): Unit {
    button(
        classes = classNames("btn", variant.cssClass, size?.let { "btn-${it.suffix}" }, classes),
        type = ButtonType.button,
    ) {
        attributes["data-bs-toggle"] = "collapse"
        attributes["data-bs-target"] = "#$target"
        attributes["aria-expanded"] = expanded.toString()
        attributes["aria-controls"] = target
        block()
    }
}

/** A Bootstrap collapse toggle rendered as `<a href="#target">`. */
public fun FlowContent.bsCollapseToggleLink(
    target: String,
    expanded: Boolean = false,
    classes: String? = null,
    block: A.() -> Unit = {},
): Unit {
    a(href = "#$target", classes = classes) {
        attributes["data-bs-toggle"] = "collapse"
        attributes["role"] = "button"
        attributes["aria-expanded"] = expanded.toString()
        attributes["aria-controls"] = target
        block()
    }
}

/**
 * The collapsible panel. [id] must match a toggle's `target`. [show] renders
 * it already expanded. https://getbootstrap.com/docs/5.3/components/collapse/
 */
public fun FlowContent.bsCollapse(
    id: String,
    horizontal: Boolean = false,
    show: Boolean = false,
    classes: String? = null,
    block: DIV.() -> Unit = {},
): Unit {
    div(
        classes = classNames(
            "collapse",
            if (horizontal) "collapse-horizontal" else null,
            if (show) "show" else null,
            classes,
        ),
    ) {
        this.id = id
        block()
    }
}
