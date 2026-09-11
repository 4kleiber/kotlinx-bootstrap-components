package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.bsBreadcrumb
import io.github._4kleiber.bootstrap.bsBreadcrumbItem
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML

internal fun HTML.breadcrumbPage() {
    galleryPage(pageTitle = "Breadcrumb", currentPath = "/components/breadcrumb") {
        intro("https://getbootstrap.com/docs/5.3/components/breadcrumb/")

        example(
            "Breadcrumb with a current page",
            """
            bsBreadcrumb {
                bsBreadcrumbItem { +"Home" }
                bsBreadcrumbItem { +"Library" }
                bsBreadcrumbItem(active = true) { +"Data" }
            }
            """.trimIndent(),
        ) {
            bsBreadcrumb {
                bsBreadcrumbItem { +"Home" }
                bsBreadcrumbItem { +"Library" }
                bsBreadcrumbItem(active = true) { +"Data" }
            }
        }
    }
}
