package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.ButtonSize
import io.github._4kleiber.bootstrap.ButtonVariant
import io.github._4kleiber.bootstrap.bsButton
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML

internal fun HTML.buttonPage() {
    galleryPage(pageTitle = "Buttons", currentPath = "/components/button") {
        intro("https://getbootstrap.com/docs/5.3/components/buttons/")

        example("Variants", """bsButton(variant = ButtonVariant.Success) { +"Success" }""") {
            ButtonVariant.entries.forEach { variant ->
                bsButton(variant = variant, classes = "me-2 mb-2") { +variant.name }
            }
        }

        example("Sizes", """bsButton(size = ButtonSize.Large) { +"Large" }""") {
            bsButton(size = ButtonSize.Large, classes = "me-2") { +"Large" }
            bsButton { +"Default" }
            bsButton(size = ButtonSize.Small, classes = "ms-2") { +"Small" }
        }

        example("Disabled", """bsButton(disabled = true) { +"Can't click me" }""") {
            bsButton(disabled = true) { +"Can't click me" }
        }
    }
}
