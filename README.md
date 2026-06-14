# DigitalWallet - Android Assessment

## Project Overview
DigitalWallet is a modern Android application demonstrating a high-fidelity digital wallet interface. It features comprehensive Home, Transaction History, and Profile management screens built with Jetpack Compose and Clean Architecture.

## Setup Instructions
- **JDK Version:** JDK 17 or higher
- **Android Studio Version:** Android Studio Jellyfish (2023.3.1) or later
- **How to Build:**
  - Clone the repository: `git clone https://github.com/Sabekur-reza17/digitalwallet`
  - Open the project in Android Studio and let Gradle sync.
  - Run the app using the `Run` button or use `./gradlew assembleDebug` to generate a debug APK.

## Architecture
This project follows **Clean Architecture** principles combined with **MVI (Model-View-Intent)** state management for a robust and predictable UI.

- **Package Structure:**
  - `data`: Repositories and Data Sources (Mock implementation).
  - `domain`: Use Cases and Domain Models (Pure Kotlin logic).
  - `presentation`: UI Components, Screens, and ViewModels (Jetpack Compose).
  - `utilities`: Extensions and shared helper classes.
- **State Management:** Each screen uses a dedicated `ViewModel` with a `StateFlow` exposing a single `UiState` object, following the MVI pattern for reactive updates.

## Screens Implemented
- **Home:** Wallet balance, service grid (Electricity, Internet, etc.), promotions, and nearby merchants.
- **History:** Searchable transaction history with detailed transaction cards and status indicators.
- **Profile:** User profile information with a "Verified account" badge and categorized settings list.
- **Merchant:** Navigation placeholder as per scope.

## Assumptions & Trade-offs
- **Priority:** Given the 2-day timeline, priority was placed on UI fidelity (matching the provided designs exactly) and implementing a solid Clean Architecture foundation.
- **Data:** All data is driven by a mock `WalletDatasource` to simulate real API behavior without requiring a backend.
- **Components:** Created reusable custom components for headers, grids, and list items to maintain consistency.

## Time Spent
- **Architecture & Foundation:** 3 hours
- **UI Development (Compose):** 8 hours
- **Polish & Design Refinement:** 2 hours
- **Total:** ~13 hours

## Improvements with More Time
If given more time, I would focus on:
- Achieving 100% pixel-perfect design refinements for every micro-interaction.
- Adding subtle animations and transitions between screens.

## Unit Tests
Implemented unit tests for:
- **ViewModels**: `HomeViewModel`, `HistoryViewModel`, `ProfileViewModel` using MockK and Turbine.
- **Use Cases**: `GetHomeDataUseCase` to verify data combination logic.

---
**GitHub Repo:** [https://github.com/Sabekur-reza17/digitalwallet](https://github.com/Sabekur-reza17/digitalwallet)
