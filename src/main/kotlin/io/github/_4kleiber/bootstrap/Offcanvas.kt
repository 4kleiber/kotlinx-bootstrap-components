package io.github._4kleiber.bootstrap

import io.github._4kleiber.bootstrap.internal.classNames
import kotlinx.html.BUTTON
import kotlinx.html.ButtonType
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.H5
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.h5
import kotlinx.html.id

/** https://getbootstrap.com/docs/5.3/components/offcanvas/#placement */
public enum class OffcanvasPlacement(internal val cssClass: String) {
    Start("offcanvas-start"),
    End("offcanvas-end"),
    Top("offcanvas-top"),
    Bottom("offcanvas-bottom"),
}

/** A button that opens a [bsOffcanvas]. [target] must match that offcanvas's `id`. */
public fun FlowContent.bsOffcanvasTrigger(
    target: String,
    variant: ButtonVariant = ButtonVariant.Primary,
    size: ButtonSize? = null,
    classes: String? = null,
    block: BUTTON.() -> Unit = {},
): Unit {
    button(
        classes = classNames("btn", variant.cssClass, size?.let { "btn-${it.suffix}" }, classes),
        type = ButtonType.button,
    ) {
        attributes["data-bs-toggle"] = "offcanvas"
        attributes["data-bs-target"] = "#$target"
        attributes["aria-controls"] = target
        block()
    }
}

/**
 * A Bootstrap offcanvas panel. Pass the same id given to a [bsOffcanvasTitle]
 * as [labelledBy]. https://getbootstrap.com/docs/5.3/components/offcanvas/
 */
public fun FlowContent.bsOffcanvas(
    id: String,
    placement: OffcanvasPlacement = OffcanvasPlacement.Start,
    labelledBy: String? = null,
    backdrop: Boolean = true,
    scroll: Boolean = false,
    classes: String? = null,
    block: DIV.() -> Unit = {},
): Unit {
    div(classes = classNames("offcanvas", placement.cssClass, classes)) {
        this.id = id
        attributes["tabindex"] = "-1"
        labelledBy?.let { attributes["aria-labelledby"] = it }
        if (!backdrop) {
            attributes["data-bs-backdrop"] = "false"
        }
        if (scroll) {
            attributes["data-bs-scroll"] = "true"
        }
        block()
    }
}

/** Appends a [bsCloseButton] wired to `data-bs-dismiss="offcanvas"` unless [closeButton] is `false`. */
public fun DIV.bsOffcanvasHeader(
    closeButton: Boolean = true,
    classes: String? = null,
    block: DIV.() -> Unit = {},
): Unit {
    div(classes = classNames("offcanvas-header", classes)) {
        block()
        if (closeButton) {
            bsCloseButton(dismissTarget = "offcanvas")
        }
    }
}

/** Pass the same [id] as `labelledBy` on the enclosing [bsOffcanvas]. */
public fun DIV.bsOffcanvasTitle(
    id: String? = null,
    classes: String? = null,
    block: H5.() -> Unit = {},
): Unit {
    h5(classes = classNames("offcanvas-title", classes)) {
        id?.let { this.id = it }
        block()
    }
}

public fun DIV.bsOffcanvasBody(classes: String? = null, block: DIV.() -> Unit = {}): Unit {
    div(classes = classNames("offcanvas-body", classes), block = block)
}
