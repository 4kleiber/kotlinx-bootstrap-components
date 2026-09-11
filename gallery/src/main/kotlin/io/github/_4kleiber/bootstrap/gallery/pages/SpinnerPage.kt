package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.SpinnerType
import io.github._4kleiber.bootstrap.bsSpinner
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML

internal fun HTML.spinnerPage() {
    galleryPage(pageTitle = "Spinners", currentPath = "/components/spinner") {
        intro("https://getbootstrap.com/docs/5.3/components/spinners/")

        example("Border spinner", "bsSpinner()") {
            bsSpinner()
        }

        example("Growing spinner", "bsSpinner(type = SpinnerType.Grow)") {
            bsSpinner(type = SpinnerType.Grow)
        }
    }
}
