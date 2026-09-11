package io.github._4kleiber.bootstrap

import io.github._4kleiber.bootstrap.internal.classNames
import kotlinx.html.A
import kotlinx.html.BUTTON
import kotlinx.html.ButtonType
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.NAV
import kotlinx.html.SPAN
import kotlinx.html.UL
import kotlinx.html.a
import kotlinx.html.button
import kotlinx.html.nav
import kotlinx.html.span
import kotlinx.html.ul

/** https://getbootstrap.com/docs/5.3/components/navbar/#color-schemes */
public enum class NavbarTheme(internal val value: String) {
    Light("light"),
    Dark("dark"),
}

/**
 * A Bootstrap navbar. [expandAt] is the breakpoint at which it switches from
 * a collapsed, toggler-driven layout to fully expanded; `null` never expands.
 * https://getbootstrap.com/docs/5.3/components/navbar/
 */
public fun FlowContent.bsNavbar(
    expandAt: Breakpoint? = Breakpoint.Lg,
    theme: NavbarTheme? = null,
    classes: String? = null,
    block: NAV.() -> Unit = {},
): Unit {
    nav(classes = classNames("navbar", expandAt?.let { "navbar-expand-${it.infix}" }, classes)) {
        theme?.let { attributes["data-bs-theme"] = it.value }
        block()
    }
}

/** https://getbootstrap.com/docs/5.3/components/navbar/#brand */
public fun NAV.bsNavbarBrand(
    href: String = "#",
    classes: String? = null,
    block: A.() -> Unit = {},
): Unit {
    a(href = href, classes = classNames("navbar-brand", classes), block = block)
}

/**
 * The button that toggles a [bsNavbarCollapse]. [target] must match that
 * collapse's `id`. https://getbootstrap.com/docs/5.3/components/navbar/#toggler
 */
public fun NAV.bsNavbarToggler(
    target: String,
    ariaLabel: String = "Toggle navigation",
    classes: String? = null,
    block: BUTTON.() -> Unit = {},
): Unit {
    button(classes = classNames("navbar-toggler", classes), type = ButtonType.button) {
        attributes["data-bs-toggle"] = "collapse"
        attributes["data-bs-target"] = "#$target"
        attributes["aria-controls"] = target
        attributes["aria-expanded"] = "false"
        attributes["aria-label"] = ariaLabel
        span(classes = "navbar-toggler-icon") {}
        block()
    }
}

/**
 * The collapsible region holding the navbar's nav items. Delegates to
 * [bsCollapse] (`Collapse.kt`) with `navbar-collapse` added.
 */
public fun NAV.bsNavbarCollapse(
    id: String,
    classes: String? = null,
    block: DIV.() -> Unit = {},
): Unit {
    bsCollapse(id = id, classes = classNames("navbar-collapse", classes), block = block)
}

/**
 * The `<ul>` of nav items inside a navbar. Populate with [bsNavItem] /
 * [bsNavLink] from `Nav.kt`. https://getbootstrap.com/docs/5.3/components/navbar/#nav
 */
public fun FlowContent.bsNavbarNav(
    classes: String? = null,
    block: UL.() -> Unit = {},
): Unit {
    ul(classes = classNames("navbar-nav", classes), block = block)
}

/** https://getbootstrap.com/docs/5.3/components/navbar/#text */
public fun NAV.bsNavbarText(
    classes: String? = null,
    block: SPAN.() -> Unit = {},
): Unit {
    span(classes = classNames("navbar-text", classes), block = block)
}
