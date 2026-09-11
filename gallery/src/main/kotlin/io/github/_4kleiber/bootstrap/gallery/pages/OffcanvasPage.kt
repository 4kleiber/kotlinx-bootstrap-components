package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.OffcanvasPlacement
import io.github._4kleiber.bootstrap.bsOffcanvas
import io.github._4kleiber.bootstrap.bsOffcanvasBody
import io.github._4kleiber.bootstrap.bsOffcanvasHeader
import io.github._4kleiber.bootstrap.bsOffcanvasTitle
import io.github._4kleiber.bootstrap.bsOffcanvasTrigger
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML

internal fun HTML.offcanvasPage() {
    galleryPage(pageTitle = "Offcanvas", currentPath = "/components/offcanvas") {
        intro("https://getbootstrap.com/docs/5.3/components/offcanvas/ — requires Bootstrap's JS bundle to open.")

        OffcanvasPlacement.entries.forEach { placement ->
            example(
                placement.name,
                """bsOffcanvas(id = "side", placement = OffcanvasPlacement.${placement.name}) { ... }""",
            ) {
                bsOffcanvasTrigger(target = "offcanvas-${placement.name.lowercase()}") { +"Open ${placement.name}" }
                bsOffcanvas(
                    id = "offcanvas-${placement.name.lowercase()}",
                    placement = placement,
                    labelledBy = "offcanvas-${placement.name.lowercase()}-label",
                ) {
                    bsOffcanvasHeader {
                        bsOffcanvasTitle(id = "offcanvas-${placement.name.lowercase()}-label") { +placement.name }
                    }
                    bsOffcanvasBody { +"Offcanvas body content." }
                }
            }
        }
    }
}
