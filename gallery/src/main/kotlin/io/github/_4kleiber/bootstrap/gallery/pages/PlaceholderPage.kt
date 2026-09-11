package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.PlaceholderAnimation
import io.github._4kleiber.bootstrap.bsCardBody
import io.github._4kleiber.bootstrap.bsCardText
import io.github._4kleiber.bootstrap.bsCardTitle
import io.github._4kleiber.bootstrap.bsPlaceholder
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML
import kotlinx.html.div

internal fun HTML.placeholderPage() {
    galleryPage(pageTitle = "Placeholders", currentPath = "/components/placeholder") {
        intro("https://getbootstrap.com/docs/5.3/components/placeholders/")

        example(
            "Placeholder glow, inside a card",
            """
            bsCardBody {
                bsCardTitle(classes = PlaceholderAnimation.Glow.cssClass) { bsPlaceholder(width = 6) }
                bsCardText(classes = PlaceholderAnimation.Glow.cssClass) {
                    bsPlaceholder(width = 7)
                    bsPlaceholder(width = 4)
                    bsPlaceholder(width = 4)
                    bsPlaceholder(width = 6)
                }
            }
            """.trimIndent(),
        ) {
            div(classes = "card") {
                bsCardBody {
                    bsCardTitle(classes = PlaceholderAnimation.Glow.cssClass) { bsPlaceholder(width = 6) }
                    bsCardText(classes = PlaceholderAnimation.Glow.cssClass) {
                        bsPlaceholder(width = 7)
                        bsPlaceholder(width = 4)
                        bsPlaceholder(width = 4)
                        bsPlaceholder(width = 6)
                    }
                }
            }
        }
    }
}
