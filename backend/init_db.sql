DROP TABLE IF EXISTS categories CASCADE;
CREATE TABLE categories (
    category_id SERIAL PRIMARY KEY,
    category_name VARCHAR(50) UNIQUE NOT NULL,
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
    planned_amount DECIMAL(10,2) NOT NULL,
    due_date VARCHAR(50),
    frequency varchar(20),
    category varchar(20),
    FOREIGN KEY (category) REFERENCES categories (category_name)
);

