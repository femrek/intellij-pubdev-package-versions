# PubDev Version Completion Plugin for IntelliJ

Provides intelligent code completion for Dart and Flutter `pubspec.yaml` files by suggesting the latest available
versions of packages directly from pub.dev.

---

## Features

- Suggests the **latest** version of a package when typing a dependency name.
- Also, shows **available versions**.
- Supports version completions inside `dependencies` and `dev_dependencies` sections.

---

## Installation

### 1. Build from Source using Gradle

Make sure you have Java and Gradle installed.

```bash
./gradlew buildPlugin
```

The build will create a plugin ZIP file at:

```
build/distributions/pubdev-version-completion-<version>.zip
```

### 2. Install Plugin in IntelliJ

- Open IntelliJ IDEA.
- Go to Settings (Preferences on macOS) → Plugins.
- Click the gear icon and choose Install Plugin from Disk...
- Select the ZIP file generated in build/distributions.
- Restart IntelliJ IDEA.

---

## Usage

- Open or create a Dart/Flutter project.
- Open the pubspec.yaml file.
- When adding or editing dependencies under `dependencies:` or `dev_dependencies:`, start typing the version of a
  package.
- The plugin will suggest the latest available version and other versions from pub.dev.

---

## License

MIT License — see LICENSE file.

---

## Contributing

Contributions or suggestions are welcome. Please open issues or pull requests.
