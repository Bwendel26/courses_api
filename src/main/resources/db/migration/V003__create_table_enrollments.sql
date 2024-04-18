CREATE TABLE IF NOT EXISTS enrollments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    course_id INT NOT NULL,
    enrollment_date DATETIME NOT NULL,
    CONSTRAINT fk_users FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT fk_courses FOREIGN KEY (course_id) REFERENCES courses(course_id),
    CONSTRAINT uc_user_course UNIQUE (user_id, course_id)
);