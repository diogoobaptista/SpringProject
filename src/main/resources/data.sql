CREATE TABLE employees
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    company_position VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    company_years INT NOT NULL,
    salary numeric(18, 2) NOT NULL,

    PRIMARY KEY (id)
);