package io.github._4kleiber.bootstrap

import kotlinx.html.CommonAttributeGroupFacade

/**
 * Marks the receiver as a Bootstrap popover trigger. [content] becomes `data-bs-content` (the
 * popover body); [title], if given, becomes `data-bs-title` (the popover header — omitted
 * entirely when `null`). Like [bsTooltip], this mutates the caller's existing element rather
 * than rendering a new one, so it takes no `classes` parameter and no content block.
 *
 * **Bootstrap does not auto-initialize popovers from data attributes alone** — the consuming
 * page must run `new bootstrap.Popover(el)` once per trigger element; see the gallery's Popover
 * page. https://getbootstrap.com/docs/5.3/components/popovers/
 *
 * [placement] and [trigger] default to `null` (attribute omitted, Bootstrap's own popover
 * defaults — `right` / `click`, which differ from Tooltip's `top` / `hover focus` — apply).
 */
public fun CommonAttributeGroupFacade.bsPopover(
    content: String,
    title: String? = null,
    placement: TooltipPlacement? = null,
    trigger: Set<TooltipTrigger>? = null,
    html: Boolean = false,
): Unit {
    attributes["data-bs-toggle"] = "popover"
    attributes["data-bs-content"] = content
    title?.let { attributes["data-bs-title"] = it }
    placement?.let { attributes["data-bs-placement"] = it.cssValue }
    trigger?.let { attributes["data-bs-trigger"] = it.joinToString(" ") { t -> t.cssValue } }
    if (html) {
        attributes["data-bs-html"] = "true"
    }
}
