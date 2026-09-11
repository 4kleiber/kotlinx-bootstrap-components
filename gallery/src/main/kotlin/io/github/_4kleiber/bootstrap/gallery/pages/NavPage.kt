package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.NavVariant
import io.github._4kleiber.bootstrap.bsNav
import io.github._4kleiber.bootstrap.bsNavItem
import io.github._4kleiber.bootstrap.bsNavLink
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML

internal fun HTML.navPage() {
    galleryPage(pageTitle = "Navs", currentPath = "/components/nav") {
        intro("https://getbootstrap.com/docs/5.3/components/navs-tabs/ — for tabbed panels, see the Tabs page.")

        example(
            "Default nav",
            """
            bsNav {
                bsNavItem { bsNavLink(active = true) { +"Active" } }
                bsNavItem { bsNavLink { +"Link" } }
                bsNavItem { bsNavLink(disabled = true) { +"Disabled" } }
            }
            """.trimIndent(),
        ) {
            bsNav {
                bsNavItem { bsNavLink(active = true) { +"Active" } }
                bsNavItem { bsNavLink { +"Link" } }
                bsNavItem { bsNavLink(disabled = true) { +"Disabled" } }
            }
        }

        example("Pills", """bsNav(variant = NavVariant.Pills) { ... }""") {
            bsNav(variant = NavVariant.Pills) {
                bsNavItem { bsNavLink(active = true) { +"Active" } }
                bsNavItem { bsNavLink { +"Link" } }
            }
        }

        example("Underline", """bsNav(variant = NavVariant.Underline) { ... }""") {
            bsNav(variant = NavVariant.Underline) {
                bsNavItem { bsNavLink(active = true) { +"Active" } }
                bsNavItem { bsNavLink { +"Link" } }
            }
        }

        example("Vertical", "bsNav(vertical = true) { ... }") {
            bsNav(vertical = true) {
                bsNavItem { bsNavLink(active = true) { +"Active" } }
                bsNavItem { bsNavLink { +"Link" } }
            }
        }
    }
}
