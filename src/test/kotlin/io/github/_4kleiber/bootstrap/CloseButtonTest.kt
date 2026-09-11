package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertTrue

class CloseButtonTest {
    @Test
    fun `close button carries default aria-label`() {
        val html = createHTML().div { bsCloseButton() }
        assertTrue(html.contains("""class="btn-close""""))
        assertTrue(html.contains("""aria-label="Close""""))
    }

    @Test
    fun `dismiss target sets data-bs-dismiss`() {
        val html = createHTML().div { bsCloseButton(dismissTarget = "alert") }
        assertTrue(html.contains("""data-bs-dismiss="alert""""))
    }
}
