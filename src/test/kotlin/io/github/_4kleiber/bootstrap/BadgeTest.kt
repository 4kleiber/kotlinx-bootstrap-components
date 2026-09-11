package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertTrue

class BadgeTest {
    @Test
    fun `default badge carries primary background classes`() {
        val html = createHTML().div { bsBadge { +"New" } }
        assertTrue(html.contains("""class="badge text-bg-primary""""))
    }

    @Test
    fun `pill badge adds rounded-pill`() {
        val html = createHTML().div { bsBadge(variant = BadgeVariant.Success, pill = true) { +"4" } }
        assertTrue(html.contains("""class="badge text-bg-success rounded-pill""""))
    }
}
