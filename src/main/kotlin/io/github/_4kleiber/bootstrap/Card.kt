package io.github._4kleiber.bootstrap

import io.github._4kleiber.bootstrap.internal.classNames
import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.H5
import kotlinx.html.IMG
import kotlinx.html.P
import kotlinx.html.div
import kotlinx.html.h5
import kotlinx.html.img
import kotlinx.html.p

/**
 * A Bootstrap card container. Compose it with [bsCardHeader], [bsCardBody],
 * [bsCardTitle], [bsCardText], [bsCardImgTop] and [bsCardFooter] as needed.
 * https://getbootstrap.com/docs/5.3/components/card/
 */
public fun FlowContent.bsCard(
    classes: String? = null,
    block: DIV.() -> Unit = {},
): Unit {
    div(classes = classNames("card", classes), block = block)
}

/** https://getbootstrap.com/docs/5.3/components/card/#header-and-footer */
public fun FlowContent.bsCardHeader(
    classes: String? = null,
    block: DIV.() -> Unit = {},
): Unit {
    div(classes = classNames("card-header", classes), block = block)
}

/** https://getbootstrap.com/docs/5.3/components/card/#header-and-footer */
public fun FlowContent.bsCardFooter(
    classes: String? = null,
    block: DIV.() -> Unit = {},
): Unit {
    div(classes = classNames("card-footer", classes), block = block)
}

/** https://getbootstrap.com/docs/5.3/components/card/#body */
public fun FlowContent.bsCardBody(
    classes: String? = null,
    block: DIV.() -> Unit = {},
): Unit {
    div(classes = classNames("card-body", classes), block = block)
}

/** https://getbootstrap.com/docs/5.3/components/card/#titles-text-and-links */
public fun FlowContent.bsCardTitle(
    classes: String? = null,
    block: H5.() -> Unit = {},
): Unit {
    h5(classes = classNames("card-title", classes), block = block)
}

/** https://getbootstrap.com/docs/5.3/components/card/#titles-text-and-links */
public fun FlowContent.bsCardText(
    classes: String? = null,
    block: P.() -> Unit = {},
): Unit {
    p(classes = classNames("card-text", classes), block = block)
}

/** https://getbootstrap.com/docs/5.3/components/card/#images */
public fun FlowContent.bsCardImgTop(
    src: String,
    alt: String = "",
    classes: String? = null,
    block: IMG.() -> Unit = {},
): Unit {
    img(alt = alt, src = src, classes = classNames("card-img-top", classes), block = block)
}
