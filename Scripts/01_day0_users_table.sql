-- 01_day0_users_table.sql
-- Schema: CHITS_DEV_V1 (Oracle 21c XE, service XEPDB1)
-- Purpose: users table for the dummy login (plain-text password for now; hash later).
-- Status: already executed on 2026-10-26.

CREATE TABLE users (
  id            NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  username      VARCHAR2(50)  NOT NULL,
  password      VARCHAR2(100) NOT NULL,
  full_name     VARCHAR2(100) NOT NULL,
  phone_number  VARCHAR2(15),
  role          VARCHAR2(20)  NOT NULL,
  status        VARCHAR2(10)  DEFAULT 'ACTIVE' NOT NULL,
  last_login_at TIMESTAMP,
  created_by    NUMBER,
  created_at    TIMESTAMP DEFAULT SYSTIMESTAMP NOT NULL,
  updated_at    TIMESTAMP,
  CONSTRAINT uq_users_username   UNIQUE (username),
  CONSTRAINT uq_users_phone      UNIQUE (phone_number),
  CONSTRAINT ck_users_role       CHECK (role IN ('OWNER', 'OWNER_VIEW', 'COLLECTOR')),
  CONSTRAINT ck_users_status     CHECK (status IN ('ACTIVE', 'INACTIVE')),
  CONSTRAINT fk_users_created_by FOREIGN KEY (created_by) REFERENCES users (id)
);
