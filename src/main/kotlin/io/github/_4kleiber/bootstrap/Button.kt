package io.github._4kleiber.bootstrap

import io.github._4kleiber.bootstrap.internal.classNames
import kotlinx.html.BUTTON
import kotlinx.html.ButtonType
import kotlinx.html.FlowContent
import kotlinx.html.button

/** https://getbootstrap.com/docs/5.3/components/buttons/#examples */
public enum class ButtonVariant(internal val cssClass: String) {
    Primary("btn-primary"),
    Secondary("btn-secondary"),
    Success("btn-success"),
    Danger("btn-danger"),
    Warning("btn-warning"),
    Info("btn-info"),
    Light("btn-light"),
    Dark("btn-dark"),
    Link("btn-link"),
    OutlinePrimary("btn-outline-primary"),
    OutlineSecondary("btn-outline-secondary"),
    OutlineSuccess("btn-outline-success"),
    OutlineDanger("btn-outline-danger"),
    OutlineWarning("btn-outline-warning"),
    OutlineInfo("btn-outline-info"),
    OutlineLight("btn-outline-light"),
    OutlineDark("btn-outline-dark"),
}

/** https://getbootstrap.com/docs/5.3/components/buttons/#sizes */
public enum class ButtonSize(internal val suffix: String) {
    Small("sm"),
    Large("lg"),
}

/**
 * A Bootstrap `<button class="btn ...">`.
 * https://getbootstrap.com/docs/5.3/components/buttons/
 */
public fun FlowContent.bsButton(
    variant: ButtonVariant = ButtonVariant.Primary,
    size: ButtonSize? = null,
    disabled: Boolean = false,
    type: ButtonType = ButtonType.button,
    classes: String? = null,
    block: BUTTON.() -> Unit = {},
): Unit {
    button(
        classes = classNames("btn", variant.cssClass, size?.let { "btn-${it.suffix}" }, classes),
        type = type,
    ) {
        if (disabled) {
            this.disabled = true
        }
        block()
    }
}
