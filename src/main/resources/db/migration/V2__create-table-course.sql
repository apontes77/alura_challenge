CREATE TABLE course_tb (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    code VARCHAR(10) unique,
    instructor VARCHAR(255),
    description TEXT,
    status VARCHAR(20) NOT NULL,
    creation_date DATE,
    inactivation_date DATE
);
