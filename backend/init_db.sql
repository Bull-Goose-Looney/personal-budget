DROP TABLE IF EXISTS categories CASCADE;
CREATE TABLE categories (
    category_id SERIAL PRIMARY KEY,
    category_name VARCHAR(20) UNIQUE NOT NULL,
    category_description VARCHAR(255)
);

INSERT INTO categories (category_name, category_description) VALUES 
  ('Uncategorized', 'Default category'),
  ('Housing', 'Default category'),
  ('Transportation', 'Default category'),
  ('Lifestyle', 'Default category'),
  ('Savings', 'Default category'),
  ('Bills', 'Default category'),
  ('Debt', 'Default category'); 

DROP TABLE IF EXISTS line_items;
CREATE TABLE line_items (
    line_item_id SERIAL PRIMARY KEY,
    line_item_name VARCHAR(50) UNIQUE NOT NULL,
    description VARCHAR(50),
    planned_amount DECIMAL(10,2) NOT NULL DEFAULT 0,
    actual_amount DECIMAL(10,2) NOT NULL DEFAULT 0,
    due_date VARCHAR(50),
    frequency VARCHAR(20),
    category VARCHAR(20),
    parent_id BIGINT,
    updated_at TIMESTAMP,
    FOREIGN KEY (category) REFERENCES categories (category_name)
);

-- Insert sample data into line_items table
INSERT INTO line_items (line_item_name, description, planned_amount, actual_amount, due_date, frequency, category) VALUES
('Sample Mortgage', 'This is a sample mortgage', 500.25, 300.78, 'DAY_3', 'MONTHLY', 'Housing', null, null),
('Sample Income', 'This is a sample income', 10000.12, 12.18, 'FRIDAY', 'WEEKLY', 'Savings', null, null),
('Sample Savings', 'This is a sample savings', 500.25, 300.78, 'DAY_3', 'MONTHLY', 'Lifestyle', null, null),
('Sample Vehicle Reg', 'This is a sample savings', 500.25, 300.78, 'JANUARY', 'YEARLY', 'Transportation', null, null),

('Composite Item', 'This is a sample savings', 500.25, 300.78, 'DAY_3', 'MONTHLY', 'Lifestyle', null, null),

('child 1', 'This is a sample savings', 500.25, 300.78, 'DAY_3', 'MONTHLY', 'Lifestyle', 4, null),
('child 2', 'This is a sample savings', 500.25, 300.78, 'DAY_3', 'MONTHLY', 'Lifestyle', 4, null);


-- Drop transactions table if it exists
DROP TABLE IF EXISTS transactions CASCADE;

-- Drop accounts table if it exists
DROP TABLE IF EXISTS accounts CASCADE;

-- Create accounts table
CREATE TABLE accounts (
    account_number BIGINT PRIMARY KEY,
    account_name VARCHAR(255) NOT NULL,
    account_type VARCHAR(50) NOT NULL
);

-- Create transactions table
CREATE TABLE transactions (
    transaction_id BIGINT PRIMARY KEY,
    transaction_amount DECIMAL(10, 2) NOT NULL,
    account_number BIGINT NOT NULL,
    FOREIGN KEY (account_number) REFERENCES accounts (account_number) ON DELETE CASCADE
);
