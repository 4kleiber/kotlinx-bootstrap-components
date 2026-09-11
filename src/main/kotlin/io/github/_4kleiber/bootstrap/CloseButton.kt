package io.github._4kleiber.bootstrap

import io.github._4kleiber.bootstrap.internal.classNames
import kotlinx.html.BUTTON
import kotlinx.html.ButtonType
import kotlinx.html.FlowContent
import kotlinx.html.button

/**
 * A Bootstrap dismiss ("close") button, used inside alerts, modals and toasts.
 * https://getbootstrap.com/docs/5.3/components/close-button/
 */
public fun FlowContent.bsCloseButton(
    ariaLabel: String = "Close",
    dismissTarget: String? = null,
    classes: String? = null,
    block: BUTTON.() -> Unit = {},
): Unit {
    button(classes = classNames("btn-close", classes), type = ButtonType.button) {
        attributes["aria-label"] = ariaLabel
        dismissTarget?.let { attributes["data-bs-dismiss"] = it }
        block()
    }
}
