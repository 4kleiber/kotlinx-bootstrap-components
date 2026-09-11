package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertTrue

class ProgressTest {
    @Test
    fun `progress renders aria attributes and bar width`() {
        val html = createHTML().div { bsProgress(value = 40) }
        assertTrue(html.contains("""class="progress""""))
        assertTrue(html.contains("""aria-valuenow="40""""))
        assertTrue(html.contains("""aria-valuemin="0""""))
        assertTrue(html.contains("""aria-valuemax="100""""))
        assertTrue(html.contains("width: 40%"))
    }

    @Test
    fun `striped animated progress adds both modifier classes`() {
        val html = createHTML().div { bsProgress(value = 75, animated = true) }
        assertTrue(html.contains("progress-bar-striped"))
        assertTrue(html.contains("progress-bar-animated"))
    }
}
