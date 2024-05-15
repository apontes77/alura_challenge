CREATE TABLE course_evaluation_tb (
 id INT PRIMARY KEY AUTO_INCREMENT,
 course_id INT NOT NULL,
 grade INT NOT NULL,
 grade_explanation_subject TEXT,
 grade_explanation_body TEXT
);