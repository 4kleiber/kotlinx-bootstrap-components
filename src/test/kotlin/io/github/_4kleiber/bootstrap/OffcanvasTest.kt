package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertTrue

class OffcanvasTest {
    @Test
    fun `trigger carries data-bs-toggle target and aria-controls`() {
        val html = createHTML().div { bsOffcanvasTrigger(target = "side") { +"Open" } }
        assertTrue(html.contains("""data-bs-toggle="offcanvas""""))
        assertTrue(html.contains("""data-bs-target="#side""""))
        assertTrue(html.contains("""aria-controls="side""""))
    }

    @Test
    fun `offcanvas renders placement id and labelledby`() {
        val html = createHTML().div {
            bsOffcanvas(id = "side", placement = OffcanvasPlacement.End, labelledBy = "sideLabel") {
                bsOffcanvasHeader { bsOffcanvasTitle(id = "sideLabel") { +"Title" } }
                bsOffcanvasBody { +"Body" }
            }
        }
        assertTrue(html.contains("""class="offcanvas offcanvas-end""""))
        assertTrue(html.contains("""id="side""""))
        assertTrue(html.contains("""tabindex="-1""""))
        assertTrue(html.contains("""aria-labelledby="sideLabel""""))
        assertTrue(html.contains("""class="offcanvas-header""""))
        assertTrue(html.contains("""class="offcanvas-title""""))
        assertTrue(html.contains("""id="sideLabel""""))
        assertTrue(html.contains("""class="offcanvas-body""""))
        assertTrue(html.contains("""data-bs-dismiss="offcanvas""""))
    }

    @Test
    fun `backdrop false and scroll true set the expected data attributes`() {
        val html = createHTML().div { bsOffcanvas(id = "side", backdrop = false, scroll = true) {} }
        assertTrue(html.contains("""data-bs-backdrop="false""""))
        assertTrue(html.contains("""data-bs-scroll="true""""))
    }
}
