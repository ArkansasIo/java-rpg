# Java RPG — Dragon Quest I

This repository contains a Java remake of **Dragon Quest I / Dragon Warrior I** and a separate responsive project website with a small browser RPG demo.

## Project layout

- `JavaDragonQuest1-master/src/` — original Java application source.
- `JavaDragonQuest1-master/assets/` — original game assets.
- `JavaDragonQuest1-master/README.md` — upstream game overview and keyboard controls.
- `index.html` — GitHub Pages website and self-contained browser demo.
- `docs/DEVELOPMENT.md` — build, test and contribution notes.
- `.github/workflows/ci.yml` — Java compilation and website smoke checks.
- `.github/workflows/pages.yml` — GitHub Pages deployment workflow.

## Requirements

- JDK 8 or later (the project targets Java 8 bytecode).
- Git for checkout and version control.
- No third-party Java runtime libraries are required by the original game's README.

## Build the Java game

From the repository root:

```sh
cd JavaDragonQuest1-master
mkdir -p build/classes
find src -name '*.java' -print0 | xargs -0 javac -encoding UTF-8 -source 8 -target 8 -d build/classes
java -cp build/classes main.Main
```

On Windows PowerShell, use your IDE's existing Ant/NetBeans project configuration or compile the source list with `javac`. The browser demo is a separate lightweight prototype, not a port of the Java game.

## GitHub Pages

The Pages workflow publishes the repository root. In GitHub, open **Settings → Pages** and set the source to **GitHub Actions** if it is not already selected. After the workflow succeeds, GitHub will display the published URL in the Pages settings and deployment environment.

## CI checks

GitHub Actions compiles the Java sources against Java 8 compatibility and performs basic static website checks. These checks do not replace manual gameplay testing or a full GUI/audio test on a desktop OS.

## Controls in the original Java game

- Arrow keys: move.
- X: confirm.
- Z: cancel.

## Attribution

The original Java project README credits its upstream project and lists game reference material. Preserve upstream notices and licenses when modifying or redistributing its assets and source.
