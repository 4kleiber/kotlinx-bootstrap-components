package io.github._4kleiber.bootstrap

import io.github._4kleiber.bootstrap.internal.classNames
import kotlinx.html.FlowContent
import kotlinx.html.LI
import kotlinx.html.UL
import kotlinx.html.li
import kotlinx.html.ul

/** https://getbootstrap.com/docs/5.3/components/list-group/#contextual-classes */
public enum class ListGroupItemVariant(internal val cssClass: String) {
    Primary("list-group-item-primary"),
    Secondary("list-group-item-secondary"),
    Success("list-group-item-success"),
    Danger("list-group-item-danger"),
    Warning("list-group-item-warning"),
    Info("list-group-item-info"),
    Light("list-group-item-light"),
    Dark("list-group-item-dark"),
}

/**
 * A Bootstrap list group. https://getbootstrap.com/docs/5.3/components/list-group/
 */
public fun FlowContent.bsListGroup(
    flush: Boolean = false,
    numbered: Boolean = false,
    classes: String? = null,
    block: UL.() -> Unit = {},
): Unit {
    ul(
        classes = classNames(
            "list-group",
            if (flush) "list-group-flush" else null,
            if (numbered) "list-group-numbered" else null,
            classes,
        ),
        block = block,
    )
}

/** An item within a [bsListGroup]. */
public fun UL.bsListGroupItem(
    active: Boolean = false,
    disabled: Boolean = false,
    variant: ListGroupItemVariant? = null,
    classes: String? = null,
    block: LI.() -> Unit = {},
): Unit {
    li(
        classes = classNames(
            "list-group-item",
            variant?.cssClass,
            if (active) "active" else null,
            if (disabled) "disabled" else null,
            classes,
        ),
    ) {
        if (active) {
            attributes["aria-current"] = "true"
        }
        block()
    }
}
