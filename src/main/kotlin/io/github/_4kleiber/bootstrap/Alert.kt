package io.github._4kleiber.bootstrap

import io.github._4kleiber.bootstrap.internal.classNames
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.div

/** https://getbootstrap.com/docs/5.3/components/alerts/#examples */
public enum class AlertVariant(internal val cssClass: String) {
    Primary("alert-primary"),
    Secondary("alert-secondary"),
    Success("alert-success"),
    Danger("alert-danger"),
    Warning("alert-warning"),
    Info("alert-info"),
    Light("alert-light"),
    Dark("alert-dark"),
}

/**
 * A Bootstrap alert. When [dismissible] is `true` this also renders the
 * `alert-dismissible` modifier classes and a [bsCloseButton] wired to
 * `data-bs-dismiss="alert"`.
 * https://getbootstrap.com/docs/5.3/components/alerts/
 */
public fun FlowContent.bsAlert(
    variant: AlertVariant = AlertVariant.Primary,
    dismissible: Boolean = false,
    classes: String? = null,
    block: DIV.() -> Unit = {},
): Unit {
    div(
        classes = classNames(
            "alert",
            variant.cssClass,
            if (dismissible) "alert-dismissible fade show" else null,
            classes,
        ),
    ) {
        attributes["role"] = "alert"
        block()
        if (dismissible) {
            bsCloseButton(dismissTarget = "alert")
        }
    }
}
