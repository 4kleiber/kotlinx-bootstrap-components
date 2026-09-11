package io.github._4kleiber.bootstrap.gallery

import io.github._4kleiber.bootstrap.gallery.pages.alertPage
import io.github._4kleiber.bootstrap.gallery.pages.badgePage
import io.github._4kleiber.bootstrap.gallery.pages.breadcrumbPage
import io.github._4kleiber.bootstrap.gallery.pages.buttonGroupPage
import io.github._4kleiber.bootstrap.gallery.pages.buttonPage
import io.github._4kleiber.bootstrap.gallery.pages.cardPage
import io.github._4kleiber.bootstrap.gallery.pages.closeButtonPage
import io.github._4kleiber.bootstrap.gallery.pages.collapsePage
import io.github._4kleiber.bootstrap.gallery.pages.dropdownPage
import io.github._4kleiber.bootstrap.gallery.pages.gridPage
import io.github._4kleiber.bootstrap.gallery.pages.indexPage
import io.github._4kleiber.bootstrap.gallery.pages.listGroupPage
import io.github._4kleiber.bootstrap.gallery.pages.modalPage
import io.github._4kleiber.bootstrap.gallery.pages.navPage
import io.github._4kleiber.bootstrap.gallery.pages.navbarPage
import io.github._4kleiber.bootstrap.gallery.pages.offcanvasPage
import io.github._4kleiber.bootstrap.gallery.pages.paginationPage
import io.github._4kleiber.bootstrap.gallery.pages.placeholderPage
import io.github._4kleiber.bootstrap.gallery.pages.progressPage
import io.github._4kleiber.bootstrap.gallery.pages.spinnerPage
import io.github._4kleiber.bootstrap.gallery.pages.tabPage
import io.github._4kleiber.bootstrap.gallery.pages.toastPage
import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.html.respondHtml
import io.ktor.server.netty.Netty
import io.ktor.server.response.respondRedirect
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun main() {
    embeddedServer(Netty, port = 8080, module = Application::galleryModule).start(wait = true)
}

private fun Application.galleryModule() {
    routing {
        get("/") { call.respondHtml { indexPage() } }
        get("/components/grid") { call.respondHtml { gridPage() } }
        get("/components/button") { call.respondHtml { buttonPage() } }
        get("/components/button-group") { call.respondHtml { buttonGroupPage() } }
        get("/components/close-button") { call.respondHtml { closeButtonPage() } }
        get("/components/alert") { call.respondHtml { alertPage() } }
        get("/components/badge") { call.respondHtml { badgePage() } }
        get("/components/card") { call.respondHtml { cardPage() } }
        get("/components/list-group") { call.respondHtml { listGroupPage() } }
        get("/components/breadcrumb") { call.respondHtml { breadcrumbPage() } }
        get("/components/pagination") { call.respondHtml { paginationPage() } }
        get("/components/progress") { call.respondHtml { progressPage() } }
        get("/components/spinner") { call.respondHtml { spinnerPage() } }
        get("/components/placeholder") { call.respondHtml { placeholderPage() } }
        get("/components/collapse") { call.respondHtml { collapsePage() } }
        get("/components/dropdown") { call.respondHtml { dropdownPage() } }
        get("/components/nav") { call.respondHtml { navPage() } }
        get("/components/tab") { call.respondHtml { tabPage() } }
        get("/components/navbar") { call.respondHtml { navbarPage() } }
        get("/components/modal") { call.respondHtml { modalPage() } }
        get("/components/offcanvas") { call.respondHtml { offcanvasPage() } }
        get("/components/toast") { call.respondHtml { toastPage() } }
        get("/components") { call.respondRedirect("/") }
    }
}
