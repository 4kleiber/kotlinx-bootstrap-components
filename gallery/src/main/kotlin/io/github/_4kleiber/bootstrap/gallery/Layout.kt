package io.github._4kleiber.bootstrap.gallery

import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.HTML
import kotlinx.html.a
import kotlinx.html.body
import kotlinx.html.code
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.h6
import kotlinx.html.head
import kotlinx.html.link
import kotlinx.html.main
import kotlinx.html.meta
import kotlinx.html.nav
import kotlinx.html.p
import kotlinx.html.pre
import kotlinx.html.script
import kotlinx.html.title

/** One entry in the gallery's sidebar navigation. */
internal data class ComponentLink(val path: String, val label: String)

/**
 * Every page the gallery serves, grouped exactly like section 4 of the
 * project plan (Phase 1 = markup/CSS-only components), mirroring the
 * library's `src/main/kotlin/.../bootstrap` component files 1:1.
 */
internal val galleryComponents: List<ComponentLink> = listOf(
    ComponentLink("/components/grid", "Grid"),
    ComponentLink("/components/button", "Buttons"),
    ComponentLink("/components/button-group", "Button group"),
    ComponentLink("/components/close-button", "Close button"),
    ComponentLink("/components/alert", "Alerts"),
    ComponentLink("/components/badge", "Badge"),
    ComponentLink("/components/card", "Card"),
    ComponentLink("/components/list-group", "List group"),
    ComponentLink("/components/breadcrumb", "Breadcrumb"),
    ComponentLink("/components/pagination", "Pagination"),
    ComponentLink("/components/progress", "Progress"),
    ComponentLink("/components/spinner", "Spinners"),
    ComponentLink("/components/placeholder", "Placeholders"),
)

/**
 * The exact Bootstrap release this gallery loads from jsDelivr's CDN, for the
 * visual rendering only — it has no effect on what class names the library
 * itself emits. **This is the one place to bump when the project moves to a
 * newer Bootstrap release**; see the "Bootstrap version" section of the root
 * README for the full picture (what targeting a release means here, and
 * where else to check when bumping it).
 */
private const val BOOTSTRAP_VERSION = "5.3.3"

/**
 * Shared page shell: pulls Bootstrap's own CSS+JS from its official CDN (this
 * is fine for a local dev/documentation tool even though the library itself
 * never ships JavaScript) and renders a sidebar listing every component.
 */
internal fun HTML.galleryPage(pageTitle: String, currentPath: String, content: FlowContent.() -> Unit) {
    head {
        meta(charset = "utf-8")
        title { +"$pageTitle · kotlinx-bootstrap-components" }
        link(
            rel = "stylesheet",
            href = "https://cdn.jsdelivr.net/npm/bootstrap@$BOOTSTRAP_VERSION/dist/css/bootstrap.min.css",
        )
    }
    body {
        div(classes = "d-flex") {
            nav(classes = "flex-shrink-0 p-3 border-end") {
                attributes["style"] = "width: 240px; min-height: 100vh;"
                h6(classes = "text-uppercase text-muted") { +"kotlinx-bootstrap-components" }
                a(href = "/", classes = "d-block mb-2 " + if (currentPath == "/") "fw-bold" else "") { +"Overview" }
                h6(classes = "text-uppercase text-muted mt-3") { +"Components" }
                galleryComponents.forEach { link ->
                    a(
                        href = link.path,
                        classes = "d-block " + if (currentPath == link.path) "fw-bold" else "",
                    ) { +link.label }
                }
            }
            main {
                attributes["style"] = "flex: 1 1 auto;"
                div(classes = "container py-4") {
                    h1 { +pageTitle }
                    content()
                }
            }
        }
        script(src = "https://cdn.jsdelivr.net/npm/bootstrap@$BOOTSTRAP_VERSION/dist/js/bootstrap.bundle.min.js") {}
    }
}

/**
 * One documented example: a short caption, the actual rendered component
 * (so it visually matches what a real consumer gets), and the literal
 * Kotlin source of the call that produced it.
 */
internal fun FlowContent.example(caption: String, snippet: String, render: DIV.() -> Unit) {
    div(classes = "mb-4") {
        h6(classes = "text-muted") { +caption }
        div(classes = "p-3 border rounded mb-2") { render() }
        pre(classes = "bg-body-tertiary p-2 rounded small") { code { +snippet } }
    }
}

/** A short paragraph of prose documentation at the top of a component page. */
internal fun FlowContent.intro(text: String) {
    p(classes = "text-muted") { +text }
}
