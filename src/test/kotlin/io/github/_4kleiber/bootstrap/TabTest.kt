package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertTrue

class TabTest {
    @Test
    fun `tab list and toggle carry the expected data and aria attributes`() {
        val html = createHTML().div {
            bsTabList {
                bsTabListItem {
                    bsTabToggle(target = "home", id = "home-tab", active = true) { +"Home" }
                }
            }
        }
        assertTrue(html.contains("""role="tablist""""))
        assertTrue(html.contains("""role="presentation""""))
        assertTrue(html.contains("""id="home-tab""""))
        assertTrue(html.contains("""data-bs-toggle="tab""""))
        assertTrue(html.contains("""data-bs-target="#home""""))
        assertTrue(html.contains("""role="tab""""))
        assertTrue(html.contains("""aria-controls="home""""))
        assertTrue(html.contains("""aria-selected="true""""))
        assertTrue(html.contains("""class="nav-link active""""))
    }

    @Test
    fun `tab pane carries id role and labelledby, active pane shows`() {
        val html = createHTML().div {
            bsTabContent {
                bsTabPane(id = "home", labelledBy = "home-tab", active = true) { +"Home content" }
                bsTabPane(id = "profile", labelledBy = "profile-tab") { +"Profile content" }
            }
        }
        assertTrue(html.contains("""class="tab-content""""))
        assertTrue(html.contains("""class="tab-pane fade show active""""))
        assertTrue(html.contains("""id="home""""))
        assertTrue(html.contains("""role="tabpanel""""))
        assertTrue(html.contains("""aria-labelledby="home-tab""""))
        assertTrue(html.contains("""class="tab-pane fade""""))
    }

    @Test
    fun `disabled toggle sets the disabled attribute`() {
        val html = createHTML().div { bsTabList { bsTabListItem { bsTabToggle(target = "x", disabled = true) { +"X" } } } }
        assertTrue(html.contains("disabled"))
    }
}
