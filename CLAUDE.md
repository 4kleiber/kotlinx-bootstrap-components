# CLAUDE.md

This repository is developed with the help of [Claude Code](https://claude.com/claude-code).
Changes proposed or made by Claude Code should follow the conventions documented here and in
[CONTRIBUTING.md](CONTRIBUTING.md).

## What this project is

Kotlin extension functions that render Bootstrap 5.3 markup on top of kotlinx.html (JVM). See
[README.md](README.md) for the full picture; the essentials for working in this codebase:

- **Namespace**: `io.github._4kleiber` (the underscore is intentional — `4kleiber` starts with a
  digit, an illegal Kotlin package segment). Treat this as fixed; renaming it breaks every
  consumer's imports.
- **Function naming**: every component function is prefixed `bs` (`bsButton`, `bsAlert`, …) to
  avoid colliding with kotlinx.html's own tag-builder functions of the same name.
- **Distribution**: source-only. No Maven Central / JitPack / GitHub Packages publish step exists
  or should be added without an explicit decision to do so — `release-please` only cuts tagged
  GitHub releases; consumers pin a tag and build the library themselves (see README "Installing").
- **Two modules**: the root project is the library itself (keeps the consumer-facing coordinate
  simple under `includeBuild`); `:gallery` is a separate, non-published Ktor app used only for
  local component documentation/browsing — never treat it as part of what consumers pull in.

## Bootstrap version

The library targets Bootstrap 5.3 conventions throughout. The gallery pins one exact release via
`BOOTSTRAP_VERSION` in `gallery/.../Layout.kt` for its CDN links only. See the README's "Bootstrap
version" section before bumping either.

## Conventions to follow

- Add components per the recipe in `CONTRIBUTING.md` — enums for variant/size/color axes, one
  function per structural element delegating straight to kotlinx.html, `classes` escape hatch +
  content lambda last, typed parameters for `data-bs-*` attributes.
- Every new component needs a mirrored test file (`src/test/.../<Component>Test.kt`, asserting on
  rendered output via `createHTML()`) and a gallery page — both are part of "done", not optional
  follow-ups.
- Commit messages follow Conventional Commits (`feat:`, `fix:`, `feat!:`/`BREAKING CHANGE:`, …) —
  `release-please` parses them directly to compute version bumps and `CHANGELOG.md` entries.

## Verifying changes

```bash
./gradlew build            # compiles both modules, runs all tests
./gradlew :gallery:run     # smoke-test the gallery at http://localhost:8080
```
