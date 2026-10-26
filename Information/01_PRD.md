# Product Requirements Document (PRD)

| Item | Value |
|---|---|
| Product | chitFromScratch V1 (Sudar chits and finance) |
| Version | 0.1 |
| Last updated | 2026-10-27 |
| Owner | Product owner |

## 1. Purpose
Replace paper and spreadsheet handling of chit collections with a simple application that works on phones (most users) and desktop (owner).

## 2. Goals
- Manage chit members, plans and monthly collections.
- Give each person only the access their role needs.
- Build slowly, one clear feature at a time, with documentation for each step.

## 3. Users and roles
| Role | Description |
|---|---|
| OWNER | Full access |
| OWNER_VIEW | Sees everything, cannot change anything |
| COLLECTOR | Sees everything view-only, enters collections |

## 4. Scope
### In scope for Step 1
- Dummy login against the `users` table.
- Welcome page with two options: Chits and Finance.
- Profile and Logout buttons at the top right.

### Planned (later steps)
Members, plans (rate card), daily and single collections, monthly sheet and lock, real login and security, audit trail, Finance module.

### Out of scope for now
Password hashing, tokens, role-based screens, notifications.

## 5. Functional requirements (Step 1)
| ID | Requirement |
|---|---|
| FR-01 | A user can sign in with username and password. |
| FR-02 | Wrong credentials show "Invalid username or password". |
| FR-03 | An inactive user cannot sign in. |
| FR-04 | After sign-in the Welcome page shows Chits and Finance. |
| FR-05 | Logout returns to the login page. |
| FR-06 | The last login time is saved. |

## 6. Non-functional requirements
- All APIs use POST with a JSON body.
- Works on screens from phone width to desktop.
- Standard response format on every API.
- Passwords are plain text only during development. Hashing is mandatory before real use.

## 7. Assumptions and risks
- Oracle 21c XE is available locally.
- Plain-text passwords are a known, temporary risk.

## 8. Success criteria (Step 1)
A user with a valid login reaches the Welcome page on both phone and desktop.
