package io.github._4kleiber.bootstrap

import io.github._4kleiber.bootstrap.internal.classNames
import kotlinx.html.BUTTON
import kotlinx.html.ButtonType
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.LI
import kotlinx.html.UL
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.id
import kotlinx.html.li
import kotlinx.html.ul

/**
 * The `<ul>` of tab toggles. Populate with [bsTabListItem]/[bsTabToggle].
 * https://getbootstrap.com/docs/5.3/components/navs-tabs/#javascript-behavior
 */
public fun FlowContent.bsTabList(
    id: String? = null,
    variant: NavVariant = NavVariant.Tabs,
    classes: String? = null,
    block: UL.() -> Unit = {},
): Unit {
    ul(classes = classNames("nav", variant.cssClass, classes)) {
        id?.let { this.id = it }
        attributes["role"] = "tablist"
        block()
    }
}

/** An item within a [bsTabList]. */
public fun UL.bsTabListItem(classes: String? = null, block: LI.() -> Unit = {}): Unit {
    li(classes = classNames("nav-item", classes)) {
        attributes["role"] = "presentation"
        block()
    }
}

/**
 * The button that activates a [bsTabPane]. [target] must match that pane's
 * `id`; [id] (if given) is this toggle's own id, typically referenced back
 * by the pane's `labelledBy`.
 */
public fun LI.bsTabToggle(
    target: String,
    id: String? = null,
    controls: String = target,
    active: Boolean = false,
    disabled: Boolean = false,
    classes: String? = null,
    block: BUTTON.() -> Unit = {},
): Unit {
    button(
        classes = classNames("nav-link", if (active) "active" else null, classes),
        type = ButtonType.button,
    ) {
        id?.let { this.id = it }
        attributes["data-bs-toggle"] = "tab"
        attributes["data-bs-target"] = "#$target"
        attributes["role"] = "tab"
        attributes["aria-controls"] = controls
        attributes["aria-selected"] = active.toString()
        if (disabled) {
            this.disabled = true
        }
        block()
    }
}

/**
 * The container for a [bsTabList]'s panes. Populate with [bsTabPane].
 */
public fun FlowContent.bsTabContent(classes: String? = null, block: DIV.() -> Unit = {}): Unit {
    div(classes = classNames("tab-content", classes), block = block)
}

/**
 * A single tab panel. [id] must match a [bsTabToggle]'s `target`.
 * https://getbootstrap.com/docs/5.3/components/navs-tabs/#javascript-behavior
 */
public fun DIV.bsTabPane(
    id: String,
    labelledBy: String? = null,
    active: Boolean = false,
    fade: Boolean = true,
    classes: String? = null,
    block: DIV.() -> Unit = {},
): Unit {
    div(
        classes = classNames(
            "tab-pane",
            if (fade) "fade" else null,
            if (active) (if (fade) "show active" else "active") else null,
            classes,
        ),
    ) {
        this.id = id
        attributes["role"] = "tabpanel"
        labelledBy?.let { attributes["aria-labelledby"] = it }
        attributes["tabindex"] = "0"
        block()
    }
}
