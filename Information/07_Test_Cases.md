# Test Cases (Step 1)

| ID | Case | Steps | Expected |
|---|---|---|---|
| TC-01 | Valid login | Username 1, password 1 | Welcome page opens; shows "Owner" on the Profile button |
| TC-02 | Wrong password | Username 1, password 9 | "Invalid username or password" |
| TC-03 | Unknown user | Username 99, password 1 | "Invalid username or password" |
| TC-04 | Empty username | Leave username blank | "Enter your username" |
| TC-05 | Empty password | Leave password blank | "Enter your password" |
| TC-06 | Inactive user | Set status INACTIVE for user 3, log in as 3 | "Your account is inactive. Contact the owner." |
| TC-07 | Last login saved | Log in as 2, query `SELECT last_login_at FROM users WHERE username = '2'` | Timestamp is set |
| TC-08 | Logout | Click Logout | Login page opens; Back does not show Welcome |
| TC-09 | Direct Welcome access | Open `/welcome` without logging in | Redirects to login |
| TC-10 | Mobile layout | Open on phone width | Cards stacked; Profile and Logout visible |
| TC-11 | Backend down | Stop the backend, try login | "Can't reach the server. Check that the backend is running." |
