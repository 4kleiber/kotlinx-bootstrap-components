package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.ButtonVariant
import io.github._4kleiber.bootstrap.TooltipPlacement
import io.github._4kleiber.bootstrap.TooltipTrigger
import io.github._4kleiber.bootstrap.bsButton
import io.github._4kleiber.bootstrap.bsPopover
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML
import kotlinx.html.a
import kotlinx.html.script
import kotlinx.html.unsafe

internal fun HTML.popoverPage() {
    galleryPage(pageTitle = "Popovers", currentPath = "/components/popover") {
        intro(
            "https://getbootstrap.com/docs/5.3/components/popovers/ — like tooltips, popovers " +
                "are NOT auto-initialized from data attributes alone. This page adds a small " +
                "inline script (see the page source) that calls new bootstrap.Popover(el) for " +
                "every [data-bs-toggle=\"popover\"] element.",
        )

        example(
            "Click to toggle",
            """
            bsButton(variant = ButtonVariant.Secondary) {
                bsPopover(title = "Popover title", content = "And here's some amazing content.")
                +"Click to toggle popover"
            }
            """.trimIndent(),
        ) {
            bsButton(variant = ButtonVariant.Secondary) {
                bsPopover(title = "Popover title", content = "And here's some amazing content.")
                +"Click to toggle popover"
            }
        }

        example(
            "Directions",
            """bsButton { bsPopover(content = "...", placement = TooltipPlacement.Top); ... }""",
        ) {
            bsButton(variant = ButtonVariant.Secondary, classes = "me-2") {
                bsPopover(title = "Top", content = "Popover on top", placement = TooltipPlacement.Top)
                +"Popover on top"
            }
            bsButton(variant = ButtonVariant.Secondary, classes = "me-2") {
                bsPopover(title = "Right", content = "Popover on right", placement = TooltipPlacement.Right)
                +"Popover on right"
            }
            bsButton(variant = ButtonVariant.Secondary, classes = "me-2") {
                bsPopover(title = "Bottom", content = "Popover on bottom", placement = TooltipPlacement.Bottom)
                +"Popover on bottom"
            }
            bsButton(variant = ButtonVariant.Secondary) {
                bsPopover(title = "Left", content = "Popover on left", placement = TooltipPlacement.Left)
                +"Popover on left"
            }
        }

        example(
            "Dismiss on next click (needs a link with tabindex, per Bootstrap's own docs)",
            """
            a(href = "#") {
                attributes["tabindex"] = "0"
                bsPopover(title = "Dismissible popover", content = "...", trigger = setOf(TooltipTrigger.Focus))
                +"Dismissible popover"
            }
            """.trimIndent(),
        ) {
            a(href = "#", classes = "btn btn-secondary") {
                attributes["tabindex"] = "0"
                bsPopover(
                    title = "Dismissible popover",
                    content = "Click anywhere else to dismiss this popover.",
                    trigger = setOf(TooltipTrigger.Focus),
                )
                +"Dismissible popover"
            }
        }

        script {
            unsafe {
                +"""
                document.querySelectorAll('[data-bs-toggle="popover"]').forEach(
                  (el) => new bootstrap.Popover(el)
                )
                """.trimIndent()
            }
        }
    }
}
