package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertTrue

class PaginationTest {
    @Test
    fun `pagination renders nav ul and page items`() {
        val html = createHTML().div {
            bsPagination {
                bsPageItem(active = true) { +"1" }
                bsPageItem(href = "?page=2") { +"2" }
                bsPageItem(disabled = true) { +"3" }
            }
        }
        assertTrue(html.contains("""aria-label="Page navigation""""))
        assertTrue(html.contains("""class="pagination""""))
        assertTrue(html.contains("""class="page-item active""""))
        assertTrue(html.contains("""class="page-item disabled""""))
        assertTrue(html.contains("""class="page-link""""))
    }
}
