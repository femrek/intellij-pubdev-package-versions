# PubDev Version Completion Plugin for IntelliJ

Provides code completion for Dart and Flutter `pubspec.yaml` files by suggesting the latest available
versions of packages directly from [pub.dev](https://pub.dev). Also, list all versions of the Dart package 
or Flutter plugin.

---

## Table of Contents
- [Features](#features)
- [Installation](#installation)
  - [Build from Source using Gradle](#1-build-from-source-using-gradle)
  - [Install Plugin in IntelliJ](#2-install-plugin-in-intellij)
- [Usage](#usage)
- [License](#license)

---

## Features

- Supports version completions inside `dependencies` and `dev_dependencies` sections.
- Suggests the **latest** version of a package when typing a dependency name.
- Also, shows **available versions**.

![preview](/asset/preview.gif)

---

## Installation

### 1. Build from Source using Gradle

Make sure you have Java installed.

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

This project is licensed under the [Apache License 2.0](LICENSE).  
