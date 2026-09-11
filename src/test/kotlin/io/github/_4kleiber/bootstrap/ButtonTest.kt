package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertTrue

class ButtonTest {
    @Test
    fun `default button carries btn and primary classes`() {
        val html = createHTML().div { bsButton { +"Click" } }
        assertTrue(html.contains("""class="btn btn-primary""""))
        assertTrue(html.contains(">Click<"))
    }

    @Test
    fun `outline variant and size compose correctly`() {
        val html = createHTML().div {
            bsButton(variant = ButtonVariant.OutlineDanger, size = ButtonSize.Small) { +"Delete" }
        }
        assertTrue(html.contains("""class="btn btn-outline-danger btn-sm""""))
    }

    @Test
    fun `disabled button sets the disabled attribute`() {
        val html = createHTML().div { bsButton(disabled = true) { +"Wait" } }
        assertTrue(html.contains("disabled"))
    }
}
