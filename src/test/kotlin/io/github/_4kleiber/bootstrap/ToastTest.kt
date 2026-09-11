package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertTrue

class ToastTest {
    @Test
    fun `toast container and toast render role and aria attributes`() {
        val html = createHTML().div {
            bsToastContainer {
                bsToast(show = true) {
                    bsToastHeader { +"Header" }
                    bsToastBody { +"Body" }
                }
            }
        }
        assertTrue(html.contains("""class="toast-container""""))
        assertTrue(html.contains("""class="toast show""""))
        assertTrue(html.contains("""role="alert""""))
        assertTrue(html.contains("""aria-live="assertive""""))
        assertTrue(html.contains("""aria-atomic="true""""))
        assertTrue(html.contains("""class="toast-header""""))
        assertTrue(html.contains("""data-bs-dismiss="toast""""))
        assertTrue(html.contains("""class="toast-body""""))
    }

    @Test
    fun `autohide false and a delay set the expected data attributes`() {
        val html = createHTML().div { bsToast(autohide = false, delayMillis = 5000) {} }
        assertTrue(html.contains("""data-bs-autohide="false""""))
        assertTrue(html.contains("""data-bs-delay="5000""""))
    }

    @Test
    fun `header without close button omits data-bs-dismiss`() {
        val html = createHTML().div { bsToast { bsToastHeader(closeButton = false) {} } }
        assertTrue(!html.contains("""data-bs-dismiss="toast""""))
    }
}
