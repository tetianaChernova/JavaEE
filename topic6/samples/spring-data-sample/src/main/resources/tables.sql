CREATE TABLE users
(
    id         INT(11) PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    email      VARCHAR(50) NULL
);

CREATE TABLE apartment
(
    id     INT(11) PRIMARY KEY AUTO_INCREMENT,
    number VARCHAR(50) NOT NULL
);

CREATE TABLE billing
(
    apartment_id INT(11)        NOT NULL,
    period_date  DATE           NOT NULL,
    bill         DECIMAL(10, 2) NOT NULL,
    CONSTRAINT fk_billing_to_apartment FOREIGN KEY (apartment_id) REFERENCES apartment (id)
);