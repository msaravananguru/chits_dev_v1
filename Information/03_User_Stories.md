# User Stories

## Epic 1: Access
| ID | Story | Acceptance criteria | Status |
|---|---|---|---|
| US-01 | As a user, I want to sign in with my username and password so that I can use the app. | Valid login opens the Welcome page. | Done |
| US-02 | As a user, I want a clear message when my login is wrong. | Shows "Invalid username or password"; stays on the login page. | Done |
| US-03 | As the owner, I want inactive users blocked. | Inactive user sees "Your account is inactive. Contact the owner." | Done |
| US-04 | As the owner, I want to see when each user last logged in. | `last_login_at` is updated on every successful login. | Done |

## Epic 2: Navigation
| ID | Story | Acceptance criteria | Status |
|---|---|---|---|
| US-05 | As a user, I want a Welcome page with Chits and Finance. | Two cards shown; side by side on desktop, stacked on mobile. | Done |
| US-06 | As a user, I want Profile and Logout at the top right. | Both buttons visible; Logout clears the session and returns to login. | Done |

## Backlog
| ID | Story |
|---|---|
| US-07 | As the owner, I want to add a member to a chit plan. |
| US-08 | As the owner, I want a rate card of plans (25K to 200K). |
| US-09 | As a collector, I want to enter daily and single collections. |
| US-10 | As the owner, I want to lock a month once calculations are verified. |
| US-11 | As the owner, I want every action recorded in an audit trail. |
| US-12 | As the owner, I want passwords hashed and APIs protected by role. |
