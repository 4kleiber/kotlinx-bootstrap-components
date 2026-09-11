package io.github._4kleiber.bootstrap

import kotlinx.html.CommonAttributeGroupFacade

/**
 * Shared by [bsTooltip] and [bsPopover] — both use the same 4-direction + auto placement
 * vocabulary. https://getbootstrap.com/docs/5.3/components/tooltips/#options
 */
public enum class TooltipPlacement(internal val cssValue: String) {
    Auto("auto"),
    Top("top"),
    Right("right"),
    Bottom("bottom"),
    Left("left"),
}

/**
 * Shared by [bsTooltip] and [bsPopover] — both accept the same trigger vocabulary.
 * https://getbootstrap.com/docs/5.3/components/tooltips/#options
 */
public enum class TooltipTrigger(internal val cssValue: String) {
    Click("click"),
    Hover("hover"),
    Focus("focus"),
    Manual("manual"),
}

/**
 * Marks the receiver as a Bootstrap tooltip trigger, using [title] as its `data-bs-title` (never
 * the native `title` attribute — Bootstrap 5.3 avoids that to prevent native browser tooltip
 * conflicts). Unlike every other function in this library, this one doesn't render a new
 * element — it mutates the `attributes` of whatever element the caller is already inside, so it
 * takes no `classes` parameter and no content block.
 *
 * **Bootstrap does not auto-initialize tooltips from data attributes alone** (unlike
 * Collapse/Modal/Dropdown/Tab) — the consuming page must also run, once per trigger element:
 * `new bootstrap.Tooltip(el)`. See the gallery's Tooltip page for a complete init script.
 * https://getbootstrap.com/docs/5.3/components/tooltips/
 *
 * [placement] and [trigger] default to `null`, which omits the corresponding attribute entirely
 * and leaves Bootstrap's own JS default (`top` / `hover focus`) in effect — this function never
 * hardcodes what that default is, only Bootstrap's JS does.
 */
public fun CommonAttributeGroupFacade.bsTooltip(
    title: String,
    placement: TooltipPlacement? = null,
    trigger: Set<TooltipTrigger>? = null,
    html: Boolean = false,
): Unit {
    attributes["data-bs-toggle"] = "tooltip"
    attributes["data-bs-title"] = title
    placement?.let { attributes["data-bs-placement"] = it.cssValue }
    trigger?.let { attributes["data-bs-trigger"] = it.joinToString(" ") { t -> t.cssValue } }
    if (html) {
        attributes["data-bs-html"] = "true"
    }
}
