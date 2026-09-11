package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertTrue

class GridTest {
    @Test
    fun `default container is fixed-width`() {
        val html = createHTML().div { bsContainer { bsRow { bsCol { +"content" } } } }
        assertTrue(html.contains("""class="container""""))
        assertTrue(html.contains("""class="row""""))
        assertTrue(html.contains("""class="col""""))
    }

    @Test
    fun `fluid container and sized column compose correctly`() {
        val html = createHTML().div {
            bsContainer(fluid = true) {
                bsCol(span = 6, at = mapOf(Breakpoint.Md to 4, Breakpoint.Lg to 3)) { +"content" }
            }
        }
        assertTrue(html.contains("""class="container-fluid""""))
        assertTrue(html.contains("""class="col-6 col-md-4 col-lg-3""""))
    }

    @Test
    fun `breakpoint-specific container uses container-md etc`() {
        val html = createHTML().div { bsContainer(at = Breakpoint.Md) {} }
        assertTrue(html.contains("""class="container-md""""))
    }
}
