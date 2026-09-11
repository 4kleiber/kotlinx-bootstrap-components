package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.bsListGroup
import io.github._4kleiber.bootstrap.bsListGroupItem
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML

internal fun HTML.listGroupPage() {
    galleryPage(pageTitle = "List group", currentPath = "/components/list-group") {
        intro("https://getbootstrap.com/docs/5.3/components/list-group/")

        example(
            "Basic list group with an active item",
            """
            bsListGroup {
                bsListGroupItem(active = true) { +"An active item" }
                bsListGroupItem { +"A second item" }
                bsListGroupItem { +"A third item" }
            }
            """.trimIndent(),
        ) {
            bsListGroup {
                bsListGroupItem(active = true) { +"An active item" }
                bsListGroupItem { +"A second item" }
                bsListGroupItem { +"A third item" }
            }
        }
    }
}
