package io.github._4kleiber.bootstrap

import io.github._4kleiber.bootstrap.internal.classNames
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.div

/**
 * A Bootstrap progress bar. `value` is a percentage in `0..100`.
 * https://getbootstrap.com/docs/5.3/components/progress/
 */
public fun FlowContent.bsProgress(
    value: Int,
    min: Int = 0,
    max: Int = 100,
    striped: Boolean = false,
    animated: Boolean = false,
    label: String? = null,
    classes: String? = null,
    block: DIV.() -> Unit = {},
): Unit {
    div(classes = classNames("progress", classes)) {
        attributes["role"] = "progressbar"
        attributes["aria-label"] = label ?: "Progress"
        attributes["aria-valuenow"] = value.toString()
        attributes["aria-valuemin"] = min.toString()
        attributes["aria-valuemax"] = max.toString()
        div(
            classes = classNames(
                "progress-bar",
                if (striped || animated) "progress-bar-striped" else null,
                if (animated) "progress-bar-animated" else null,
            ),
        ) {
            attributes["style"] = "width: $value%"
            if (label != null) {
                +label
            }
        }
        block()
    }
}
