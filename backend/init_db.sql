DROP TABLE IF EXISTS account CASCADE;
CREATE TABLE account (
    id SERIAL PRIMARY KEY,
    description VARCHAR(50) UNIQUE NOT NULL,
    type VARCHAR(20)
);
INSERT INTO account (description, type) VALUES
   ('Usaa Checking', 'CHECKING'),
   ('Usaa Savings', 'SAVINGS'),
   ('AMAZON', 'CREDIT_CARD');

DROP TABLE IF EXISTS category CASCADE;
CREATE TABLE category (
    id SERIAL PRIMARY KEY,
    name VARCHAR(20) UNIQUE NOT NULL
);
INSERT INTO category (name) VALUES
  ('Uncategorized'),
  ('Housing'),
  ('Transportation'),
  ('Lifestyle'),
  ('Savings'),
  ('Bills'),
  ('Debt');

DROP TABLE IF EXISTS line_item;
CREATE TABLE line_item (
    id SERIAL PRIMARY KEY,
    description VARCHAR(50) UNIQUE NOT NULL,
    planned_amount DECIMAL(10,2) NOT NULL DEFAULT 0,
    next_due TIMESTAMP,
    frequency VARCHAR(20),
    auto_pay BOOLEAN,
    account_id INTEGER,
    category_id INTEGER,
    updated_at TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES account (id),
    FOREIGN KEY (category_id) REFERENCES category (id)
);
INSERT INTO line_item (description, planned_amount, next_due, frequency, auto_pay, account_id, category_id) VALUES
('LineItem1', 500.25, '2024-09-08 14:30:00', 'MONTHLY', TRUE, 1, 1),
('LineItem2', 125.40, '2024-09-19 15:30:00', 'ANNUALLY', FALSE, 2, 2),
('LineItem3', 878.25, '2024-09-24 16:30:00', 'QUARTERLY', TRUE, 3, 3);

