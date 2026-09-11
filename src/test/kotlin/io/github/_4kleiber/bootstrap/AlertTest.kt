package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertTrue

class AlertTest {
    @Test
    fun `default alert carries role and primary classes`() {
        val html = createHTML().div { bsAlert { +"Heads up!" } }
        assertTrue(html.contains("""class="alert alert-primary""""))
        assertTrue(html.contains("""role="alert""""))
    }

    @Test
    fun `dismissible alert adds fade-show classes and a close button`() {
        val html = createHTML().div { bsAlert(variant = AlertVariant.Warning, dismissible = true) { +"Careful!" } }
        assertTrue(html.contains("""class="alert alert-warning alert-dismissible fade show""""))
        assertTrue(html.contains("""data-bs-dismiss="alert""""))
    }
}
