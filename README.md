# Theo AI — Android

Theo is a phone-first personal AI assistant being built as a native Android app.

## Current milestone

- Native Kotlin + Jetpack Compose Android shell
- Premium dark glass / cyan-violet HUD direction
- GitHub Actions workflow to build a debug APK
- No AI provider is connected yet; this first milestone establishes the app and build pipeline

## Build

Push to `main` or manually run **Build Theo APK** from the repository's Actions tab. Download the `theo-debug-apk` artifact from a successful workflow run.

## Planned architecture

- Gemini API as the primary cloud model
- Local Qwen fallback through the existing Termux llama-server at `127.0.0.1:8080`
- App-owned local memory, independent of model provider
- Android actions through explicit, permission-aware native integrations

Never commit API keys or secrets to the repository. A key embedded in an APK can be extracted; provider credentials must be handled as user-supplied local configuration or through a properly secured backend.
