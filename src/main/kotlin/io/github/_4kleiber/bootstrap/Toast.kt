package io.github._4kleiber.bootstrap

import io.github._4kleiber.bootstrap.internal.classNames
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.div

/**
 * A positioning wrapper for one or more [bsToast]s.
 * https://getbootstrap.com/docs/5.3/components/toasts/#placement
 */
public fun FlowContent.bsToastContainer(classes: String? = null, block: DIV.() -> Unit = {}): Unit {
    div(classes = classNames("toast-container", classes), block = block)
}

/**
 * A Bootstrap toast. Bootstrap has no declarative trigger attribute for
 * toasts — they're normally shown imperatively via its JS API — so [show]
 * renders it already visible, useful for static rendering.
 * https://getbootstrap.com/docs/5.3/components/toasts/
 */
public fun FlowContent.bsToast(
    autohide: Boolean = true,
    delayMillis: Int? = null,
    show: Boolean = false,
    classes: String? = null,
    block: DIV.() -> Unit = {},
): Unit {
    div(classes = classNames("toast", if (show) "show" else null, classes)) {
        attributes["role"] = "alert"
        attributes["aria-live"] = "assertive"
        attributes["aria-atomic"] = "true"
        if (!autohide) {
            attributes["data-bs-autohide"] = "false"
        }
        delayMillis?.let { attributes["data-bs-delay"] = it.toString() }
        block()
    }
}

/** Appends a [bsCloseButton] wired to `data-bs-dismiss="toast"` unless [closeButton] is `false`. */
public fun DIV.bsToastHeader(
    closeButton: Boolean = true,
    classes: String? = null,
    block: DIV.() -> Unit = {},
): Unit {
    div(classes = classNames("toast-header", classes)) {
        block()
        if (closeButton) {
            bsCloseButton(dismissTarget = "toast")
        }
    }
}

public fun DIV.bsToastBody(classes: String? = null, block: DIV.() -> Unit = {}): Unit {
    div(classes = classNames("toast-body", classes), block = block)
}
