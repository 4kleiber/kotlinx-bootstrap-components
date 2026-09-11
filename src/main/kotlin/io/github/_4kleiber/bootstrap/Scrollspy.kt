package io.github._4kleiber.bootstrap

import kotlinx.html.CommonAttributeGroupFacade

/**
 * Marks the receiver as a Bootstrap scrollspy container — typically a scrollable element (needs
 * a set height and `overflow-y: scroll`, applied by the caller via `classes` or `attributes`) or
 * `<body>`. [target] must be the `id` of an existing [bsNav] (`Nav.kt`) or [bsListGroup]
 * (`ListGroup.kt`) — Scrollspy has no nav-rendering primitive of its own, it only annotates the
 * container being spied on. Like [bsTooltip], this mutates the caller's existing element rather
 * than rendering a new one, so it takes no `classes` parameter and no content block.
 *
 * **Bootstrap auto-initializes scrollspy from `data-bs-spy="scroll"` alone** — no consumer JS is
 * required, unlike [bsTooltip]/[bsPopover]. https://getbootstrap.com/docs/5.3/components/scrollspy/
 */
public fun CommonAttributeGroupFacade.bsScrollspy(
    target: String,
    rootMargin: String? = null,
    smoothScroll: Boolean = false,
): Unit {
    attributes["data-bs-spy"] = "scroll"
    attributes["data-bs-target"] = "#$target"
    rootMargin?.let { attributes["data-bs-root-margin"] = it }
    if (smoothScroll) {
        attributes["data-bs-smooth-scroll"] = "true"
    }
}
