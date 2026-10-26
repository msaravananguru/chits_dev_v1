@echo off
rem Closes the backend and frontend windows opened by start-all.bat.
taskkill /FI "WINDOWTITLE eq V1 Backend*" /T /F
taskkill /FI "WINDOWTITLE eq V1 Frontend*" /T /F
