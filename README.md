# chitFromScratch V1

A chit-fund management application built step by step, slowly and clearly. Each step is documented in `Information/`.

## Tech stack
| Layer | Technology |
|---|---|
| Backend | Java 21, Spring Boot 4.1.2 (Maven), Spring Data JPA, Bean Validation |
| Database | Oracle 21c Express (service `XEPDB1`), schema `chits_dev_v1` |
| Frontend | React 18 + Vite (plain JavaScript) |

## Rules followed
- Every API is a **POST** with all input in the JSON body (nothing in the URL).
- Code is split by feature package, then by layer: `controller`, `service` (interface + `Impl`), `repository`, `entity`, `dto`.
- Every response is `ResponseEntity<ApiResponse<T>>`.
- Tables are created by running the SQL files in `Scripts/` manually. Hibernate only validates (`ddl-auto=validate`).
- Security (password hashing, tokens) comes after the basic features work.

## Folder structure
```
v1
├── src/main/java/chits/v1
│   ├── common   (dto, exception, config)
│   └── user     (controller, service, repository, entity, dto)
├── frontend     (React: dummy, welcome, api)
├── Scripts      (SQL files, numbered in run order)
└── Information  (PRD, architecture, user stories, API doc, ...)
```

## How to run
1. **Database:** run the files in `Scripts/` in order (`01_...`, `02_...`) as `chits_dev_v1`.
2. **Backend:** run `V1Application` from Eclipse. It starts on port 8080.
3. **Frontend:** in `frontend`, run `npm install` once, then `npm run dev`. Open http://localhost:5173. On a phone on the same Wi-Fi, open `http://<your-PC-IP>:5173`.

**One click:** double-click `start-all.bat` to start the backend and frontend together (`stop-all.bat` closes them). Close the Eclipse run first, or port 8080 will clash.

## Test logins (dummy, plain text)
| Username | Password | Role |
|---|---|---|
| 1 | 1 | Owner |
| 2 | 2 | Owner View Only |
| 3 | 3 | Collector |

## Documents
See `Information/`: PRD, architecture, user stories, database design, API document, coding standards, test cases, change log.

## Status
Step 1 done: dummy login and Welcome page. Next: Member feature.
