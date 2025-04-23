# StayBo - Property Rental App

StayBo is a modern Android property rental app built with Clean Architecture and MVVM pattern.

## Architecture

The app is built using a modular architecture based on Clean Architecture principles, divided into three main layers:

1. **Presentation Layer**: Handles UI components using Jetpack Compose
2. **Domain Layer**: Contains business logic and use cases
3. **Data Layer**: Manages data sources and repositories

## Tech Stack

- Kotlin
- Jetpack Compose for UI
- Hilt for dependency injection
- Room for local database
- Retrofit for network calls
- Flow for reactive programming
- JUnit and Espresso for testing

## Project Setup

1. Clone the repository
2. Open the project in Android Studio
3. Sync the project with Gradle files
4. Run the application

## Implementation Progress

### Initial Project Setup
- [x] Configure Gradle with dependencies
- [x] Set up Clean Architecture structure
- [x] Configure code quality tools (Detekt and ktlint)

### CI/CD and Infrastructure
- [x] GitHub Actions setup
- [x] Code quality checks integration
- [x] Build validation
- [ ] Unit tests automation
- [ ] UI tests automation
- [ ] Google Play Store Integration
  - [ ] Internal testing track
  - [ ] Alpha/Beta track
  - [ ] Production track
  - [ ] Store listing and assets
  - [ ] App signing setup
- [ ] Firebase Integration
  - [ ] Project setup and configuration
  - [ ] Crashlytics
  - [ ] Push notifications (FCM)
  - [ ] Analytics
  - [ ] Performance monitoring

### Core Development
- [ ] Create networking base classes (PropertyRepository)
- [ ] Set up Room database structure
- [ ] Configure Hilt dependency injection
- [ ] Implement error handling utilities

### Data Layer
- [x] Define API interfaces and models
- [ ] Create Room entities and DAOs
- [ ] Implement repositories (PropertyRepositoryImpl)
- [ ] Add repository unit tests

### Domain Layer
- [x] Create use cases for core features (GetPropertiesUseCase)
- [x] Implement business logic with Flow
- [ ] Add unit tests for use cases

### Presentation Layer
- [x] Create Compose theme system
- [x] Implement main screens (PropertiesScreen)
- [x] Add view models (PropertiesViewModel)
- [ ] Build reusable components
- [ ] Set up navigation

### Testing & Polish
- [ ] Integration tests
- [ ] UI tests with Espresso
- [ ] Error states and loading indicators
- [ ] Performance optimization
- [ ] Accessibility improvements

## Data Structure

### Property Model
- Name
- Location
- Type
- Capacity
- Bedrooms
- Beds
- Rating
- Reviews count
- Host details
- Amenities
- Location data
- Reviews
- Availability
- Safety features
- Images

## Testing Strategy

- Unit Tests: ViewModels, Use Cases, Repositories
- Integration Tests: API calls, database operations
- UI Tests: User interactions, navigation
- Error Handling Tests: Network failures, edge cases
- Performance Testing: Load times, memory usage
- Static Analysis: Detekt, ktlint
