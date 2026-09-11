package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.BadgeVariant
import io.github._4kleiber.bootstrap.bsBadge
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML

internal fun HTML.badgePage() {
    galleryPage(pageTitle = "Badge", currentPath = "/components/badge") {
        intro("https://getbootstrap.com/docs/5.3/components/badge/")

        example("Background colors", """bsBadge(variant = BadgeVariant.Danger) { +"Danger" }""") {
            BadgeVariant.entries.forEach { variant ->
                bsBadge(variant = variant, classes = "me-2") { +variant.name }
            }
        }

        example("Pill badges", """bsBadge(pill = true) { +"New" }""") {
            bsBadge(pill = true) { +"New" }
        }
    }
}
