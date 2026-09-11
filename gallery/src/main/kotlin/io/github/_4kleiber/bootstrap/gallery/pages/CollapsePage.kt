package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.bsCollapse
import io.github._4kleiber.bootstrap.bsCollapseToggleButton
import io.github._4kleiber.bootstrap.bsCollapseToggleLink
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML
import kotlinx.html.div

internal fun HTML.collapsePage() {
    galleryPage(pageTitle = "Collapse", currentPath = "/components/collapse") {
        intro("https://getbootstrap.com/docs/5.3/components/collapse/ — requires Bootstrap's JS bundle to toggle.")

        example(
            "Button-toggled panel",
            """
            bsCollapseToggleButton(target = "panel") { +"Toggle" }
            bsCollapse(id = "panel") {
                div(classes = "card card-body") { +"Some collapsible content." }
            }
            """.trimIndent(),
        ) {
            bsCollapseToggleButton(target = "collapse-basic") { +"Toggle" }
            bsCollapse(id = "collapse-basic") {
                div(classes = "card card-body") { +"Some collapsible content." }
            }
        }

        example(
            "Link-style toggle",
            """bsCollapseToggleLink(target = "panel") { +"Toggle via link" }""",
        ) {
            bsCollapseToggleLink(target = "collapse-link") { +"Toggle via link" }
            bsCollapse(id = "collapse-link") {
                div(classes = "card card-body") { +"Same panel, triggered by a link." }
            }
        }

        example(
            "Horizontal collapse",
            """bsCollapse(id = "panel", horizontal = true) { ... }""",
        ) {
            div(classes = "d-flex") {
                bsCollapseToggleButton(target = "collapse-horizontal", classes = "me-2") { +"Toggle" }
            }
            bsCollapse(id = "collapse-horizontal", horizontal = true) {
                div(classes = "card card-body") { attributes["style"] = "width: 300px;"; +"Horizontal content." }
            }
        }
    }
}
