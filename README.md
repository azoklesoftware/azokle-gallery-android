# Azokle Gallery

<p align="center">
  <img src="app/src/main/res/drawable/ic_launcher_foreground.xml" width="96" alt="Azokle Gallery Logo" />
</p>

<p align="center">
  <b>A modern, fast, and privacy-focused gallery app for Android</b>
  <br/>
  Built by <a href="https://azokle.com">Azokle Private Limited</a>
</p>

<p align="center">
  <a href="https://github.com/azoklesoftware/azokle-gallery-android/actions/workflows/build.yml">
    <img src="https://github.com/azoklesoftware/azokle-gallery-android/actions/workflows/build.yml/badge.svg" alt="Build Status" />
  </a>
  <a href="https://github.com/azoklesoftware/azokle-gallery-android/blob/main/LICENSES/Apache-2.0.txt">
    <img src="https://img.shields.io/badge/license-Apache%202.0-blue.svg" alt="License" />
  </a>
  <img src="https://img.shields.io/badge/Android-11%2B-green.svg" alt="Android 11+" />
  <img src="https://img.shields.io/badge/Kotlin-1.8-purple.svg" alt="Kotlin" />
</p>

---

## ✨ Features

- 📸 **Photos & Videos** — Browse all your on-device media in a clean, fluid grid
- 🎞️ **Albums** — View media organized by folder / bucket
- ⭐ **Favorites** — Mark media you love for quick access
- 🗑️ **Trash** — Safely delete and restore media
- 🔍 **Full-screen Viewer** — Pinch-to-zoom images and play videos with ExoPlayer
- 🎨 **Wallpaper Setter** — Set any image as home or lock screen wallpaper
- 📁 **Media Picker** — Works as a system-level `GET_CONTENT` / `PICK` provider
- 🌙 **Material You** — Full Material3 / dynamic color theming (Light + Dark)
- 🔒 **Privacy First** — No analytics, no trackers, no internet access required for core features

---

## 📱 Screenshots

> _Screenshots coming soon_

---

## 🚀 Getting Started

### Prerequisites

| Tool | Minimum Version |
|------|----------------|
| Android Studio | Hedgehog (2023.1.1) or newer |
| JDK | 17 |
| Android SDK | API 30 (Android 11) |
| Gradle | 8.x |

### Building from Source

1. **Clone the repository**
   ```bash
   git clone https://github.com/azoklesoftware/azokle-gallery-android.git
   cd azokle-gallery-android
   ```

2. **Open in Android Studio**
   
   Open the cloned directory in Android Studio and allow Gradle to sync.

3. **Build a debug APK**
   ```bash
   ./gradlew assembleDebug
   ```

4. **Install on a connected device**
   ```bash
   ./gradlew installDebug
   ```

> **Note:** The debug build uses the package ID `org.azokle.gallery.dev` to avoid conflicting with any release install.

---

## 🏗️ Architecture & Tech Stack

```
azokle-gallery-android/
├── app/
│   └── src/main/java/org/azokle/gallery/
│       ├── activities/          # MainActivity, ViewActivity, PickerActivity, etc.
│       ├── fragments/           # LibraryFragment, AlbumsFragment, AlbumViewerFragment
│       ├── viewmodels/          # MVVM ViewModels (MediaViewerViewModel, etc.)
│       ├── repository/          # Data layer via MediaStore
│       ├── flow/                # Kotlin Flow wrappers for reactive queries
│       ├── query/               # MediaQuery, Query abstractions
│       ├── recyclerview/        # Custom adapters and layout managers
│       ├── ui/                  # Custom Views (ListItem)
│       ├── ext/                 # Kotlin extension functions
│       └── utils/               # Permission utils, media dialog helpers
├── .github/
│   ├── workflows/               # CI build pipeline
│   ├── ISSUE_TEMPLATE/          # Bug & feature request templates
│   └── PULL_REQUEST_TEMPLATE.md
├── CONTRIBUTING.md
├── CODE_OF_CONDUCT.md
└── LICENSES/
    └── Apache-2.0.txt
```

### Key libraries

| Library | Purpose |
|---------|---------|
| [AndroidX Media3 / ExoPlayer](https://developer.android.com/media/media3) | Video & audio playback |
| [Coil](https://coil-kt.github.io/coil/) | Image loading (including GIF, video thumbnails) |
| [ZoomImage](https://github.com/panpf/zoomimage) | Pinch-to-zoom for the media viewer |
| [AndroidX Navigation](https://developer.android.com/guide/navigation) | Fragment navigation |
| [Material3](https://m3.material.io/) | UI components and theming |

---

## 🤝 Contributing

We welcome contributions of all kinds — bug fixes, new features, UI improvements, translations, and documentation.

Please read our **[Contributing Guide](CONTRIBUTING.md)** and **[Code of Conduct](CODE_OF_CONDUCT.md)** before submitting a pull request.

---

## 🐛 Reporting Issues

- Use the [Bug Report template](.github/ISSUE_TEMPLATE/bug_report.md) for crashes or unexpected behavior
- Use the [Feature Request template](.github/ISSUE_TEMPLATE/feature_request.md) for ideas and suggestions

---

## 📄 License

```
Copyright 2023-2024 Azokle Private Limited

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

See the full license text in [LICENSES/Apache-2.0.txt](LICENSES/Apache-2.0.txt).

---

## 🌐 Links

| | |
|-|-|
| 🏠 Website | [azokle.com](https://azokle.com) |
| 📘 About Us | [azokle.com/company-info](https://azokle.com/company-info) |
| 🔒 Privacy Policy | [policies.azokle.com/privacy](https://policies.azokle.com/privacy) |
| 🐙 GitHub | [github.com/azoklesoftware](https://github.com/azoklesoftware) |
