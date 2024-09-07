CREATE TABLE _user (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(100),
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    password VARCHAR(255),
    email VARCHAR(255),
    phone_number VARCHAR(255),
    address VARCHAR(255),
    created_at TIMESTAMP
);

CREATE TABLE cart (
   id BIGSERIAL PRIMARY KEY,
   created_at TIMESTAMP
);

CREATE TABLE bought (
     id BIGSERIAL PRIMARY KEY,
     created_at TIMESTAMP
);

CREATE TABLE wishlist (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP
);

CREATE TABLE product (
     id BIGSERIAL PRIMARY KEY,
     title VARCHAR(255),
     price DOUBLE PRECISION,
     quantity INTEGER,
     soldQte INTEGER,
     brand VARCHAR(255),
     rating VARCHAR(255),
     shortDescription TEXT,
     description TEXT,
     picture BYTEA,
     discountPercentage DOUBLE PRECISION,
     discount BOOLEAN,
     discountStart DATE,
     discountEnd DATE,
     color VARCHAR(255),
     updated_at TIMESTAMP,
     created_at TIMESTAMP
);

CREATE TABLE comment (
    id BIGSERIAL PRIMARY KEY,
    description TEXT,
    created_at TIMESTAMP
);

CREATE TABLE configuration (
    id BIGSERIAL PRIMARY KEY,
    _key VARCHAR(255),
    _value VARCHAR(255),
    created_at TIMESTAMP
);

CREATE TABLE gallery (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    data VARCHAR(255),
    type VARCHAR(255),
    created_at TIMESTAMP
);

CREATE TABLE category (
     id BIGSERIAL PRIMARY KEY,
     name VARCHAR(255),
     picture BYTEA,
     created_at TIMESTAMP
);
