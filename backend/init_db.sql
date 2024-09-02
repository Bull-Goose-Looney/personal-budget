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
    name VARCHAR(50) UNIQUE NOT NULL,
    planned_amount DECIMAL(10,2) NOT NULL DEFAULT 0,
    actual_amount DECIMAL(10,2) NOT NULL DEFAULT 0,
    due_date VARCHAR(50),
    frequency VARCHAR(20),
    category_id INTEGER,
    updated_at TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES category (id)
);
INSERT INTO line_item (name, planned_amount, actual_amount, due_date, frequency, category_id) VALUES
('Sample Mortgage', 500.25, 300.78, 'DAY_3', 'MONTHLY', 1),
('Sample Income', 10000.12, 12.18, 'FRIDAY', 'WEEKLY', 1),
('Sample Savings', 500.25, 300.78, 'DAY_3', 'MONTHLY', 2),
('Sample Vehicle Reg', 500.25, 300.78, 'JANUARY', 'ANNUALLY', 3),
('Composite Item', 500.25, 300.78, 'DAY_3', 'MONTHLY', 4),
('child 1', 500.25, 300.78, 'DAY_3', 'MONTHLY', 5),
('child 2', 500.25, 300.78, 'DAY_3', 'MONTHLY', 6);

