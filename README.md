# kotlinx-bootstrap-components

Kotlin extension functions that render [Bootstrap 5.3](https://getbootstrap.com/docs/5.3/getting-started/introduction/)
markup on top of [kotlinx.html](https://github.com/Kotlin/kotlinx.html), so you can build
Bootstrap-styled HTML from idiomatic Kotlin instead of hand-writing tags and CSS class strings.

Every component function is prefixed `bs` (`bsButton`, `bsAlert`, `bsCard`, …) to stay clear of
kotlinx.html's own tag-builder functions of the same name (kotlinx.html already defines
`fun FlowContent.button(...)`, for example).

```kotlin
div {
    bsAlert(variant = AlertVariant.Success, dismissible = true) {
        +"Saved successfully!"
    }
    bsButton(variant = ButtonVariant.Primary, size = ButtonSize.Large) {
        +"Continue"
    }
}
```

## Browse the components

The `:gallery` module is a small local web server that renders every component live and doubles
as usage documentation — a rendered example plus the exact Kotlin call that produced it, for each
component.

```
./gradlew :gallery:run
```

Then open <http://localhost:8080>.

## Bootstrap version

This library targets **Bootstrap 5.3** — every component function's class names and markup follow
the conventions documented at <https://getbootstrap.com/docs/5.3/>, and each function's KDoc links
straight to the relevant docs page.

The gallery additionally pins one *exact* Bootstrap release (currently `5.3.3`) to load its CSS
and JS from jsDelivr's CDN, purely so the rendered examples look right in a browser — the library
itself never depends on, ships, or loads Bootstrap's CSS/JS at all; it only emits `class` and
`data-bs-*` attributes.

**To move the project to a newer Bootstrap release:**

1. Update `BOOTSTRAP_VERSION` in
   [`gallery/src/main/kotlin/io/github/_4kleiber/bootstrap/gallery/Layout.kt`](gallery/src/main/kotlin/io/github/_4kleiber/bootstrap/gallery/Layout.kt) —
   this is the single place the gallery's CDN links come from.
2. Diff the new release's [migration notes](https://getbootstrap.com/docs/5.3/migration/) (or the
   major-version migration guide, if crossing a major version) against every class name and
   `data-bs-*` attribute this library emits — grep for `"btn-`, `"alert-`, `"card-`, etc. across
   `src/main/kotlin/`. Update any component whose class names or markup shape changed, and update
   its KDoc's docs link if the anchor/section moved.
3. Update the Bootstrap version named in this section and bump the library's own version
   (`version.txt`) via a `feat:`/`fix:` commit as appropriate — see [CONTRIBUTING.md](CONTRIBUTING.md).
4. Re-run `./gradlew build` and eyeball every gallery page for visual regressions.

## Installing

This library is **not published to a binary registry** (no Maven Central, JitPack, or GitHub
Packages). Instead, `release-please` (see below) cuts a tagged, buildable commit on every release,
and consumers pin that tag and build the library themselves, via either of two methods.

### Method A — git submodule + Gradle composite build

```bash
git submodule add https://github.com/4kleiber/kotlinx-bootstrap-components.git libs/kotlinx-bootstrap-components
cd libs/kotlinx-bootstrap-components && git checkout v0.1.0
```

```kotlin
// consumer settings.gradle.kts
includeBuild("libs/kotlinx-bootstrap-components")
```

```kotlin
// consumer build.gradle.kts
dependencies {
    implementation("io.github._4kleiber:kotlinx-bootstrap-components")
}
```

Under `includeBuild`, Gradle substitutes by group:module only — the version string in the
consumer's `implementation(...)` is ignored; the actually-built version is whatever commit is
checked out in the submodule.

### Method B — Gradle native Git source dependency

```kotlin
// consumer settings.gradle.kts
sourceControl {
    gitRepository(java.net.URI("https://github.com/4kleiber/kotlinx-bootstrap-components.git")) {
        producesModule("io.github._4kleiber:kotlinx-bootstrap-components")
    }
}
```

```kotlin
// consumer build.gradle.kts
dependencies {
    implementation("io.github._4kleiber:kotlinx-bootstrap-components:v0.1.0")
}
```

No submodule to manage — Gradle clones the pinned tag itself and builds it as a source dependency.

## JavaScript-dependent components

This library **only emits HTML** — it never ships or executes any JavaScript. Components are
grouped by how much they depend on Bootstrap's JS bundle to actually work once rendered:

- **Markup/CSS only** (Grid, Buttons, Badge, Alerts, Card, List group, Breadcrumb, Pagination,
  Progress, Spinners, Placeholders, Button group, Close button): render correctly and are fully
  functional with Bootstrap's CSS alone.
- **Markup-only from this library, but the interactive *feature* needs Bootstrap's JS bundle**
  loaded on the consumer's page (Collapse, Dropdowns, Navs & tabs, Navbar, Modal, Offcanvas,
  Toasts): this library emits correct `data-bs-*`/ARIA markup, but nothing will open, close, or
  toggle until the page also loads `bootstrap.bundle.js`.
- **Heaviest JS dependency** (Tooltips, Popovers, Carousel, Scrollspy): the consumer must also
  write client-side initialization JS beyond data attributes for these to do anything. Within
  this tier, Tooltips and Popovers *always* need an explicit `new bootstrap.Tooltip(el)` /
  `new bootstrap.Popover(el)` call per trigger element — Bootstrap's JS never reads
  `data-bs-toggle="tooltip"`/`"popover"` on its own. Carousel and Scrollspy, by contrast, fully
  auto-initialize from `data-bs-ride="carousel"` / `data-bs-spy="scroll"` alone, same as the tier
  above — no consumer JS required for those two.

The gallery itself loads Bootstrap's CSS+JS bundle from a CDN for exactly this reason (and its
Tooltip/Popover pages additionally include the small init script those two specifically require).

## Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md) for the "add a component" recipe and commit message
conventions (this project uses [Conventional Commits](https://www.conventionalcommits.org/) —
`release-please` parses them directly to compute version bumps and changelog entries).
