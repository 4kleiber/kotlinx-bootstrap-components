package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertTrue

class DropdownTest {
    @Test
    fun `dropdown wrapper and toggle button compose correctly`() {
        val html = createHTML().div {
            bsDropdown {
                bsDropdownToggleButton { +"Menu" }
                bsDropdownMenu {
                    bsDropdownItem { +"Action" }
                }
            }
        }
        assertTrue(html.contains("""class="dropdown""""))
        assertTrue(html.contains("""class="btn btn-secondary dropdown-toggle""""))
        assertTrue(html.contains("""data-bs-toggle="dropdown""""))
        assertTrue(html.contains("""aria-expanded="false""""))
        assertTrue(html.contains("""class="dropdown-menu""""))
        assertTrue(html.contains("""class="dropdown-item""""))
    }

    @Test
    fun `dropup direction and dark end-aligned menu compose correctly`() {
        val html = createHTML().div {
            bsDropdown(direction = DropdownDirection.Up) {
                bsDropdownMenu(dark = true, alignEnd = true) {}
            }
        }
        assertTrue(html.contains("""class="dropup""""))
        assertTrue(html.contains("""class="dropdown-menu dropdown-menu-dark dropdown-menu-end""""))
    }

    @Test
    fun `active and disabled items set the right aria attributes`() {
        val html = createHTML().div {
            bsDropdown {
                bsDropdownMenu {
                    bsDropdownItem(active = true) { +"Active" }
                    bsDropdownItem(disabled = true) { +"Disabled" }
                }
            }
        }
        assertTrue(html.contains("""aria-current="true""""))
        assertTrue(html.contains("""aria-disabled="true""""))
        assertTrue(html.contains("""tabindex="-1""""))
    }

    @Test
    fun `header and divider render as list items`() {
        val html = createHTML().div {
            bsDropdown {
                bsDropdownMenu {
                    bsDropdownHeader { +"Header" }
                    bsDropdownDivider()
                }
            }
        }
        assertTrue(html.contains("""class="dropdown-header""""))
        assertTrue(html.contains("""class="dropdown-divider""""))
    }
}
