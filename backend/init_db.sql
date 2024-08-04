-- Create a table for users
-- Think about the concept of planning. This could have fields like
-- planned_amount
-- in_progress_amount
-- ...
CREATE TABLE IF NOT EXISTS line_items (
    line_item_id SERIAL PRIMARY KEY,
    line_item_name VARCHAR(50) UNIQUE NOT NULL,
    description VARCHAR(50),
    planned_amount DECIMAL(10,2) NOT NULL,
    due_date VARCHAR(50),
    frequency varchar(20),
    category varchar(20),
    FOREIGN KEY (category) REFERENCES categories (name)
);

-- Create a table for transactions
-- CREATE TABLE IF NOT EXISTS transactions (
--     id SERIAL PRIMARY KEY,
--     amount DECIMAL(10,2) NOT NULL,
--     description TEXT,
--     category VARCHAR(50),
--     FOREIGN KEY (category) REFERENCES categories (name)
-- );

-- Create a table for categories
CREATE TABLE IF NOT EXISTS categories (
    category_id SERIAL PRIMARY KEY,
    category_name VARCHAR(50) UNIQUE NOT NULL
);

INSERT INTO categories (name) VALUES 
    ('Uncategorized'),
    ('Housing'),
    ('Transportation'),
    ('Lifestyle'),
    ('Savings'),
    ('Bills'),
    ('Debt');
