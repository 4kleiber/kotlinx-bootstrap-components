package io.github._4kleiber.bootstrap

import io.github._4kleiber.bootstrap.internal.classNames
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.div

/**
 * A Bootstrap button group / toolbar container.
 * https://getbootstrap.com/docs/5.3/components/button-group/
 */
public fun FlowContent.bsButtonGroup(
    size: ButtonSize? = null,
    vertical: Boolean = false,
    ariaLabel: String? = null,
    classes: String? = null,
    block: DIV.() -> Unit = {},
): Unit {
    div(
        classes = classNames(
            if (vertical) "btn-group-vertical" else "btn-group",
            size?.let { "btn-group-${it.suffix}" },
            classes,
        ),
    ) {
        attributes["role"] = "group"
        ariaLabel?.let { attributes["aria-label"] = it }
        block()
    }
}
