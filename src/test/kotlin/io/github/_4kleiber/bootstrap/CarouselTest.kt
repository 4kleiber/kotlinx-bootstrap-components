package io.github._4kleiber.bootstrap

import kotlinx.html.div
import kotlinx.html.stream.createHTML
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CarouselTest {
    @Test
    fun `carousel without ride renders id and base classes but no data-bs-ride`() {
        val html = createHTML().div { bsCarousel(id = "demo") {} }
        assertTrue(html.contains("""id="demo""""))
        assertTrue(html.contains("""class="carousel slide""""))
        assertFalse(html.contains("data-bs-ride"))
    }

    @Test
    fun `ride carousel sets data-bs-ride to carousel`() {
        val html = createHTML().div { bsCarousel(id = "demo", ride = CarouselRide.Carousel) {} }
        assertTrue(html.contains("""data-bs-ride="carousel""""))
    }

    @Test
    fun `ride on-interaction sets data-bs-ride to true`() {
        val html = createHTML().div { bsCarousel(id = "demo", ride = CarouselRide.OnInteraction) {} }
        assertTrue(html.contains("""data-bs-ride="true""""))
    }

    @Test
    fun `crossfade adds the carousel-fade class`() {
        val html = createHTML().div { bsCarousel(id = "demo", crossfade = true) {} }
        assertTrue(html.contains("""class="carousel slide carousel-fade""""))
    }

    @Test
    fun `active indicator carries aria-current and default aria-label`() {
        val html = createHTML().div { bsCarouselIndicator(target = "demo", index = 0, active = true) }
        assertTrue(html.contains("""data-bs-target="#demo""""))
        assertTrue(html.contains("""data-bs-slide-to="0""""))
        assertTrue(html.contains("""class="active""""))
        assertTrue(html.contains("""aria-current="true""""))
        assertTrue(html.contains("""aria-label="Slide 1""""))
    }

    @Test
    fun `inactive indicator omits aria-current and offsets the default label`() {
        val html = createHTML().div { bsCarouselIndicator(target = "demo", index = 1) }
        assertFalse(html.contains("aria-current"))
        assertTrue(html.contains("""aria-label="Slide 2""""))
    }

    @Test
    fun `carousel item with interval sets data-bs-interval`() {
        val html = createHTML().div { bsCarouselItem(active = true, intervalMillis = 10000) {} }
        assertTrue(html.contains("""class="carousel-item active""""))
        assertTrue(html.contains("""data-bs-interval="10000""""))
    }

    @Test
    fun `default carousel item has no interval attribute`() {
        val html = createHTML().div { bsCarouselItem {} }
        assertTrue(html.contains("""class="carousel-item""""))
        assertFalse(html.contains("data-bs-interval"))
    }

    @Test
    fun `controls carry target, slide direction, icon and visually-hidden text`() {
        val html = createHTML().div {
            bsCarouselControlPrev(target = "demo")
            bsCarouselControlNext(target = "demo")
        }
        assertTrue(html.contains("""class="carousel-control-prev""""))
        assertTrue(html.contains("""data-bs-slide="prev""""))
        assertTrue(html.contains("""class="carousel-control-prev-icon""""))
        assertTrue(html.contains("""class="carousel-control-next""""))
        assertTrue(html.contains("""data-bs-slide="next""""))
        assertTrue(html.contains("""class="carousel-control-next-icon""""))
        assertTrue(html.contains("""class="visually-hidden""""))
        assertTrue(html.contains(">Previous<"))
        assertTrue(html.contains(">Next<"))
    }

    @Test
    fun `full carousel composes indicators inner items and controls`() {
        val html = createHTML().div {
            bsCarousel(id = "demo", ride = CarouselRide.Carousel) {
                bsCarouselIndicators {
                    bsCarouselIndicator(target = "demo", index = 0, active = true)
                    bsCarouselIndicator(target = "demo", index = 1)
                }
                bsCarouselInner {
                    bsCarouselItem(active = true) { bsCarouselCaption { +"Caption" } }
                    bsCarouselItem { +"Slide 2" }
                }
                bsCarouselControlPrev(target = "demo")
                bsCarouselControlNext(target = "demo")
            }
        }
        assertTrue(html.contains("""class="carousel-indicators""""))
        assertTrue(html.contains("""class="carousel-inner""""))
        assertTrue(html.contains("""class="carousel-caption""""))
        assertTrue(html.contains("Caption"))
        assertTrue(html.contains("Slide 2"))
    }
}
