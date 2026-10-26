# Change Log

## 2026-10-27, Step 1: Dummy login and Welcome page
- Added `USERS` table and three test users (`Scripts/01`, `02`).
- Backend: `user` package (controller, service interface + Impl, repository, entity, dto) and `common` (ApiResponse, BusinessException, GlobalExceptionHandler, CorsConfig).
- API: `POST /api/user/login`.
- Frontend: Vite + React, `dummy/DummyLogin`, `welcome/Welcome`, `api/userApi`.
- Docs: README and Information files created.
- Known gap: plain-text password, no token (planned).
