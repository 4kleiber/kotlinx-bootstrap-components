package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.bsButton
import io.github._4kleiber.bootstrap.bsCard
import io.github._4kleiber.bootstrap.bsCardBody
import io.github._4kleiber.bootstrap.bsCardText
import io.github._4kleiber.bootstrap.bsCardTitle
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML

internal fun HTML.cardPage() {
    galleryPage(pageTitle = "Card", currentPath = "/components/card") {
        intro("https://getbootstrap.com/docs/5.3/components/card/")

        example(
            "Card with title, text and a button",
            """
            bsCard {
                bsCardBody {
                    bsCardTitle { +"Card title" }
                    bsCardText { +"Some quick example text." }
                    bsButton { +"Go somewhere" }
                }
            }
            """.trimIndent(),
        ) {
            bsCard {
                bsCardBody {
                    bsCardTitle { +"Card title" }
                    bsCardText { +"Some quick example text." }
                    bsButton { +"Go somewhere" }
                }
            }
        }
    }
}
