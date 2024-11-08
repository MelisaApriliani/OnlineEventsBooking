-- INSERT TO USER TABLE
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