CREATE TABLE IF NOT EXISTS courses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL UNIQUE,
    instructor VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    status VARCHAR(20) NOT NULL,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    inactivation_date TIMESTAMP NULL,
    CONSTRAINT check_code_format CHECK (code NOT LIKE '%[0-9]%') -- Checks that the code does not contain numeric characters
);

