-- 02_users_seed_data.sql
-- Purpose: three test users for the dummy login (username/password: 1/1, 2/2, 3/3).
-- Status: already executed on 2026-10-26.

INSERT INTO users (username, password, full_name, phone_number, role)
VALUES ('1', '1', 'Owner', '9000000001', 'OWNER');
INSERT INTO users (username, password, full_name, phone_number, role)
VALUES ('2', '2', 'Owner View Only', '9000000002', 'OWNER_VIEW');
INSERT INTO users (username, password, full_name, phone_number, role)
VALUES ('3', '3', 'Collector', '9000000003', 'COLLECTOR');
COMMIT;
