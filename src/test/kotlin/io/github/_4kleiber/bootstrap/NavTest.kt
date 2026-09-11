package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertTrue

class NavTest {
    @Test
    fun `default nav renders items and an active link`() {
        val html = createHTML().div {
            bsNav {
                bsNavItem { bsNavLink(active = true) { +"Home" } }
                bsNavItem { bsNavLink { +"Link" } }
            }
        }
        assertTrue(html.contains("""class="nav""""))
        assertTrue(html.contains("""class="nav-item""""))
        assertTrue(html.contains("""class="nav-link active""""))
        assertTrue(html.contains("""aria-current="page""""))
    }

    @Test
    fun `pills variant with fill and justified compose correctly`() {
        val html = createHTML().div { bsNav(variant = NavVariant.Pills, fill = true, justified = true) {} }
        assertTrue(html.contains("""class="nav nav-pills nav-fill nav-justified""""))
    }

    @Test
    fun `vertical nav adds flex-column`() {
        val html = createHTML().div { bsNav(vertical = true) {} }
        assertTrue(html.contains("""class="nav flex-column""""))
    }

    @Test
    fun `disabled link sets tabindex and aria-disabled`() {
        val html = createHTML().div { bsNav { bsNavItem { bsNavLink(disabled = true) { +"Disabled" } } } }
        assertTrue(html.contains("""class="nav-link disabled""""))
        assertTrue(html.contains("""tabindex="-1""""))
        assertTrue(html.contains("""aria-disabled="true""""))
    }
}
