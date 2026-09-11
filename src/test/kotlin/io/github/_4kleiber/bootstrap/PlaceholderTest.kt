package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertTrue

class PlaceholderTest {
    @Test
    fun `placeholder renders as a column-width span`() {
        val html = createHTML().div { bsPlaceholder(width = 7) }
        assertTrue(html.contains("""class="placeholder col-7""""))
    }

    @Test
    fun `sized placeholder adds the size modifier`() {
        val html = createHTML().div { bsPlaceholder(width = 4, size = PlaceholderSize.Large) }
        assertTrue(html.contains("""class="placeholder col-4 placeholder-lg""""))
    }

    @Test
    fun `placeholder animation exposes its raw css class for wrapper elements`() {
        val html = createHTML().div(classes = PlaceholderAnimation.Glow.cssClass) { bsPlaceholder(width = 6) }
        assertTrue(html.contains("""class="placeholder-glow""""))
    }
}
