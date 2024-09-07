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
   created_at TIMESTAMP,
   user_id BIGSERIAL,
   CONSTRAINT fk_user_cart FOREIGN KEY (user_id) REFERENCES _user(id)
);

CREATE TABLE bought (
     id BIGSERIAL PRIMARY KEY,
     created_at TIMESTAMP,
     user_id BIGSERIAL,
     CONSTRAINT fk_user_bought FOREIGN KEY (user_id) REFERENCES _user(id)
);

CREATE TABLE wishlist (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP,
    user_id BIGSERIAL,
    CONSTRAINT fk_user_wishlist FOREIGN KEY (user_id) REFERENCES _user(id)
);

CREATE TABLE category (
     id BIGSERIAL PRIMARY KEY,
     name VARCHAR(255),
     picture BYTEA,
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
     created_at TIMESTAMP,
     category_id BIGSERIAL,
     CONSTRAINT fk_category_product FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE comment (
    id BIGSERIAL PRIMARY KEY,
    description TEXT,
    created_at TIMESTAMP,
    product_id BIGSERIAL,
    CONSTRAINT fk_product_comment FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE configuration (
    id BIGSERIAL PRIMARY KEY,
    _key VARCHAR(255),
    _value VARCHAR(255),
    created_at TIMESTAMP,
    product_id BIGSERIAL,
    CONSTRAINT fk_product_configuration FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE gallery (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    data VARCHAR(255),
    type VARCHAR(255),
    created_at TIMESTAMP,
    product_id BIGSERIAL,
    CONSTRAINT fk_product_gallery FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE product_bought (
     product_id BIGSERIAL,
     bought_id BIGSERIAL,
     CONSTRAINT fk_product_bought FOREIGN KEY (product_id) REFERENCES product(id),
     CONSTRAINT fk_bought_product FOREIGN KEY (bought_id) REFERENCES bought(id)

);

CREATE TABLE product_wishlist (
     product_id BIGSERIAL,
     wishlist_id BIGSERIAL,
     CONSTRAINT fk_product_wishlist FOREIGN KEY (product_id) REFERENCES product(id),
     CONSTRAINT fk_wishlist_product FOREIGN KEY (wishlist_id) REFERENCES wishlist(id)

);

CREATE TABLE product_cart (
     product_id BIGSERIAL,
     cart_id BIGSERIAL,
     CONSTRAINT fk_product_cart FOREIGN KEY (product_id) REFERENCES product(id),
     CONSTRAINT fk_cart_product FOREIGN KEY (cart_id) REFERENCES cart(id)

);

