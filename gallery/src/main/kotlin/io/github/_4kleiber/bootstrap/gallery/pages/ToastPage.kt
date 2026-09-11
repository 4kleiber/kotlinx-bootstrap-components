package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.bsToast
import io.github._4kleiber.bootstrap.bsToastBody
import io.github._4kleiber.bootstrap.bsToastContainer
import io.github._4kleiber.bootstrap.bsToastHeader
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML
import kotlinx.html.strong

internal fun HTML.toastPage() {
    galleryPage(pageTitle = "Toasts", currentPath = "/components/toast") {
        intro(
            "https://getbootstrap.com/docs/5.3/components/toasts/ — Bootstrap has no declarative " +
                "trigger attribute for toasts (they're normally shown imperatively via its JS API), " +
                "so these examples render with show = true and a static (non-fixed) container " +
                "position so they're visible inline on this page.",
        )

        example(
            "Toast with header and body",
            """
            bsToastContainer(classes = "position-static") {
                bsToast(show = true) {
                    bsToastHeader { strong(classes = "me-auto") { +"Bootstrap" } }
                    bsToastBody { +"Hello, world! This is a toast message." }
                }
            }
            """.trimIndent(),
        ) {
            bsToastContainer(classes = "position-static") {
                bsToast(show = true) {
                    bsToastHeader { strong(classes = "me-auto") { +"Bootstrap" } }
                    bsToastBody { +"Hello, world! This is a toast message." }
                }
            }
        }

        example(
            "No autohide, custom delay",
            """bsToast(autohide = false, delayMillis = 10000, show = true) { ... }""",
        ) {
            bsToastContainer(classes = "position-static") {
                bsToast(autohide = false, delayMillis = 10000, show = true) {
                    bsToastHeader { strong(classes = "me-auto") { +"Bootstrap" } }
                    bsToastBody { +"This toast won't auto-hide, and has a 10s delay configured." }
                }
            }
        }
    }
}
