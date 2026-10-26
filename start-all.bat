@echo off
rem Starts the backend (Spring Boot, port 8080) and the frontend (Vite, port 5173) in two windows.
set ROOT=%~dp0

echo Starting backend...
start "V1 Backend" cmd /k "cd /d %ROOT% && mvnw.cmd spring-boot:run"

echo Starting frontend...
if not exist "%ROOT%frontend\node_modules" (
  start "V1 Frontend" cmd /k "cd /d %ROOT%frontend && npm install && npm run dev"
) else (
  start "V1 Frontend" cmd /k "cd /d %ROOT%frontend && npm run dev"
)

echo Opening the browser in 15 seconds...
timeout /t 15 /nobreak >nul
start http://localhost:5173
