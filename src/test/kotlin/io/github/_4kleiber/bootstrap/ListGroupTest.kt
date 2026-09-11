package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertTrue

class ListGroupTest {
    @Test
    fun `list group renders items with active and variant state`() {
        val html = createHTML().div {
            bsListGroup(flush = true) {
                bsListGroupItem(active = true) { +"One" }
                bsListGroupItem(variant = ListGroupItemVariant.Danger) { +"Two" }
                bsListGroupItem(disabled = true) { +"Three" }
            }
        }
        assertTrue(html.contains("""class="list-group list-group-flush""""))
        assertTrue(html.contains("""class="list-group-item active""""))
        assertTrue(html.contains("""aria-current="true""""))
        assertTrue(html.contains("""class="list-group-item list-group-item-danger""""))
        assertTrue(html.contains("""class="list-group-item disabled""""))
    }
}
