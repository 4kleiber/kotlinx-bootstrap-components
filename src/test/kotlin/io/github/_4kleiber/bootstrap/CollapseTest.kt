package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertTrue

class CollapseTest {
    @Test
    fun `toggle button carries the expected data and aria attributes`() {
        val html = createHTML().div { bsCollapseToggleButton(target = "panel") { +"Toggle" } }
        assertTrue(html.contains("""data-bs-toggle="collapse""""))
        assertTrue(html.contains("""data-bs-target="#panel""""))
        assertTrue(html.contains("""aria-expanded="false""""))
        assertTrue(html.contains("""aria-controls="panel""""))
    }

    @Test
    fun `toggle link carries href and role`() {
        val html = createHTML().div { bsCollapseToggleLink(target = "panel", expanded = true) { +"Toggle" } }
        assertTrue(html.contains("""href="#panel""""))
        assertTrue(html.contains("""role="button""""))
        assertTrue(html.contains("""aria-expanded="true""""))
    }

    @Test
    fun `collapse panel carries id and show class`() {
        val html = createHTML().div { bsCollapse(id = "panel", show = true) { +"Body" } }
        assertTrue(html.contains("""id="panel""""))
        assertTrue(html.contains("""class="collapse show""""))
    }

    @Test
    fun `horizontal collapse adds the horizontal modifier class`() {
        val html = createHTML().div { bsCollapse(id = "panel", horizontal = true) {} }
        assertTrue(html.contains("""class="collapse collapse-horizontal""""))
    }
}
