/* Creating Users Table */
CREATE TABLE Users (
    user_id INT PRIMARY KEY, full_name VARCHAR(100) NOT NULL, email VARCHAR(100) UNIQUE NOT NULL,
    city VARCHAR(100) NOT NULL, registration_date DATE NOT NULL
);

/* Inserting into Users Table */
INSERT INTO Users VALUES
(1,'Arjun Kumar','arjun@gmail.com','Hyderabad','2025-05-10'),
(2,'Akhil Reddy','akhil@gmail.com','Hyderabad','2025-05-15'),
(3,'Priya Sharma','priya@gmail.com','Chennai','2025-04-20'),
(4,'Ananya Singh','ananya@gmail.com','Bangalore','2025-05-25'),
(5,'Rahul Verma','rahul@gmail.com','Mumbai','2025-03-18'),
(6,'Kiran Rao','kiran@gmail.com','Hyderabad','2025-05-30'),
(7,'Sneha Patel','sneha@gmail.com','Chennai','2025-05-05'),
(8,'Ajay Kumar','ajay@gmail.com','Hyderabad','2025-05-28');

/* Creating Events Table */
CREATE TABLE Events (
    event_id INT PRIMARY KEY, title VARCHAR(200) NOT NULL, description TEXT, city VARCHAR(100) NOT NULL,
    start_date DATETIME NOT NULL, end_date DATETIME NOT NULL, status ENUM('upcoming','completed','cancelled'),
    organizer_id INT, FOREIGN KEY (organizer_id) REFERENCES Users(user_id)
);

/* Inserting into Events Table */
INSERT INTO Events VALUES
(1,'Tech Meetup','Technology Event','Hyderabad','2025-06-15 09:00:00','2025-06-15 18:00:00','upcoming',1),
(2,'AI Conference','Artificial Intelligence','Bangalore','2025-05-01 09:00:00','2025-05-04 18:00:00','completed',4),
(3,'Startup Summit','Business Event','Hyderabad','2025-06-20 10:00:00','2025-06-23 17:00:00','upcoming',2),
(4,'Music Fest','Entertainment Event','Mumbai','2025-04-10 08:00:00','2025-04-10 22:00:00','completed',5),
(5,'Coding Challenge','Programming Contest','Chennai','2025-05-12 09:00:00','2025-05-14 18:00:00','completed',3);

/* Queries on Users table */
/* 1 */
SELECT * FROM Users WHERE registration_date >= CURDATE() - INTERVAL 30 DAY;

/* 2 */
SELECT * FROM Users ORDER BY registration_date;

/* 3 */
SELECT city, COUNT(*) AS total_users FROM Users GROUP BY city;

/* 4 */
SELECT city, COUNT(*) AS total_users FROM Users GROUP BY city HAVING COUNT(*) > 5;

/* 5 */
SELECT * FROM Users WHERE full_name LIKE 'A%';

/* 6 */
SELECT city, COUNT(*) AS frequency FROM Users GROUP BY city HAVING COUNT(*) > 1;

/* 7 */
SELECT * FROM Users WHERE DAYOFWEEK(registration_date) IN (1,7);

/* 8 */
SELECT * FROM Users ORDER BY registration_date ASC LIMIT 1;

/* 9 */
SELECT YEAR(registration_date) AS year,MONTH(registration_date) AS month, COUNT(*) AS total_users FROM Users
GROUP BY YEAR(registration_date),MONTH(registration_date);

/* Queries on Events Table */
/* 1 */
SELECT e.event_id,e.title,u.full_name AS organizer_name FROM Events e JOIN Users u ON e.organizer_id = u.user_id;

/* 2 */
SELECT * FROM Events WHERE status = 'upcoming';

/* 3 */
SELECT city, COUNT(*) AS total_events FROM Events GROUP BY city;

/* 4 */
SELECT * FROM Events WHERE DATEDIFF(end_date, start_date) > 2;

/* 5 */
SELECT e.event_id,e.title,u.full_name,u.city FROM Events e JOIN Users u ON e.organizer_id = u.user_id
WHERE e.status = 'completed' AND u.city = 'Hyderabad';