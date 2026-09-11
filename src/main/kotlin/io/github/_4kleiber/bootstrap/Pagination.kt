package io.github._4kleiber.bootstrap

import io.github._4kleiber.bootstrap.internal.classNames
import kotlinx.html.A
import kotlinx.html.FlowContent
import kotlinx.html.UL
import kotlinx.html.a
import kotlinx.html.li
import kotlinx.html.nav
import kotlinx.html.ul

/**
 * A Bootstrap pagination component. https://getbootstrap.com/docs/5.3/components/pagination/
 */
public fun FlowContent.bsPagination(
    ariaLabel: String = "Page navigation",
    size: ButtonSize? = null,
    classes: String? = null,
    block: UL.() -> Unit = {},
): Unit {
    nav {
        attributes["aria-label"] = ariaLabel
        ul(
            classes = classNames("pagination", size?.let { "pagination-${it.suffix}" }, classes),
            block = block,
        )
    }
}

/**
 * A page link within a [bsPagination]. [href] defaults to `"#"` since page
 * navigation is usually wired up by the consumer's own routing.
 */
public fun UL.bsPageItem(
    href: String = "#",
    active: Boolean = false,
    disabled: Boolean = false,
    classes: String? = null,
    block: A.() -> Unit = {},
): Unit {
    li(classes = classNames("page-item", if (active) "active" else null, if (disabled) "disabled" else null, classes)) {
        if (active) {
            attributes["aria-current"] = "page"
        }
        a(href = href, classes = "page-link") {
            if (disabled) {
                attributes["tabindex"] = "-1"
                attributes["aria-disabled"] = "true"
            }
            block()
        }
    }
}
