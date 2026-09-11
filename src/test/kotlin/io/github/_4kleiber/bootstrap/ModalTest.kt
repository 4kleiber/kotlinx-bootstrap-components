package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertTrue

class ModalTest {
    @Test
    fun `trigger carries data-bs-toggle and target`() {
        val html = createHTML().div { bsModalTrigger(target = "demo") { +"Launch" } }
        assertTrue(html.contains("""data-bs-toggle="modal""""))
        assertTrue(html.contains("""data-bs-target="#demo""""))
    }

    @Test
    fun `modal renders the dialog and content skeleton with size and centered modifiers`() {
        val html = createHTML().div {
            bsModal(id = "demo", labelledBy = "demoLabel", size = ModalSize.Large, centered = true) {
                bsModalHeader { bsModalTitle(id = "demoLabel") { +"Title" } }
                bsModalBody { +"Body" }
                bsModalFooter { +"Footer" }
            }
        }
        assertTrue(html.contains("""class="modal fade""""))
        assertTrue(html.contains("""id="demo""""))
        assertTrue(html.contains("""tabindex="-1""""))
        assertTrue(html.contains("""aria-hidden="true""""))
        assertTrue(html.contains("""aria-labelledby="demoLabel""""))
        assertTrue(html.contains("""class="modal-dialog modal-lg modal-dialog-centered""""))
        assertTrue(html.contains("""class="modal-content""""))
        assertTrue(html.contains("""class="modal-header""""))
        assertTrue(html.contains("""class="modal-title fs-5""""))
        assertTrue(html.contains("""id="demoLabel""""))
        assertTrue(html.contains("""class="modal-body""""))
        assertTrue(html.contains("""class="modal-footer""""))
        assertTrue(html.contains("""data-bs-dismiss="modal""""))
    }

    @Test
    fun `static backdrop sets backdrop and keyboard attributes`() {
        val html = createHTML().div { bsModal(id = "demo", staticBackdrop = true) {} }
        assertTrue(html.contains("""data-bs-backdrop="static""""))
        assertTrue(html.contains("""data-bs-keyboard="false""""))
    }

    @Test
    fun `header without close button omits data-bs-dismiss`() {
        val html = createHTML().div { bsModal(id = "demo") { bsModalHeader(closeButton = false) {} } }
        assertTrue(!html.contains("""data-bs-dismiss="modal""""))
    }
}
