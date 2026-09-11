package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PopoverTest {
    @Test
    fun `default popover carries toggle and content but omits title`() {
        val html = createHTML().div { bsPopover(content = "Body text") }
        assertTrue(html.contains("""data-bs-toggle="popover""""))
        assertTrue(html.contains("""data-bs-content="Body text""""))
        assertFalse(html.contains("data-bs-title"))
    }

    @Test
    fun `title is included when given`() {
        val html = createHTML().div { bsPopover(content = "Body", title = "Header") }
        assertTrue(html.contains("""data-bs-content="Body""""))
        assertTrue(html.contains("""data-bs-title="Header""""))
    }

    @Test
    fun `placement sets data-bs-placement`() {
        val html = createHTML().div { bsPopover(content = "Body", placement = TooltipPlacement.Bottom) }
        assertTrue(html.contains("""data-bs-placement="bottom""""))
    }

    @Test
    fun `trigger set joins values with a space`() {
        val html = createHTML().div { bsPopover(content = "Body", trigger = setOf(TooltipTrigger.Focus)) }
        assertTrue(html.contains("""data-bs-trigger="focus""""))
    }

    @Test
    fun `html true sets data-bs-html`() {
        val html = createHTML().div { bsPopover(content = "Body", html = true) }
        assertTrue(html.contains("""data-bs-html="true""""))
    }
}
