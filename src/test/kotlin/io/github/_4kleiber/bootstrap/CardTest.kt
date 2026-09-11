package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertTrue

class CardTest {
    @Test
    fun `card composes header body title text and footer`() {
        val html = createHTML().div {
            bsCard {
                bsCardHeader { +"Featured" }
                bsCardImgTop(src = "/img.png", alt = "cap")
                bsCardBody {
                    bsCardTitle { +"Title" }
                    bsCardText { +"Body copy." }
                }
                bsCardFooter { +"2 days ago" }
            }
        }
        assertTrue(html.contains("""class="card""""))
        assertTrue(html.contains("""class="card-header""""))
        assertTrue(html.contains("""class="card-img-top""""))
        assertTrue(html.contains("""class="card-body""""))
        assertTrue(html.contains("""class="card-title""""))
        assertTrue(html.contains("""class="card-text""""))
        assertTrue(html.contains("""class="card-footer""""))
    }
}
