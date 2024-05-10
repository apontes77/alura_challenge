CREATE TABLE course (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    code VARCHAR(10),
    instructor VARCHAR(255),
    description TEXT,
    status VARCHAR(20),
    creation_date DATE,
    inactivation_date DATE
);
