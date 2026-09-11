package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.NavVariant
import io.github._4kleiber.bootstrap.bsNav
import io.github._4kleiber.bootstrap.bsNavItem
import io.github._4kleiber.bootstrap.bsNavLink
import io.github._4kleiber.bootstrap.bsScrollspy
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML
import kotlinx.html.div
import kotlinx.html.h4
import kotlinx.html.id
import kotlinx.html.p

internal fun HTML.scrollspyPage() {
    galleryPage(pageTitle = "Scrollspy", currentPath = "/components/scrollspy") {
        intro(
            "https://getbootstrap.com/docs/5.3/components/scrollspy/ — unlike Tooltips/Popovers, " +
                "this auto-initializes from data-bs-spy=\"scroll\" alone; no init script needed. " +
                "Scroll the box below to see the active nav link change.",
        )

        example(
            "Nav highlighted as its target scrolls",
            """
            bsNav(variant = NavVariant.Pills) {
                bsNavItem { bsNavLink(href = "#item-1", active = true) { +"Item 1" } }
                bsNavItem { bsNavLink(href = "#item-2") { +"Item 2" } }
                bsNavItem { bsNavLink(href = "#item-3") { +"Item 3" } }
            }
            div(classes = "border p-3 mt-2") {
                attributes["style"] = "height: 200px; overflow-y: scroll;"
                bsScrollspy(target = "scrollspy-nav")
                h4 { id = "item-1"; +"Item 1" }
                p { +"..." }
                h4 { id = "item-2"; +"Item 2" }
                p { +"..." }
                h4 { id = "item-3"; +"Item 3" }
                p { +"..." }
            }
            """.trimIndent(),
        ) {
            bsNav(variant = NavVariant.Pills, classes = "mb-2") {
                this.id = "scrollspy-nav"
                bsNavItem { bsNavLink(href = "#gallery-scrollspy-item-1", active = true) { +"Item 1" } }
                bsNavItem { bsNavLink(href = "#gallery-scrollspy-item-2") { +"Item 2" } }
                bsNavItem { bsNavLink(href = "#gallery-scrollspy-item-3") { +"Item 3" } }
            }
            div(classes = "border p-3") {
                attributes["style"] = "height: 200px; overflow-y: scroll;"
                bsScrollspy(target = "scrollspy-nav")
                h4 { id = "gallery-scrollspy-item-1"; +"Item 1" }
                p { +"Scroll this box — the nav link above tracks which heading is in view." }
                h4 { id = "gallery-scrollspy-item-2"; +"Item 2" }
                p { +"More filler content so this box actually scrolls." }
                h4 { id = "gallery-scrollspy-item-3"; +"Item 3" }
                p { +"Even more filler content." }
            }
        }
    }
}
