CREATE TABLE IF NOT EXISTS course_reviews (
    id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    user_id INT NOT NULL,
    rating INT NOT NULL,
    feedback TEXT,
    CONSTRAINT fk_course_reviews_course FOREIGN KEY (course_id) REFERENCES courses(course_id),
    CONSTRAINT fk_course_reviews_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);