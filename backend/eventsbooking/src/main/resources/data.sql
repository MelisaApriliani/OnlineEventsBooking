-- INSERT TO account TABLE
-- Check if the user table is empty, if so, insert predefined records
INSERT INTO "account" (username, password, role)
SELECT 'admin1@test.com', 'password123', 'ADMIN'
    WHERE NOT EXISTS (SELECT 1 FROM "account" WHERE username = 'admin1@test.com');

INSERT INTO "account" (username, password, role)
SELECT 'admin2@test.com', 'password123', 'ADMIN'
    WHERE NOT EXISTS (SELECT 1 FROM "account" WHERE username = 'admin2@test.com');

INSERT INTO "account" (username, password, role)
SELECT 'admin3@test.com', 'password123', 'ADMIN'
    WHERE NOT EXISTS (SELECT 1 FROM "account" WHERE username = 'admin3@test.com');

INSERT INTO "account" (username, password, role)
SELECT 'user1@test.com', 'password123', 'USER'
    WHERE NOT EXISTS (SELECT 1 FROM "account" WHERE username = 'user1@test.com');

INSERT INTO "account" (username, password, role)
SELECT 'user2@test.com', 'password123', 'USER'
    WHERE NOT EXISTS (SELECT 1 FROM "account" WHERE username = 'user2@test.com');

INSERT INTO "account" (username, password, role)
SELECT 'user3@test.com', 'password123', 'USER'
    WHERE NOT EXISTS (SELECT 1 FROM "account" WHERE username = 'user3@test.com');

-- INSERT TO event_status TABLE
-- Insert predefined statuses into event_status table only if they don't exist
INSERT INTO event_status (id, status_name)
SELECT 1, 'Approved'
    WHERE NOT EXISTS (SELECT 1 FROM event_status WHERE id = 1);

INSERT INTO event_status (id, status_name)
SELECT 2, 'Pending'
    WHERE NOT EXISTS (SELECT 1 FROM event_status WHERE id = 2);

INSERT INTO event_status (id, status_name)
SELECT 3, 'Rejected'
    WHERE NOT EXISTS (SELECT 1 FROM event_status WHERE id = 3);