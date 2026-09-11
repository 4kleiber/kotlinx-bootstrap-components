package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.ButtonVariant
import io.github._4kleiber.bootstrap.TooltipPlacement
import io.github._4kleiber.bootstrap.bsButton
import io.github._4kleiber.bootstrap.bsTooltip
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML
import kotlinx.html.a
import kotlinx.html.script
import kotlinx.html.unsafe

internal fun HTML.tooltipPage() {
    galleryPage(pageTitle = "Tooltips", currentPath = "/components/tooltip") {
        intro(
            "https://getbootstrap.com/docs/5.3/components/tooltips/ — unlike Collapse, Modal, " +
                "or Dropdown, Bootstrap does NOT auto-initialize tooltips from data attributes " +
                "alone. This page adds a small inline script (see the page source) that calls " +
                "new bootstrap.Tooltip(el) for every [data-bs-toggle=\"tooltip\"] element — " +
                "that's a gallery-only concern, not something this library does for you.",
        )

        example(
            "Directions",
            """
            bsButton(variant = ButtonVariant.Secondary) {
                bsTooltip(title = "Tooltip on top", placement = TooltipPlacement.Top)
                +"Tooltip on top"
            }
            """.trimIndent(),
        ) {
            bsButton(variant = ButtonVariant.Secondary, classes = "me-2") {
                bsTooltip(title = "Tooltip on top", placement = TooltipPlacement.Top)
                +"Tooltip on top"
            }
            bsButton(variant = ButtonVariant.Secondary, classes = "me-2") {
                bsTooltip(title = "Tooltip on right", placement = TooltipPlacement.Right)
                +"Tooltip on right"
            }
            bsButton(variant = ButtonVariant.Secondary, classes = "me-2") {
                bsTooltip(title = "Tooltip on bottom", placement = TooltipPlacement.Bottom)
                +"Tooltip on bottom"
            }
            bsButton(variant = ButtonVariant.Secondary) {
                bsTooltip(title = "Tooltip on left", placement = TooltipPlacement.Left)
                +"Tooltip on left"
            }
        }

        example(
            "Tooltip on a link, default (hover/focus) trigger",
            """a(href = "#") { bsTooltip(title = "Some tooltip text!"); +"Hover over me" }""",
        ) {
            a(href = "#") {
                bsTooltip(title = "Some tooltip text!")
                +"Hover over me"
            }
        }

        example(
            "HTML content",
            """bsButton { bsTooltip(title = "&lt;em&gt;Tooltip&lt;/em&gt; with &lt;b&gt;HTML&lt;/b&gt;", html = true); +"..." }""",
        ) {
            bsButton(variant = ButtonVariant.Secondary) {
                bsTooltip(title = "<em>Tooltip</em> with <b>HTML</b>", html = true)
                +"Tooltip with HTML"
            }
        }

        script {
            // Deferred until DOMContentLoaded: this script tag is placed inside <main>, before
            // the CDN <script src="bootstrap.bundle.min.js"> Layout.kt appends at the very end of
            // <body> — by the time DOMContentLoaded fires, every synchronous script (that one
            // included) has already run, so `bootstrap` is guaranteed to be defined here.
            unsafe {
                +"""
                document.addEventListener('DOMContentLoaded', () => {
                  document.querySelectorAll('[data-bs-toggle="tooltip"]').forEach(
                    (el) => new bootstrap.Tooltip(el)
                  )
                })
                """.trimIndent()
            }
        }
    }
}
