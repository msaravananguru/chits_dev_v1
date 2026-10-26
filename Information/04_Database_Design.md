# Database Design

Database: Oracle 21c XE, service `XEPDB1`, schema `CHITS_DEV_V1`.
Scripts: `Scripts/` (run in numbered order).

## Table: USERS
| Column | Type | Null | Notes |
|---|---|---|---|
| ID | NUMBER (identity) | No | Primary key |
| USERNAME | VARCHAR2(50) | No | Unique |
| PASSWORD | VARCHAR2(100) | No | Plain text for now; becomes a hash later |
| FULL_NAME | VARCHAR2(100) | No | |
| PHONE_NUMBER | VARCHAR2(15) | Yes | Unique |
| ROLE | VARCHAR2(20) | No | OWNER, OWNER_VIEW, COLLECTOR |
| STATUS | VARCHAR2(10) | No | ACTIVE or INACTIVE, default ACTIVE |
| LAST_LOGIN_AT | TIMESTAMP | Yes | Set on each login |
| CREATED_BY | NUMBER | Yes | FK to USERS.ID |
| CREATED_AT | TIMESTAMP | No | Default SYSTIMESTAMP |
| UPDATED_AT | TIMESTAMP | Yes | |

Constraints: `uq_users_username`, `uq_users_phone`, `ck_users_role`, `ck_users_status`, `fk_users_created_by`.

## Seed data
| Username | Password | Role |
|---|---|---|
| 1 | 1 | OWNER |
| 2 | 2 | OWNER_VIEW |
| 3 | 3 | COLLECTOR |

## Script log
| File | Purpose | Run on |
|---|---|---|
| 01_day0_users_table.sql | Create USERS | 2026-10-26 |
| 02_users_seed_data.sql | Insert test users | 2026-10-26 |
