package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.bsCloseButton
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.HTML

internal fun HTML.closeButtonPage() {
    galleryPage(pageTitle = "Close button", currentPath = "/components/close-button") {
        intro("https://getbootstrap.com/docs/5.3/components/close-button/ — used inside Alerts, Modals and Toasts.")

        example("Default", "bsCloseButton()") {
            bsCloseButton()
        }
    }
}
