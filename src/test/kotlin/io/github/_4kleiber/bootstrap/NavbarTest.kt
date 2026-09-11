package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertTrue

class NavbarTest {
    @Test
    fun `navbar renders expand class and theme`() {
        val html = createHTML().div { bsNavbar(theme = NavbarTheme.Dark) { bsNavbarBrand { +"Brand" } } }
        assertTrue(html.contains("""class="navbar navbar-expand-lg""""))
        assertTrue(html.contains("""data-bs-theme="dark""""))
        assertTrue(html.contains("""class="navbar-brand""""))
    }

    @Test
    fun `toggler carries data and aria attributes plus the icon span`() {
        val html = createHTML().div { bsNavbar { bsNavbarToggler(target = "nav") } }
        assertTrue(html.contains("""class="navbar-toggler""""))
        assertTrue(html.contains("""data-bs-toggle="collapse""""))
        assertTrue(html.contains("""data-bs-target="#nav""""))
        assertTrue(html.contains("""aria-controls="nav""""))
        assertTrue(html.contains("""aria-expanded="false""""))
        assertTrue(html.contains("""class="navbar-toggler-icon""""))
    }

    @Test
    fun `navbar collapse delegates to bsCollapse and adds navbar-collapse`() {
        val html = createHTML().div {
            bsNavbar {
                bsNavbarCollapse(id = "nav") {
                    bsNavbarNav { bsNavItem { bsNavLink(active = true) { +"Home" } } }
                }
            }
        }
        assertTrue(html.contains("""class="collapse navbar-collapse""""))
        assertTrue(html.contains("""id="nav""""))
        assertTrue(html.contains("""class="navbar-nav""""))
    }
}
