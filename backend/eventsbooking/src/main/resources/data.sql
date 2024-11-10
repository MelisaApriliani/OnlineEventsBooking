-- INSERT TO account TABLE
-- Check if the user table is empty, if so, insert predefined records
INSERT INTO "account" (username, password, role)
SELECT 'admin1@test.com', '$2a$10$1TPTEQ/UlcNdBkR4j8PfjuE6AJBMTjAXWjKJhc7NgBbDtgRqEa8K6', 'ADMIN'
    WHERE NOT EXISTS (SELECT 1 FROM "account" WHERE username = 'admin1@test.com');

INSERT INTO "account" (username, password, role)
SELECT 'admin2@test.com', '$2a$10$1TPTEQ/UlcNdBkR4j8PfjuE6AJBMTjAXWjKJhc7NgBbDtgRqEa8K6', 'ADMIN'
    WHERE NOT EXISTS (SELECT 1 FROM "account" WHERE username = 'admin2@test.com');

INSERT INTO "account" (username, password, role)
SELECT 'admin3@test.com', '$2a$10$1TPTEQ/UlcNdBkR4j8PfjuE6AJBMTjAXWjKJhc7NgBbDtgRqEa8K6', 'ADMIN'
    WHERE NOT EXISTS (SELECT 1 FROM "account" WHERE username = 'admin3@test.com');

INSERT INTO "account" (username, password, role)
SELECT 'user1@test.com', '$2a$10$1TPTEQ/UlcNdBkR4j8PfjuE6AJBMTjAXWjKJhc7NgBbDtgRqEa8K6', 'USER'
    WHERE NOT EXISTS (SELECT 1 FROM "account" WHERE username = 'user1@test.com');

INSERT INTO "account" (username, password, role)
SELECT 'user2@test.com', '$2a$10$1TPTEQ/UlcNdBkR4j8PfjuE6AJBMTjAXWjKJhc7NgBbDtgRqEa8K6', 'USER'
    WHERE NOT EXISTS (SELECT 1 FROM "account" WHERE username = 'user2@test.com');

INSERT INTO "account" (username, password, role)
SELECT 'user3@test.com', '$2a$10$1TPTEQ/UlcNdBkR4j8PfjuE6AJBMTjAXWjKJhc7NgBbDtgRqEa8K6', 'USER'
    WHERE NOT EXISTS (SELECT 1 FROM "account" WHERE username = 'user3@test.com');


-- INSERT TO vendor TABLE
-- Insert predefined vendors into the vendor table only if the given id and user_id do not exist
INSERT INTO vendor ( name, user_id)
SELECT  'Zenith Wellness Co.', 1
    WHERE NOT EXISTS (SELECT 1 FROM vendor WHERE id = 1 AND user_id = 1);

INSERT INTO vendor ( name, user_id)
SELECT  'Tranquil Moments', 2
    WHERE NOT EXISTS (SELECT 1 FROM vendor WHERE id = 2 AND user_id = 2);

INSERT INTO vendor ( name, user_id)
SELECT  'VitalEssence Wellness', 3
    WHERE NOT EXISTS (SELECT 1 FROM vendor WHERE id = 3 AND user_id = 3);

-- INSERT TO company TABLE
-- Insert predefined companies into the company table only if the given id and user_id do not exist
INSERT INTO company ( name, company_code, user_id)
SELECT  'GTech Solution', 'A001', 4
    WHERE NOT EXISTS (SELECT 1 FROM company WHERE id = 1 AND user_id = 4);

INSERT INTO company ( name, company_code, user_id)
SELECT  'RANS Corporation', 'B001', 5
    WHERE NOT EXISTS (SELECT 1 FROM company WHERE id = 2 AND user_id = 5);

INSERT INTO company ( name, company_code, user_id)
SELECT  'Marinara Inc.', 'C001', 6
    WHERE NOT EXISTS (SELECT 1 FROM company WHERE id = 3 AND user_id = 6);

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
INSERT INTO location (name, postal_code, address)
SELECT  'CGC Hall', '10001', '5th Avenue, New York City'
    WHERE NOT EXISTS (SELECT 1 FROM location WHERE id = 1);

INSERT INTO location ( name, postal_code, address)
SELECT 'XYZ Convention Centre', '90001', 'Main Street, Los Angeles'
    WHERE NOT EXISTS (SELECT 1 FROM location WHERE id = 2);

INSERT INTO location ( name, postal_code, address)
SELECT  'One Avenue', '60601', 'Michigan Avenue, Chicago'
    WHERE NOT EXISTS (SELECT 1 FROM location WHERE id = 3);

INSERT INTO location ( name, postal_code, address)
SELECT  'City Hospital', '77001', 'Texas Street, Houston'
    WHERE NOT EXISTS (SELECT 1 FROM location WHERE id = 4);

INSERT INTO location ( name, postal_code, address)
SELECT  'BYD Hall', '85001', 'Central Avenue, Phoenix'
    WHERE NOT EXISTS (SELECT 1 FROM location WHERE id = 5);

INSERT INTO location ( name, postal_code, address)
SELECT  'UNITEN', '19101', 'Market Street, Philadelphia'
    WHERE NOT EXISTS (SELECT 1 FROM location WHERE id = 6);

INSERT INTO location ( name, postal_code, address)
SELECT  'San Antonio', '78201', 'Alamo Plaza, San Antonio'
    WHERE NOT EXISTS (SELECT 1 FROM location WHERE id = 7);

