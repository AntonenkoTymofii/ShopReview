create table "hibernate_sequence" (
    next_val bigint
);

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

create table "User"(
    id BIGINT PRIMARY KEY NOT NULL,
    hash CHAR(60) NOT NULL,
    firstname VARCHAR(120) NOT NULL,
    lastname VARCHAR(120),
    email VARCHAR(120) NOT NULL UNIQUE,
    phone CHAR(12) UNIQUE
);

create table "Category"(
    id BIGINT PRIMARY KEY NOT NULL,
    name CHAR(120) NOT NULL UNIQUE
);

create table "Product"(
    id BIGINT PRIMARY KEY NOT NULL,
    id_category BIGINT REFERENCES "Category"(id) NOT NULL,
    name VARCHAR(120) NOT NULL,
    price FLOAT NOT NULL
);

create table "Shop"(
    id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(120) NOT NULL UNIQUE,
    address VARCHAR(120) NOT NULL,
    quantity INT NOT NULL
);

create table "ProductShop"(
    id BIGINT PRIMARY KEY NOT NULL,
    id_product BIGINT REFERENCES "Product"(id) NOT NULL,
    id_shop BIGINT REFERENCES "Shop"(id) NOT NULL
);

create table "Purchase"(
    id BIGINT PRIMARY KEY NOT NULL,
    id_product BIGINT REFERENCES "Product"(id) NOT NULL,
    id_shop BIGINT REFERENCES "Shop"(id) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    quantity INT NOT NULL,
    date DATE NOT NULL
);

create table "UserPurchase"(
    id BIGINT PRIMARY KEY NOT NULL,
    id_user BIGINT REFERENCES "User"(id) NOT NULL,
    id_purchase BIGINT REFERENCES "Purchase"(id) NOT NULL
);
