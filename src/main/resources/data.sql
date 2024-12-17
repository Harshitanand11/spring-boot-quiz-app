---- Seed the database with some sample data
--CREATE TABLE QUESTION (
--    id BIGINT AUTO_INCREMENT PRIMARY KEY,
--    questionText VARCHAR(255),
--    correctAnswer VARCHAR(255),
--    options VARCHAR(255)
--);
--
--INSERT INTO QUESTION (questionText, correctAnswer, options)
--VALUES ('What is 2 + 2?', '4', 'Option A, Option B, Option C, Option D'),
--       ('What is the capital of France?', 'Paris', 'Option A, Option B, Option C, Option D');
-- Create the QUESTION table
CREATE TABLE QUESTION (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    questionText VARCHAR(255) NOT NULL,
    correctAnswer VARCHAR(255) NOT NULL,
    options VARCHAR(255) NOT NULL
);

-- Insert sample data into the QUESTION table
INSERT INTO QUESTION (questionText, correctAnswer, options)
VALUES
('What is 2 + 2?', '4', 'Option A: 1, Option B: 2, Option C: 3, Option D: 4'),
('What is the capital of France?', 'Paris', 'Option A: London, Option B: Paris, Option C: Berlin, Option D: Madrid');
