package io.github._4kleiber.bootstrap

import io.github._4kleiber.bootstrap.internal.classNames
import kotlinx.html.A
import kotlinx.html.FlowContent
import kotlinx.html.LI
import kotlinx.html.UL
import kotlinx.html.a
import kotlinx.html.li
import kotlinx.html.ul

/** https://getbootstrap.com/docs/5.3/components/navs-tabs/#base-nav */
public enum class NavVariant(internal val cssClass: String) {
    Tabs("nav-tabs"),
    Pills("nav-pills"),
    Underline("nav-underline"),
}

/**
 * A Bootstrap nav. https://getbootstrap.com/docs/5.3/components/navs-tabs/
 */
public fun FlowContent.bsNav(
    variant: NavVariant? = null,
    fill: Boolean = false,
    justified: Boolean = false,
    vertical: Boolean = false,
    classes: String? = null,
    block: UL.() -> Unit = {},
): Unit {
    ul(
        classes = classNames(
            "nav",
            variant?.cssClass,
            if (fill) "nav-fill" else null,
            if (justified) "nav-justified" else null,
            if (vertical) "flex-column" else null,
            classes,
        ),
        block = block,
    )
}

/** An item within a [bsNav]. */
public fun UL.bsNavItem(classes: String? = null, block: LI.() -> Unit = {}): Unit {
    li(classes = classNames("nav-item", classes), block = block)
}

/** A link within a [bsNavItem]. */
public fun LI.bsNavLink(
    href: String = "#",
    active: Boolean = false,
    disabled: Boolean = false,
    classes: String? = null,
    block: A.() -> Unit = {},
): Unit {
    a(
        href = href,
        classes = classNames(
            "nav-link",
            if (active) "active" else null,
            if (disabled) "disabled" else null,
            classes,
        ),
    ) {
        if (active) {
            attributes["aria-current"] = "page"
        }
        if (disabled) {
            attributes["tabindex"] = "-1"
            attributes["aria-disabled"] = "true"
        }
        block()
    }
}
