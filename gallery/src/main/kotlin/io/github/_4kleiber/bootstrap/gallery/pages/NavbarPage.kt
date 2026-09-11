package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.NavbarTheme
import io.github._4kleiber.bootstrap.bsNav
import io.github._4kleiber.bootstrap.bsNavItem
import io.github._4kleiber.bootstrap.bsNavLink
import io.github._4kleiber.bootstrap.bsNavbar
import io.github._4kleiber.bootstrap.bsNavbarBrand
import io.github._4kleiber.bootstrap.bsNavbarCollapse
import io.github._4kleiber.bootstrap.bsNavbarNav
import io.github._4kleiber.bootstrap.bsNavbarToggler
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML

internal fun HTML.navbarPage() {
    galleryPage(pageTitle = "Navbar", currentPath = "/components/navbar") {
        intro("https://getbootstrap.com/docs/5.3/components/navbar/ — the toggler needs Bootstrap's JS bundle to expand/collapse below its breakpoint.")

        example(
            "Brand + toggler + collapsible nav",
            """
            bsNavbar(classes = "bg-body-tertiary") {
                bsNavbarBrand { +"Navbar" }
                bsNavbarToggler(target = "navbarNav")
                bsNavbarCollapse(id = "navbarNav") {
                    bsNavbarNav {
                        bsNavItem { bsNavLink(active = true) { +"Home" } }
                        bsNavItem { bsNavLink { +"Features" } }
                        bsNavItem { bsNavLink { +"Pricing" } }
                    }
                }
            }
            """.trimIndent(),
        ) {
            bsNavbar(classes = "bg-body-tertiary") {
                bsNavbarBrand { +"Navbar" }
                bsNavbarToggler(target = "navbarNavExample")
                bsNavbarCollapse(id = "navbarNavExample") {
                    bsNavbarNav {
                        bsNavItem { bsNavLink(active = true) { +"Home" } }
                        bsNavItem { bsNavLink { +"Features" } }
                        bsNavItem { bsNavLink { +"Pricing" } }
                    }
                }
            }
        }

        example(
            "Dark theme",
            """bsNavbar(theme = NavbarTheme.Dark, classes = "bg-dark") { ... }""",
        ) {
            bsNavbar(theme = NavbarTheme.Dark, classes = "bg-dark") {
                bsNavbarBrand { +"Navbar" }
                bsNavbarToggler(target = "navbarDarkExample")
                bsNavbarCollapse(id = "navbarDarkExample") {
                    bsNav { bsNavItem { bsNavLink(active = true) { +"Home" } } }
                }
            }
        }
    }
}
