package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TooltipTest {
    @Test
    fun `default tooltip carries toggle and title but no optional attributes`() {
        val html = createHTML().div { bsTooltip(title = "Hi") }
        assertTrue(html.contains("""data-bs-toggle="tooltip""""))
        assertTrue(html.contains("""data-bs-title="Hi""""))
        assertFalse(html.contains(""" title="Hi""""))
        assertFalse(html.contains("data-bs-placement"))
        assertFalse(html.contains("data-bs-trigger"))
        assertFalse(html.contains("data-bs-html"))
    }

    @Test
    fun `placement sets data-bs-placement`() {
        val html = createHTML().div { bsTooltip(title = "Hi", placement = TooltipPlacement.Left) }
        assertTrue(html.contains("""data-bs-placement="left""""))
    }

    @Test
    fun `trigger set joins values with a space`() {
        val html = createHTML().div {
            bsTooltip(title = "Hi", trigger = setOf(TooltipTrigger.Focus, TooltipTrigger.Manual))
        }
        assertTrue(html.contains("""data-bs-trigger="focus manual""""))
    }

    @Test
    fun `html true sets data-bs-html`() {
        val html = createHTML().div { bsTooltip(title = "Hi", html = true) }
        assertTrue(html.contains("""data-bs-html="true""""))
    }
}
