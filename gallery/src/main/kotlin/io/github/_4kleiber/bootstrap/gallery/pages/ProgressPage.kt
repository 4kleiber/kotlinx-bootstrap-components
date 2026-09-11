package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.bsProgress
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML

internal fun HTML.progressPage() {
    galleryPage(pageTitle = "Progress", currentPath = "/components/progress") {
        intro("https://getbootstrap.com/docs/5.3/components/progress/")

        example("Basic", "bsProgress(value = 25)") {
            bsProgress(value = 25)
        }

        example("Striped and animated", "bsProgress(value = 75, animated = true)") {
            bsProgress(value = 75, animated = true)
        }
    }
}
