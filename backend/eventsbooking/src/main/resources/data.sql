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

-- INSERT TO location TABLE
-- Insert predefined locations into location table only if they don't exist
INSERT INTO location (id, name, postal_code, address)
SELECT 1, 'CGC Hall', '10001', '5th Avenue, New York City'
    WHERE NOT EXISTS (SELECT 1 FROM location WHERE id = 1 AND name = 'New York');

INSERT INTO location (id, name, postal_code, address)
SELECT 2, 'XYZ Convention Centre', '90001', 'Main Street, Los Angeles'
    WHERE NOT EXISTS (SELECT 1 FROM location WHERE id = 2 AND name = 'Los Angeles');

INSERT INTO location (id, name, postal_code, address)
SELECT 3, 'One Avenue', '60601', 'Michigan Avenue, Chicago'
    WHERE NOT EXISTS (SELECT 1 FROM location WHERE id = 3 AND name = 'Chicago');

INSERT INTO location (id, name, postal_code, address)
SELECT 4, 'City Hospital', '77001', 'Texas Street, Houston'
    WHERE NOT EXISTS (SELECT 1 FROM location WHERE id = 4 AND name = 'Houston');

INSERT INTO location (id, name, postal_code, address)
SELECT 5, 'BYD Hall', '85001', 'Central Avenue, Phoenix'
    WHERE NOT EXISTS (SELECT 1 FROM location WHERE id = 5 AND name = 'Phoenix');

INSERT INTO location (id, name, postal_code, address)
SELECT 6, 'UNITEN', '19101', 'Market Street, Philadelphia'
    WHERE NOT EXISTS (SELECT 1 FROM location WHERE id = 6 AND name = 'Philadelphia');

INSERT INTO location (id, name, postal_code, address)
SELECT 7, 'San Antonio', '78201', 'Alamo Plaza, San Antonio'
    WHERE NOT EXISTS (SELECT 1 FROM location WHERE id = 7 AND name = 'San Antonio');