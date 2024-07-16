CREATE TABLE topics (
    id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255),
    message TEXT,
    dateOf DATETIME,
    authorName VARCHAR(255),
    courseName VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE users (
   id BIGINT NOT NULL AUTO_INCREMENT,
   name VARCHAR(255),
   email VARCHAR(255),
   password VARCHAR(255),
   PRIMARY KEY (id)
);
