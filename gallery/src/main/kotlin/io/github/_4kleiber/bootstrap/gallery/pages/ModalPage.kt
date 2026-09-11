package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.ModalSize
import io.github._4kleiber.bootstrap.bsModal
import io.github._4kleiber.bootstrap.bsModalBody
import io.github._4kleiber.bootstrap.bsModalFooter
import io.github._4kleiber.bootstrap.bsModalHeader
import io.github._4kleiber.bootstrap.bsModalTitle
import io.github._4kleiber.bootstrap.bsModalTrigger
import io.github._4kleiber.bootstrap.bsButton
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML

internal fun HTML.modalPage() {
    galleryPage(pageTitle = "Modal", currentPath = "/components/modal") {
        intro("https://getbootstrap.com/docs/5.3/components/modal/ — requires Bootstrap's JS bundle to open.")

        example(
            "Default modal",
            """
            bsModalTrigger(target = "demo") { +"Launch demo modal" }
            bsModal(id = "demo", labelledBy = "demoLabel") {
                bsModalHeader { bsModalTitle(id = "demoLabel") { +"Modal title" } }
                bsModalBody { +"Modal body text goes here." }
                bsModalFooter {
                    bsButton(classes = "me-2") { +"Close" }
                    bsButton { +"Save changes" }
                }
            }
            """.trimIndent(),
        ) {
            bsModalTrigger(target = "modal-default") { +"Launch demo modal" }
            bsModal(id = "modal-default", labelledBy = "modal-default-label") {
                bsModalHeader { bsModalTitle(id = "modal-default-label") { +"Modal title" } }
                bsModalBody { +"Modal body text goes here." }
                bsModalFooter {
                    bsButton(classes = "me-2") { +"Close" }
                    bsButton { +"Save changes" }
                }
            }
        }

        example(
            "Centered, scrollable, large",
            """bsModal(id = "demo", size = ModalSize.Large, centered = true, scrollable = true) { ... }""",
        ) {
            bsModalTrigger(target = "modal-scroll") { +"Launch scrollable modal" }
            bsModal(id = "modal-scroll", size = ModalSize.Large, centered = true, scrollable = true) {
                bsModalHeader { bsModalTitle { +"Scrollable modal" } }
                bsModalBody { +"Long content would scroll within the modal body here." }
            }
        }

        example(
            "Static backdrop",
            """bsModal(id = "demo", staticBackdrop = true) { ... }""",
        ) {
            bsModalTrigger(target = "modal-static") { +"Launch static backdrop modal" }
            bsModal(id = "modal-static", labelledBy = "modal-static-label", staticBackdrop = true) {
                bsModalHeader { bsModalTitle(id = "modal-static-label") { +"Static backdrop" } }
                bsModalBody { +"Clicking outside this modal will not close it." }
            }
        }
    }
}
