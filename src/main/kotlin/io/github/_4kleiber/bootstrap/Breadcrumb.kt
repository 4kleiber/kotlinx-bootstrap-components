package io.github._4kleiber.bootstrap

import io.github._4kleiber.bootstrap.internal.classNames
import kotlinx.html.FlowContent
import kotlinx.html.LI
import kotlinx.html.OL
import kotlinx.html.li
import kotlinx.html.nav
import kotlinx.html.ol

/**
 * A Bootstrap breadcrumb. https://getbootstrap.com/docs/5.3/components/breadcrumb/
 */
public fun FlowContent.bsBreadcrumb(
    ariaLabel: String = "breadcrumb",
    classes: String? = null,
    block: OL.() -> Unit = {},
): Unit {
    nav(classes = classes) {
        attributes["aria-label"] = ariaLabel
        ol(classes = "breadcrumb", block = block)
    }
}

/**
 * An item within a [bsBreadcrumb]. Mark the current page with [active] — it
 * is rendered without a link and with `aria-current="page"`.
 */
public fun OL.bsBreadcrumbItem(
    active: Boolean = false,
    classes: String? = null,
    block: LI.() -> Unit = {},
): Unit {
    li(classes = classNames("breadcrumb-item", if (active) "active" else null, classes)) {
        if (active) {
            attributes["aria-current"] = "page"
        }
        block()
    }
}
