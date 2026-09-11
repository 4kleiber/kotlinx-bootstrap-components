package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.AlertVariant
import io.github._4kleiber.bootstrap.bsAlert
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML

internal fun HTML.alertPage() {
    galleryPage(pageTitle = "Alerts", currentPath = "/components/alert") {
        intro("https://getbootstrap.com/docs/5.3/components/alerts/")

        example("Variants", """bsAlert(variant = AlertVariant.Success) { +"Well done!" }""") {
            AlertVariant.entries.forEach { variant ->
                bsAlert(variant = variant) { +"A simple ${variant.name.lowercase()} alert." }
            }
        }

        example(
            "Dismissible",
            """bsAlert(dismissible = true) { +"Holler! You can dismiss me." }""",
        ) {
            bsAlert(dismissible = true) { +"Holler! You can dismiss me." }
        }
    }
}
