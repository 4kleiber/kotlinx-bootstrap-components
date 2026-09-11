package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.bsPageItem
import io.github._4kleiber.bootstrap.bsPagination
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML

internal fun HTML.paginationPage() {
    galleryPage(pageTitle = "Pagination", currentPath = "/components/pagination") {
        intro("https://getbootstrap.com/docs/5.3/components/pagination/")

        example(
            "Basic pagination",
            """
            bsPagination {
                bsPageItem(disabled = true) { +"Previous" }
                bsPageItem(active = true) { +"1" }
                bsPageItem { +"2" }
                bsPageItem { +"3" }
                bsPageItem { +"Next" }
            }
            """.trimIndent(),
        ) {
            bsPagination {
                bsPageItem(disabled = true) { +"Previous" }
                bsPageItem(active = true) { +"1" }
                bsPageItem { +"2" }
                bsPageItem { +"3" }
                bsPageItem { +"Next" }
            }
        }
    }
}
