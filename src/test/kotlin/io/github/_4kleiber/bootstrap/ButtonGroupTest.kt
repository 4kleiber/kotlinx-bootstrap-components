package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertTrue

class ButtonGroupTest {
    @Test
    fun `button group renders role and aria-label`() {
        val html = createHTML().div {
            bsButtonGroup(ariaLabel = "Actions") {
                bsButton { +"A" }
                bsButton { +"B" }
            }
        }
        assertTrue(html.contains("""class="btn-group""""))
        assertTrue(html.contains("""role="group""""))
        assertTrue(html.contains("""aria-label="Actions""""))
    }

    @Test
    fun `vertical and sized group compose correctly`() {
        val html = createHTML().div { bsButtonGroup(size = ButtonSize.Large, vertical = true) {} }
        assertTrue(html.contains("""class="btn-group-vertical btn-group-lg""""))
    }
}
