package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.ButtonVariant
import io.github._4kleiber.bootstrap.bsButton
import io.github._4kleiber.bootstrap.bsButtonGroup
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML

internal fun HTML.buttonGroupPage() {
    galleryPage(pageTitle = "Button group", currentPath = "/components/button-group") {
        intro("https://getbootstrap.com/docs/5.3/components/button-group/")

        example(
            "Basic group",
            """
            bsButtonGroup(ariaLabel = "Basic example") {
                bsButton(variant = ButtonVariant.Secondary) { +"Left" }
                bsButton(variant = ButtonVariant.Secondary) { +"Middle" }
                bsButton(variant = ButtonVariant.Secondary) { +"Right" }
            }
            """.trimIndent(),
        ) {
            bsButtonGroup(ariaLabel = "Basic example") {
                bsButton(variant = ButtonVariant.Secondary) { +"Left" }
                bsButton(variant = ButtonVariant.Secondary) { +"Middle" }
                bsButton(variant = ButtonVariant.Secondary) { +"Right" }
            }
        }
    }
}
