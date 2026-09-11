package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.DropdownDirection
import io.github._4kleiber.bootstrap.bsDropdown
import io.github._4kleiber.bootstrap.bsDropdownDivider
import io.github._4kleiber.bootstrap.bsDropdownHeader
import io.github._4kleiber.bootstrap.bsDropdownItem
import io.github._4kleiber.bootstrap.bsDropdownMenu
import io.github._4kleiber.bootstrap.bsDropdownToggleButton
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML

internal fun HTML.dropdownPage() {
    galleryPage(pageTitle = "Dropdowns", currentPath = "/components/dropdown") {
        intro("https://getbootstrap.com/docs/5.3/components/dropdowns/ — requires Bootstrap's JS bundle to open.")

        example(
            "Basic dropdown with a header and divider",
            """
            bsDropdown {
                bsDropdownToggleButton { +"Dropdown button" }
                bsDropdownMenu {
                    bsDropdownHeader { +"Header" }
                    bsDropdownItem { +"Action" }
                    bsDropdownItem { +"Another action" }
                    bsDropdownDivider()
                    bsDropdownItem(disabled = true) { +"Disabled" }
                }
            }
            """.trimIndent(),
        ) {
            bsDropdown {
                bsDropdownToggleButton { +"Dropdown button" }
                bsDropdownMenu {
                    bsDropdownHeader { +"Header" }
                    bsDropdownItem { +"Action" }
                    bsDropdownItem { +"Another action" }
                    bsDropdownDivider()
                    bsDropdownItem(disabled = true) { +"Disabled" }
                }
            }
        }

        example(
            "Drop end direction",
            """bsDropdown(direction = DropdownDirection.End) { ... }""",
        ) {
            bsDropdown(direction = DropdownDirection.End) {
                bsDropdownToggleButton { +"Drop end" }
                bsDropdownMenu {
                    bsDropdownItem { +"Action" }
                }
            }
        }

        example(
            "Dark, end-aligned menu",
            """bsDropdownMenu(dark = true, alignEnd = true) { ... }""",
        ) {
            bsDropdown {
                bsDropdownToggleButton { +"Dark menu" }
                bsDropdownMenu(dark = true, alignEnd = true) {
                    bsDropdownItem { +"Action" }
                    bsDropdownItem { +"Another action" }
                }
            }
        }
    }
}
