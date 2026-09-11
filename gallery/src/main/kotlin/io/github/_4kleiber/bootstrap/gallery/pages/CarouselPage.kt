package io.github._4kleiber.bootstrap.gallery.pages

import io.github._4kleiber.bootstrap.CarouselRide
import io.github._4kleiber.bootstrap.bsCarousel
import io.github._4kleiber.bootstrap.bsCarouselCaption
import io.github._4kleiber.bootstrap.bsCarouselControlNext
import io.github._4kleiber.bootstrap.bsCarouselControlPrev
import io.github._4kleiber.bootstrap.bsCarouselIndicator
import io.github._4kleiber.bootstrap.bsCarouselIndicators
import io.github._4kleiber.bootstrap.bsCarouselInner
import io.github._4kleiber.bootstrap.bsCarouselItem
import io.github._4kleiber.bootstrap.gallery.example
import io.github._4kleiber.bootstrap.gallery.galleryPage
import io.github._4kleiber.bootstrap.gallery.intro
import kotlinx.html.FlowContent
import kotlinx.html.HTML
import kotlinx.html.div
import kotlinx.html.h5
import kotlinx.html.p

private fun FlowContent.slideBody(color: String, label: String) {
    div(classes = "text-center py-5 text-white") {
        attributes["style"] = "background-color: $color;"
        p { +label }
    }
}

internal fun HTML.carouselPage() {
    galleryPage(pageTitle = "Carousel", currentPath = "/components/carousel") {
        intro(
            "https://getbootstrap.com/docs/5.3/components/carousel/ — with " +
                "ride = CarouselRide.Carousel this works from markup alone (Bootstrap auto-" +
                "initializes [data-bs-ride=\"carousel\"] elements on page load, no init script " +
                "needed, unlike Tooltips/Popovers); without it, the controls still need Bootstrap's " +
                "JS bundle loaded (already true of this gallery) plus manual initialization.",
        )

        example(
            "Basic carousel with controls",
            """
            bsCarousel(id = "demo", ride = CarouselRide.Carousel) {
                bsCarouselInner {
                    bsCarouselItem(active = true) { /* slide 1 */ }
                    bsCarouselItem { /* slide 2 */ }
                    bsCarouselItem { /* slide 3 */ }
                }
                bsCarouselControlPrev(target = "demo")
                bsCarouselControlNext(target = "demo")
            }
            """.trimIndent(),
        ) {
            bsCarousel(id = "carousel-basic", ride = CarouselRide.Carousel) {
                bsCarouselInner {
                    bsCarouselItem(active = true) { slideBody("#555", "First slide") }
                    bsCarouselItem { slideBody("#444", "Second slide") }
                    bsCarouselItem { slideBody("#333", "Third slide") }
                }
                bsCarouselControlPrev(target = "carousel-basic")
                bsCarouselControlNext(target = "carousel-basic")
            }
        }

        example(
            "With indicators and captions",
            """
            bsCarousel(id = "demo", ride = CarouselRide.Carousel) {
                bsCarouselIndicators {
                    bsCarouselIndicator(target = "demo", index = 0, active = true)
                    bsCarouselIndicator(target = "demo", index = 1)
                }
                bsCarouselInner {
                    bsCarouselItem(active = true) {
                        bsCarouselCaption { h5 { +"First slide label" } }
                    }
                }
                bsCarouselControlPrev(target = "demo")
                bsCarouselControlNext(target = "demo")
            }
            """.trimIndent(),
        ) {
            bsCarousel(id = "carousel-indicators", ride = CarouselRide.Carousel) {
                bsCarouselIndicators {
                    bsCarouselIndicator(target = "carousel-indicators", index = 0, active = true)
                    bsCarouselIndicator(target = "carousel-indicators", index = 1)
                    bsCarouselIndicator(target = "carousel-indicators", index = 2)
                }
                bsCarouselInner {
                    bsCarouselItem(active = true) {
                        slideBody("#555", "First slide")
                        bsCarouselCaption { h5 { +"First slide label" } }
                    }
                    bsCarouselItem {
                        slideBody("#444", "Second slide")
                        bsCarouselCaption { h5 { +"Second slide label" } }
                    }
                    bsCarouselItem {
                        slideBody("#333", "Third slide")
                        bsCarouselCaption { h5 { +"Third slide label" } }
                    }
                }
                bsCarouselControlPrev(target = "carousel-indicators")
                bsCarouselControlNext(target = "carousel-indicators")
            }
        }

        example(
            "Crossfade transition",
            """bsCarousel(id = "demo", crossfade = true) { ... }""",
        ) {
            bsCarousel(id = "carousel-fade", ride = CarouselRide.Carousel, crossfade = true) {
                bsCarouselInner {
                    bsCarouselItem(active = true) { slideBody("#555", "First slide") }
                    bsCarouselItem { slideBody("#444", "Second slide") }
                }
                bsCarouselControlPrev(target = "carousel-fade")
                bsCarouselControlNext(target = "carousel-fade")
            }
        }
    }
}
