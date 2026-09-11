package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertTrue

class BreadcrumbTest {
    @Test
    fun `breadcrumb renders nav ol and active current item`() {
        val html = createHTML().div {
            bsBreadcrumb {
                bsBreadcrumbItem { +"Home" }
                bsBreadcrumbItem(active = true) { +"Library" }
            }
        }
        assertTrue(html.contains("""aria-label="breadcrumb""""))
        assertTrue(html.contains("""class="breadcrumb""""))
        assertTrue(html.contains("""class="breadcrumb-item active""""))
        assertTrue(html.contains("""aria-current="page""""))
    }
}
