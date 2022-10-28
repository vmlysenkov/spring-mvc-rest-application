DROP TABLE IF EXISTS contact;
CREATE TABLE IF NOT EXISTS contact
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(32) NOT NULL,
    phoneNumber VARCHAR(32) NOT NULL
);

INSERT INTO contact(phonenumber)
VALUES ('12345');