# Contributing

## Adding a component

1. Read the [Bootstrap 5.3 docs page](https://getbootstrap.com/docs/5.3/) for the component and
   list its markup skeleton and every modifier class.
2. Create `<Component>.kt` under `src/main/kotlin/io/github/_4kleiber/bootstrap/`.
3. Define an `internal val cssClass`-carrying enum for each variant/size/color axis (see
   `Button.kt`, `Alert.kt` for the pattern). Use a sealed class or a `Map`-typed parameter only
   when the modifier is genuinely structured data (see `Grid.kt`'s `bsCol`).
4. Write one function per structural element (see `Card.kt` for a multi-element example), each
   delegating to the matching kotlinx.html tag function — never hand-build tag strings, never
   reimplement rendering. Signature order: typed modifiers first, `classes: String? = null` escape
   hatch, content lambda last. Route every class composition through
   `internal/ClassNames.kt`'s `classNames(vararg classes: String?)`.
5. Expose any `data-bs-*` attribute the component needs as a typed parameter, never left for the
   caller to type raw attribute strings (see `CloseButton.kt`'s `dismissTarget`).
6. Add a mirrored test file under `src/test/kotlin/io/github/_4kleiber/bootstrap/`, rendering
   through `kotlinx.html.stream.createHTML()` and asserting on the produced class attributes.
7. Add a page under `gallery/src/main/kotlin/io/github/_4kleiber/bootstrap/gallery/pages/`, wire
   it into `Main.kt`'s routing and `Layout.kt`'s `galleryComponents` nav list. A new component
   isn't done until it also has a gallery page.
8. If the component's *interactive* behavior needs Bootstrap's JS bundle at runtime (as opposed to
   being fully functional from markup+CSS alone), add it to the appropriate tier in the README's
   "JavaScript-dependent components" section.
9. Commit as `feat(<component>): ...` so `release-please` picks it up.

## Commit messages

This repo uses [Conventional Commits](https://www.conventionalcommits.org/); `release-please`
parses commit history directly to compute the next version and `CHANGELOG.md` entry, so a clean
history matters more than usual.

- `feat: ...` / `feat(button): ...` → minor version bump (patch while pre-1.0, per
  `bump-patch-for-minor-pre-major` in `release-please-config.json`) + a "Features" changelog entry.
- `fix: ...` → patch bump + a "Bug Fixes" changelog entry.
- `docs:`, `chore:`, `refactor:`, `test:`, `ci:`, `build:` → no version bump, but still recorded in
  the changelog.
- `feat!: ...`, or any commit with a `BREAKING CHANGE:` footer → major version bump.
- Prefer one logical change per commit — the changelog is generated straight from these messages.

## Building and testing

```bash
./gradlew build   # compiles the library and the gallery, runs all tests
./gradlew test    # library tests only
./gradlew :gallery:run   # start the component gallery at http://localhost:8080
```
