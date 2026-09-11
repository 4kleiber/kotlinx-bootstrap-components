package io.github._4kleiber.bootstrap

import io.github._4kleiber.bootstrap.internal.classNames
import kotlinx.html.BUTTON
import kotlinx.html.ButtonType
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.H1
import kotlinx.html.button
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.id

/** https://getbootstrap.com/docs/5.3/components/modal/#optional-sizes */
public enum class ModalSize(internal val cssClass: String) {
    Small("modal-sm"),
    Large("modal-lg"),
    ExtraLarge("modal-xl"),
}

/** https://getbootstrap.com/docs/5.3/components/modal/#fullscreen-modal */
public enum class ModalFullscreen(internal val cssClass: String) {
    Always("modal-fullscreen"),
    BelowSm("modal-fullscreen-sm-down"),
    BelowMd("modal-fullscreen-md-down"),
    BelowLg("modal-fullscreen-lg-down"),
    BelowXl("modal-fullscreen-xl-down"),
    BelowXxl("modal-fullscreen-xxl-down"),
}

/** A button that opens a [bsModal]. [target] must match that modal's `id`. */
public fun FlowContent.bsModalTrigger(
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
        attributes["data-bs-toggle"] = "modal"
        attributes["data-bs-target"] = "#$target"
        block()
    }
}

/**
 * A Bootstrap modal — renders `modal` > `modal-dialog` > `modal-content` in
 * one call; [block] runs inside `modal-content`, where [bsModalHeader] /
 * [bsModalBody] / [bsModalFooter] are composed. Pass the same id given to a
 * [bsModalTitle] as [labelledBy]. https://getbootstrap.com/docs/5.3/components/modal/
 */
public fun FlowContent.bsModal(
    id: String,
    labelledBy: String? = null,
    size: ModalSize? = null,
    fullscreen: ModalFullscreen? = null,
    centered: Boolean = false,
    scrollable: Boolean = false,
    staticBackdrop: Boolean = false,
    classes: String? = null,
    block: DIV.() -> Unit = {},
): Unit {
    div(classes = classNames("modal", "fade", classes)) {
        this.id = id
        attributes["tabindex"] = "-1"
        attributes["aria-hidden"] = "true"
        labelledBy?.let { attributes["aria-labelledby"] = it }
        if (staticBackdrop) {
            attributes["data-bs-backdrop"] = "static"
            attributes["data-bs-keyboard"] = "false"
        }
        div(
            classes = classNames(
                "modal-dialog",
                size?.cssClass,
                fullscreen?.cssClass,
                if (centered) "modal-dialog-centered" else null,
                if (scrollable) "modal-dialog-scrollable" else null,
            ),
        ) {
            div(classes = "modal-content", block = block)
        }
    }
}

/** Appends a [bsCloseButton] wired to `data-bs-dismiss="modal"` unless [closeButton] is `false`. */
public fun DIV.bsModalHeader(
    closeButton: Boolean = true,
    classes: String? = null,
    block: DIV.() -> Unit = {},
): Unit {
    div(classes = classNames("modal-header", classes)) {
        block()
        if (closeButton) {
            bsCloseButton(dismissTarget = "modal")
        }
    }
}

/** Pass the same [id] as `labelledBy` on the enclosing [bsModal]. */
public fun DIV.bsModalTitle(
    id: String? = null,
    classes: String? = null,
    block: H1.() -> Unit = {},
): Unit {
    h1(classes = classNames("modal-title", "fs-5", classes)) {
        id?.let { this.id = it }
        block()
    }
}

public fun DIV.bsModalBody(classes: String? = null, block: DIV.() -> Unit = {}): Unit {
    div(classes = classNames("modal-body", classes), block = block)
}

public fun DIV.bsModalFooter(classes: String? = null, block: DIV.() -> Unit = {}): Unit {
    div(classes = classNames("modal-footer", classes), block = block)
}
