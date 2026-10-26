# API Document

Base URL: `http://localhost:8080`
All APIs: **POST**, JSON body, `Content-Type: application/json`.

## Response format
```json
{ "success": true, "message": "text", "data": {} }
```

## 1. Login
`POST /api/user/login`

Request
```json
{ "username": "1", "password": "1" }
```

Success (200)
```json
{
  "success": true,
  "message": "Login successful",
  "data": { "id": 1, "username": "1", "fullName": "Owner", "role": "OWNER" }
}
```

Errors
| HTTP | Message | When |
|---|---|---|
| 400 | Enter your username / Enter your password | Field empty |
| 401 | Invalid username or password | Unknown user or wrong password |
| 403 | Your account is inactive. Contact the owner. | Status is INACTIVE |
| 500 | Something went wrong. Try again. | Unexpected error |

## Postman steps
1. New request, method POST, URL `http://localhost:8080/api/user/login`.
2. Body, raw, JSON, paste the request above, Send.
