# Developer guide

## Preserve the original application

The desktop game remains under `JavaDragonQuest1-master/`. The website at the repository root is an additional entry point and the browser demo is intentionally independent of the Java runtime. Avoid overwriting original source, asset, or license files when adding systems.

## Local setup

Install a JDK (Java 8 compatibility is required) and Git. Verify the environment:

```sh
java -version
javac -version
```

Compile all source files:

```sh
cd JavaDragonQuest1-master
mkdir -p build/classes
find src -name '*.java' -print0 | xargs -0 javac -encoding UTF-8 -source 8 -target 8 -d build/classes
```

Launch from the project directory:

```sh
java -cp build/classes main.Main
```

The project also includes its existing NetBeans/Ant metadata. Use the project's IDE configuration when working with its full asset and packaging setup.

## Website smoke test

Open `index.html` directly or serve the repository root with a local static server. Verify:
- navigation links and documentation links resolve;
- the layout fits desktop and narrow mobile screens;
- movement changes the demo location;
- fighting changes health/XP/gold, resting consumes gold, and restart resets state;
- no JavaScript console errors occur.

The demo is deliberately simple and uses no external scripts, fonts, or runtime services.

## CI and Pages

- `.github/workflows/ci.yml` compiles Java source and checks the website for expected elements.
- `.github/workflows/pages.yml` publishes the static site through GitHub Pages.
- Configure repository Settings → Pages to use **GitHub Actions** if required by the repository settings.

## Change and release checklist

1. Inspect existing code and assets before edits.
2. Keep changes focused and avoid committing generated build output.
3. Run the Java compilation and website smoke checks locally.
4. Test the desktop UI on a supported OS; headless CI cannot verify graphics, audio devices, or gameplay.
5. Review GitHub Actions results before merging or tagging a release.
6. Preserve existing attribution, license notices, and upstream credits.
