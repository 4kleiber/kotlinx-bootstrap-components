package io.github._4kleiber.bootstrap

import io.github._4kleiber.bootstrap.internal.classNames
import kotlinx.html.ButtonType
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.id
import kotlinx.html.span

/**
 * https://getbootstrap.com/docs/5.3/components/carousel/#autoplaying-carousels — `data-bs-ride`
 * has two distinct autoplay behaviors, not a simple on/off.
 */
public enum class CarouselRide(internal val cssValue: String) {
    /** `data-bs-ride="carousel"` — autoplays on page load. */
    Carousel("carousel"),

    /** `data-bs-ride="true"` — autoplays only after the user manually cycles the first item. */
    OnInteraction("true"),
}

/**
 * The root carousel element. Set [ride] to [CarouselRide.Carousel] for a fully data-attribute-
 * driven autoplaying carousel — Bootstrap's JS auto-initializes elements matching
 * `[data-bs-ride="carousel"]` on page load with no consumer JS required (unlike Tooltip/Popover).
 * Without [ride], the carousel still renders correctly but needs `new bootstrap.Carousel(el)` to
 * become interactive.
 * https://getbootstrap.com/docs/5.3/components/carousel/
 */
public fun FlowContent.bsCarousel(
    id: String,
    ride: CarouselRide? = null,
    crossfade: Boolean = false,
    classes: String? = null,
    block: DIV.() -> Unit = {},
): Unit {
    div(classes = classNames("carousel", "slide", if (crossfade) "carousel-fade" else null, classes)) {
        this.id = id
        ride?.let { attributes["data-bs-ride"] = it.cssValue }
        block()
    }
}

/** Wraps one or more [bsCarouselIndicator]s. */
public fun DIV.bsCarouselIndicators(classes: String? = null, block: DIV.() -> Unit = {}): Unit {
    div(classes = classNames("carousel-indicators", classes), block = block)
}

/** One indicator button within [bsCarouselIndicators]. [target] must match the enclosing [bsCarousel]'s `id`. */
public fun DIV.bsCarouselIndicator(
    target: String,
    index: Int,
    active: Boolean = false,
    ariaLabel: String = "Slide ${index + 1}",
    classes: String? = null,
): Unit {
    button(classes = classNames(if (active) "active" else null, classes), type = ButtonType.button) {
        attributes["data-bs-target"] = "#$target"
        attributes["data-bs-slide-to"] = index.toString()
        attributes["aria-label"] = ariaLabel
        if (active) {
            attributes["aria-current"] = "true"
        }
    }
}

/** Wraps one or more [bsCarouselItem]s. */
public fun DIV.bsCarouselInner(classes: String? = null, block: DIV.() -> Unit = {}): Unit {
    div(classes = classNames("carousel-inner", classes), block = block)
}

/**
 * One slide. Exactly one [bsCarouselItem] per [bsCarousel] must have [active] `true` — Bootstrap
 * requires it, the carousel is invisible otherwise. [intervalMillis], if set, overrides this
 * item's individual autoplay delay (`data-bs-interval`) independent of the carousel-wide default.
 */
public fun DIV.bsCarouselItem(
    active: Boolean = false,
    intervalMillis: Int? = null,
    classes: String? = null,
    block: DIV.() -> Unit = {},
): Unit {
    div(classes = classNames("carousel-item", if (active) "active" else null, classes)) {
        intervalMillis?.let { attributes["data-bs-interval"] = it.toString() }
        block()
    }
}

/** An optional caption overlay within a [bsCarouselItem]. */
public fun DIV.bsCarouselCaption(classes: String? = null, block: DIV.() -> Unit = {}): Unit {
    div(classes = classNames("carousel-caption", classes), block = block)
}

/** [target] must match the enclosing [bsCarousel]'s `id`. */
public fun DIV.bsCarouselControlPrev(
    target: String,
    visuallyHiddenText: String = "Previous",
    classes: String? = null,
): Unit {
    button(classes = classNames("carousel-control-prev", classes), type = ButtonType.button) {
        attributes["data-bs-target"] = "#$target"
        attributes["data-bs-slide"] = "prev"
        span(classes = "carousel-control-prev-icon") { attributes["aria-hidden"] = "true" }
        span(classes = "visually-hidden") { +visuallyHiddenText }
    }
}

/** [target] must match the enclosing [bsCarousel]'s `id`. */
public fun DIV.bsCarouselControlNext(
    target: String,
    visuallyHiddenText: String = "Next",
    classes: String? = null,
): Unit {
    button(classes = classNames("carousel-control-next", classes), type = ButtonType.button) {
        attributes["data-bs-target"] = "#$target"
        attributes["data-bs-slide"] = "next"
        span(classes = "carousel-control-next-icon") { attributes["aria-hidden"] = "true" }
        span(classes = "visually-hidden") { +visuallyHiddenText }
    }
}
