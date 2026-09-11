package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.Breakpoint
import io.github._4kleiber.bootstrap.bsCol
import io.github._4kleiber.bootstrap.bsContainer
import io.github._4kleiber.bootstrap.bsRow
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML

internal fun HTML.gridPage() {
    galleryPage(pageTitle = "Grid", currentPath = "/components/grid") {
        intro("https://getbootstrap.com/docs/5.3/layout/grid/ — Container, Row and Col.")

        example(
            "Equal-width columns",
            """
            bsContainer {
                bsRow {
                    bsCol { +"Column" }
                    bsCol { +"Column" }
                    bsCol { +"Column" }
                }
            }
            """.trimIndent(),
        ) {
            bsContainer {
                bsRow {
                    bsCol(classes = "border p-2") { +"Column" }
                    bsCol(classes = "border p-2") { +"Column" }
                    bsCol(classes = "border p-2") { +"Column" }
                }
            }
        }

        example(
            "Responsive column widths",
            """bsCol(span = 12, at = mapOf(Breakpoint.Md to 6, Breakpoint.Lg to 4)) { +"..." }""",
        ) {
            bsContainer {
                bsRow {
                    bsCol(span = 12, at = mapOf(Breakpoint.Md to 6, Breakpoint.Lg to 4), classes = "border p-2") {
                        +"col-12 col-md-6 col-lg-4"
                    }
                }
            }
        }
    }
}
