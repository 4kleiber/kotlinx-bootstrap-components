package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.bsTabContent
import io.github._4kleiber.bootstrap.bsTabList
import io.github._4kleiber.bootstrap.bsTabListItem
import io.github._4kleiber.bootstrap.bsTabPane
import io.github._4kleiber.bootstrap.bsTabToggle
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML

internal fun HTML.tabPage() {
    galleryPage(pageTitle = "Tabs", currentPath = "/components/tab") {
        intro("https://getbootstrap.com/docs/5.3/components/navs-tabs/#javascript-behavior — requires Bootstrap's JS bundle to switch panes.")

        example(
            "Tabs wired to content panes",
            """
            bsTabList(id = "myTab") {
                bsTabListItem { bsTabToggle(target = "home", id = "home-tab", active = true) { +"Home" } }
                bsTabListItem { bsTabToggle(target = "profile", id = "profile-tab") { +"Profile" } }
                bsTabListItem { bsTabToggle(target = "contact", id = "contact-tab") { +"Contact" } }
            }
            bsTabContent {
                bsTabPane(id = "home", labelledBy = "home-tab", active = true) { +"Home content." }
                bsTabPane(id = "profile", labelledBy = "profile-tab") { +"Profile content." }
                bsTabPane(id = "contact", labelledBy = "contact-tab") { +"Contact content." }
            }
            """.trimIndent(),
        ) {
            bsTabList(id = "myTab") {
                bsTabListItem { bsTabToggle(target = "home", id = "home-tab", active = true) { +"Home" } }
                bsTabListItem { bsTabToggle(target = "profile", id = "profile-tab") { +"Profile" } }
                bsTabListItem { bsTabToggle(target = "contact", id = "contact-tab") { +"Contact" } }
            }
            bsTabContent {
                bsTabPane(id = "home", labelledBy = "home-tab", active = true) { +"Home content." }
                bsTabPane(id = "profile", labelledBy = "profile-tab") { +"Profile content." }
                bsTabPane(id = "contact", labelledBy = "contact-tab") { +"Contact content." }
            }
        }
    }
}
