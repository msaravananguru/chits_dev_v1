# Coding Standards

## Backend
- Package: `chits.v1.<feature>.<layer>`; shared code in `chits.v1.common`.
- Controllers: POST only, `@Valid @RequestBody`, return `ResponseEntity<ApiResponse<T>>`. No business logic.
- Services: interface `XService` + class `XServiceImpl`; transactions on the Impl.
- Never return an entity to the UI; use DTOs.
- Business failures throw `BusinessException(message, HttpStatus)`.
- Class names: `UserController`, `UserService`, `UserServiceImpl`, `UserRepository`, `User`, `LoginRequest`, `LoginResponse`.
- Table and column names in UPPER_SNAKE_CASE in the database; `@Column(name = ...)` in entities.
- `ddl-auto=validate`: database changes go through a numbered script in `Scripts/`.

## Frontend
- One folder per feature under `src`; API calls only in `src/api`.
- Every call is POST with a JSON body.
- UI text: sentence case, no "please", errors say what happened and what to do.
- Must work on phone width first, then desktop.

## Documentation
- Every step updates: user stories, API document, database design (if changed), change log.
- SQL files: `NN_description.sql`, with a header comment and the run date in the database design script log.
