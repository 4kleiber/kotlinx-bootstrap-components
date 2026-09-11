package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ScrollspyTest {
    @Test
    fun `default scrollspy sets spy and target but omits optional attributes`() {
        val html = createHTML().div { bsScrollspy(target = "nav") }
        assertTrue(html.contains("""data-bs-spy="scroll""""))
        assertTrue(html.contains("""data-bs-target="#nav""""))
        assertFalse(html.contains("data-bs-root-margin"))
        assertFalse(html.contains("data-bs-smooth-scroll"))
    }

    @Test
    fun `rootMargin sets data-bs-root-margin`() {
        val html = createHTML().div { bsScrollspy(target = "nav", rootMargin = "0px 0px -40%") }
        assertTrue(html.contains("""data-bs-root-margin="0px 0px -40%""""))
    }

    @Test
    fun `smoothScroll true sets data-bs-smooth-scroll`() {
        val html = createHTML().div { bsScrollspy(target = "nav", smoothScroll = true) }
        assertTrue(html.contains("""data-bs-smooth-scroll="true""""))
    }
}
