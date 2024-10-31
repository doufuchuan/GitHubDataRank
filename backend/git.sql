CREATE DATABASE githubrank;

USE githubrank;
CREATE TABLE developers (
    id INT PRIMARY KEY,
    github_id VARCHAR(255),
    username VARCHAR(255),
    country VARCHAR(255),
    talent_rank FLOAT,
    domain VARCHAR(255),
    confidence FLOAT
);

CREATE TABLE projects (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    stars INT
);

CREATE TABLE contributions (
    id INT PRIMARY KEY,
    developer_id INT,
    project_id INT,
    commits INT,
    FOREIGN KEY (developer_id) REFERENCES developers(id),
    FOREIGN KEY (project_id) REFERENCES projects(id)
);