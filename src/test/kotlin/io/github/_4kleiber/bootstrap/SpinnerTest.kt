package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertTrue

class SpinnerTest {
    @Test
    fun `default spinner is a border spinner with a status role`() {
        val html = createHTML().div { bsSpinner() }
        assertTrue(html.contains("""class="spinner-border""""))
        assertTrue(html.contains("""role="status""""))
        assertTrue(html.contains("""class="visually-hidden""""))
    }

    @Test
    fun `small grow spinner with variant composes correctly`() {
        val html = createHTML().div { bsSpinner(type = SpinnerType.Grow, variant = SpinnerVariant.Danger, small = true) }
        assertTrue(html.contains("""class="spinner-grow text-danger spinner-grow-sm""""))
    }
}
