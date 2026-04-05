# Contributing to Azokle Gallery

Thank you for your interest in contributing to **Azokle Gallery**! 🎉

We welcome contributions from everyone. Please take a few minutes to read through this guide before getting started.

---

## 📋 Table of Contents

- [Code of Conduct](#code-of-conduct)
- [How Can I Contribute?](#how-can-i-contribute)
- [Development Setup](#development-setup)
- [Coding Standards](#coding-standards)
- [Commit Messages](#commit-messages)
- [Submitting a Pull Request](#submitting-a-pull-request)
- [Licensing](#licensing)

---

## Code of Conduct

By participating in this project, you agree to abide by our [Code of Conduct](CODE_OF_CONDUCT.md). Please read it before contributing.

---

## How Can I Contribute?

### 🐛 Reporting Bugs

- Check [existing issues](https://github.com/azoklesoftware/azokle-gallery-android/issues) first to avoid duplicates.
- Use the [Bug Report template](.github/ISSUE_TEMPLATE/bug_report.md).
- Include steps to reproduce, device info, Android version, and logcat output if possible.

### 💡 Suggesting Features

- Open a [Feature Request](.github/ISSUE_TEMPLATE/feature_request.md).
- Provide as much context and reasoning as possible.
- Check if a similar request already exists.

### 🌍 Translations

- We use Android resource string files (`app/src/main/res/values-*/strings.xml`).
- To add a new language, create a new `values-<locale>` folder and translate `strings.xml`.
- Submit it as a normal pull request.

### 🛠️ Code Contributions

- Look through [open issues](https://github.com/azoklesoftware/azokle-gallery-android/issues) labeled `good first issue` or `help wanted`.
- Comment on the issue to claim it before starting.

---

## Development Setup

1. **Fork & clone** the repository:
   ```bash
   git clone https://github.com/<your-username>/azokle-gallery-android.git
   cd azokle-gallery-android
   ```

2. **Open in Android Studio** (Hedgehog 2023.1.1 or newer recommended).

3. **Let Gradle sync** — no additional API keys or configuration required.

4. **Run the app** on a device or emulator with API 30+ (Android 11+).

5. **Create a branch** for your work:
   ```bash
   git checkout -b feature/your-feature-name
   ```

---

## Coding Standards

- Language: **Kotlin** only (no new Java files).
- Architecture: follow the existing **MVVM** pattern.
  - Business logic → `ViewModel`
  - Data access → `repository/` or `flow/` with `MediaStore`
  - UI → `Fragment` + XML layouts
- UI components: use **Material3** (`com.google.android.material`) components wherever possible.
- Do **not** add new dependencies without prior discussion in an issue.
- Run `./gradlew lint` before submitting — fix all errors, and avoid introducing new warnings.

### File Headers

Every new source file must include the SPDX license header:

```kotlin
/*
 * SPDX-FileCopyrightText: <year> Azokle Private Limited
 * SPDX-License-Identifier: Apache-2.0
 */
```

```xml
<!--
     SPDX-FileCopyrightText: <year> Azokle Private Limited
     SPDX-License-Identifier: Apache-2.0
-->
```

---

## Commit Messages

Follow the **Conventional Commits** format:

```
<type>(<scope>): <short description>

[optional body]

[optional footer]
```

**Types:**

| Type | When to use |
|------|------------|
| `feat` | A new feature |
| `fix` | A bug fix |
| `ui` | UI / layout / styling changes |
| `refactor` | Code restructuring without behavior change |
| `docs` | Documentation only changes |
| `chore` | Build scripts, CI, tooling |
| `test` | Adding or fixing tests |

**Examples:**
```
feat(library): add about section with company links
fix(viewer): prevent crash on empty media list
ui(library): wrap about items in MaterialCardView
docs: add contributing guide and issue templates
```

---

## Submitting a Pull Request

1. Ensure your branch is up to date with `main`:
   ```bash
   git fetch origin
   git rebase origin/main
   ```

2. Push your branch:
   ```bash
   git push origin feature/your-feature-name
   ```

3. Open a pull request against the `main` branch using our [PR template](.github/PULL_REQUEST_TEMPLATE.md).

4. **Checklist before submitting:**
   - [ ] Code builds without errors (`./gradlew assembleDebug`)
   - [ ] Lint passes (`./gradlew lint`)
   - [ ] New files have SPDX headers
   - [ ] No unnecessary dependencies added
   - [ ] PR description clearly explains what changed and why

5. A maintainer will review your PR. Please respond to review comments promptly.

---

## Licensing

By contributing to Azokle Gallery, you agree that your contributions will be licensed under the **Apache License 2.0**.

See [LICENSES/Apache-2.0.txt](LICENSES/Apache-2.0.txt) for the full license text.
