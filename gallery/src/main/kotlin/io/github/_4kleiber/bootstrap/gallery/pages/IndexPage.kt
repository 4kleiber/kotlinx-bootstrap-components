package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.gallery.galleryComponents
import io.github._4kleiber.bootstrap.gallery.galleryPage
import kotlinx.html.HTML
import kotlinx.html.a
import kotlinx.html.code
import kotlinx.html.h2
import kotlinx.html.li
import kotlinx.html.p
import kotlinx.html.pre
import kotlinx.html.ul

internal fun HTML.indexPage() {
    galleryPage(pageTitle = "kotlinx-bootstrap-components", currentPath = "/") {
        p {
            +"Kotlin extension functions that render Bootstrap 5.3 markup on top of "
            +"kotlinx.html. Every function is prefixed "
            code { +"bs" }
            +" (e.g. "
            code { +"bsButton" }
            +") to stay clear of kotlinx.html's own tag-builder functions of the same name."
        }

        h2 { +"Browse components" }
        ul {
            galleryComponents.forEach { link ->
                li { a(href = link.path) { +link.label } }
            }
        }

        h2 { +"Using this library" }
        p {
            +"This library is not published to a binary registry. Consumers pin a released "
            +"git tag and build the library themselves, either as a git submodule + Gradle "
            +"composite build, or via Gradle's native Git source dependency. See the "
            code { +"README" }
            +" for both."
        }
        pre { code { +"includeBuild(\"libs/kotlinx-bootstrap-components\")" } }

        h2 { +"JavaScript-dependent components" }
        p {
            +"This library only emits HTML — it never ships or executes any JavaScript. "
            +"Components like Collapse, Dropdowns, Modal and Tooltips render correct "
            code { +"data-bs-*" }
            +" / ARIA markup, but the interactive behavior only works once your page also "
            +"loads Bootstrap's own CSS+JS bundle, exactly as this gallery does."
        }
    }
}
