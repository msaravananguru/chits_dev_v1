# Architecture

## 1. Overview
Three tiers: React single-page app, Spring Boot REST API, Oracle database.

```
React (Vite, :5173)  --POST JSON-->  Spring Boot (:8080)  --JPA-->  Oracle XEPDB1 (:1521)
```

## 2. Backend layers (per feature package)
| Layer | Responsibility |
|---|---|
| controller | Accepts the POST request, validates input, returns `ResponseEntity<ApiResponse<T>>` |
| service (interface + Impl) | Business rules and transactions |
| repository | Database access (Spring Data JPA) |
| entity | Maps a database table |
| dto | Request and response objects (entities are never sent to the UI) |

Shared code is in `common`: `ApiResponse`, `BusinessException`, `GlobalExceptionHandler`, `CorsConfig`.

## 3. Standard response
```json
{ "success": true, "message": "Login successful", "data": { } }
```
Failures use `success: false`, a message, and `data: null` with the right HTTP status (400, 401, 403, 500).

## 4. Step 1 login sequence
1. `DummyLogin` posts username and password to `/api/user/login`.
2. `UserController` validates and calls `UserServiceImpl.login`.
3. The service reads the user through `UserRepository`, checks password and status, saves `last_login_at`.
4. The API returns id, username, full name and role.
5. React stores the user in `localStorage` and opens `Welcome`.

## 5. Frontend structure
```
frontend/src
├── api       (POST calls)
├── dummy     (temporary login page)
└── welcome   (first page after login)
```
New features get their own folder next to these.

## 6. Decisions
| # | Decision | Reason |
|---|---|---|
| D1 | Feature packages, then layers | Easy to find code; features stay separate |
| D2 | Service interface + Impl | Standard pattern, easy to test and explain |
| D3 | All APIs POST | Owner's rule; no data in URLs |
| D4 | Tables by manual SQL script | Full control; Hibernate only validates |
| D5 | Plain-text password for now | Security added after features work |
| D6 | No Lombok in code | Plain Java is better for learning |

## 7. Planned changes
Hashing (BCrypt), Spring Security with tokens, role checks per API, audit table, serving the built React app from Spring Boot.
