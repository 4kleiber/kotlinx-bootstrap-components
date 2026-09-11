package io.github._4kleiber.bootstrap

import io.github._4kleiber.bootstrap.internal.classNames
import kotlinx.html.FlowContent
import kotlinx.html.SPAN
import kotlinx.html.span

/** https://getbootstrap.com/docs/5.3/components/placeholders/#width */
public enum class PlaceholderSize(internal val cssClass: String) {
    ExtraSmall("placeholder-xs"),
    Small("placeholder-sm"),
    Large("placeholder-lg"),
}

/**
 * https://getbootstrap.com/docs/5.3/components/placeholders/#animation
 *
 * Unlike the other component enums, [cssClass] here is public: Bootstrap
 * applies this modifier to whichever element wraps a group of placeholders
 * (e.g. a [bsCardText]), so consumers need the raw class name to pass into
 * that wrapper's own `classes` parameter — there is no dedicated
 * `bsPlaceholderGroup` wrapper function.
 */
public enum class PlaceholderAnimation(public val cssClass: String) {
    Glow("placeholder-glow"),
    Wave("placeholder-wave"),
}

/**
 * A Bootstrap content placeholder ("skeleton") span. [width] is a grid column
 * width from `1..12`, applied as `col-<width>`.
 * https://getbootstrap.com/docs/5.3/components/placeholders/
 *
 * Wrap one or more placeholders in a container carrying a [PlaceholderAnimation]
 * class, e.g. `bsCardText(classes = PlaceholderAnimation.Glow.cssClass) { bsPlaceholder(6) }`.
 */
public fun FlowContent.bsPlaceholder(
    width: Int,
    size: PlaceholderSize? = null,
    classes: String? = null,
    block: SPAN.() -> Unit = {},
): Unit {
    span(
        classes = classNames("placeholder", "col-$width", size?.cssClass, classes),
        block = block,
    )
}
