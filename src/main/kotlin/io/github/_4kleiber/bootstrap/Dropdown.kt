package io.github._4kleiber.bootstrap

import io.github._4kleiber.bootstrap.internal.classNames
import kotlinx.html.A
import kotlinx.html.BUTTON
import kotlinx.html.ButtonType
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.H6
import kotlinx.html.UL
import kotlinx.html.a
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.h6
import kotlinx.html.hr
import kotlinx.html.li
import kotlinx.html.ul

/** https://getbootstrap.com/docs/5.3/components/dropdowns/#directions */
public enum class DropdownDirection(internal val cssClass: String) {
    Down("dropdown"),
    Up("dropup"),
    End("dropend"),
    Start("dropstart"),
}

/**
 * The positioned wrapper a [bsDropdownToggleButton] and its [bsDropdownMenu]
 * both live in. https://getbootstrap.com/docs/5.3/components/dropdowns/
 */
public fun FlowContent.bsDropdown(
    direction: DropdownDirection = DropdownDirection.Down,
    classes: String? = null,
    block: DIV.() -> Unit = {},
): Unit {
    div(classes = classNames(direction.cssClass, classes), block = block)
}

/**
 * The button that opens a [bsDropdown]'s menu. Must be a direct child of the
 * same [bsDropdown] wrapper as the [bsDropdownMenu] — Bootstrap's JS finds
 * the sibling menu by DOM proximity, not by id.
 */
public fun DIV.bsDropdownToggleButton(
    variant: ButtonVariant = ButtonVariant.Secondary,
    size: ButtonSize? = null,
    expanded: Boolean = false,
    classes: String? = null,
    block: BUTTON.() -> Unit = {},
): Unit {
    button(
        classes = classNames(
            "btn", variant.cssClass, size?.let { "btn-${it.suffix}" }, "dropdown-toggle", classes,
        ),
        type = ButtonType.button,
    ) {
        attributes["data-bs-toggle"] = "dropdown"
        attributes["aria-expanded"] = expanded.toString()
        block()
    }
}

/** https://getbootstrap.com/docs/5.3/components/dropdowns/ */
public fun DIV.bsDropdownMenu(
    dark: Boolean = false,
    alignEnd: Boolean = false,
    classes: String? = null,
    block: UL.() -> Unit = {},
): Unit {
    ul(
        classes = classNames(
            "dropdown-menu",
            if (dark) "dropdown-menu-dark" else null,
            if (alignEnd) "dropdown-menu-end" else null,
            classes,
        ),
        block = block,
    )
}

/** An actionable item within a [bsDropdownMenu]. */
public fun UL.bsDropdownItem(
    href: String = "#",
    active: Boolean = false,
    disabled: Boolean = false,
    classes: String? = null,
    block: A.() -> Unit = {},
): Unit {
    li {
        a(
            href = href,
            classes = classNames(
                "dropdown-item",
                if (active) "active" else null,
                if (disabled) "disabled" else null,
                classes,
            ),
        ) {
            if (active) {
                attributes["aria-current"] = "true"
            }
            if (disabled) {
                attributes["aria-disabled"] = "true"
                attributes["tabindex"] = "-1"
            }
            block()
        }
    }
}

/** A non-interactive heading within a [bsDropdownMenu]. */
public fun UL.bsDropdownHeader(classes: String? = null, block: H6.() -> Unit = {}): Unit {
    li { h6(classes = classNames("dropdown-header", classes), block = block) }
}

/** A visual divider between groups of items within a [bsDropdownMenu]. */
public fun UL.bsDropdownDivider(classes: String? = null): Unit {
    li { hr(classes = classNames("dropdown-divider", classes)) }
}
