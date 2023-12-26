create table if not exists "ShopReviewDB"."public"."hibernate_sequence" (
    next_val bigint
);

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

create table if not exists "ShopReviewDB"."public"."users"(
    id BIGINT PRIMARY KEY NOT NULL,
    hash CHAR(60) NOT NULL,
    firstname VARCHAR(120) NOT NULL,
    lastname VARCHAR(120),
    email VARCHAR(120) NOT NULL UNIQUE,
    phone CHAR(12) UNIQUE
);

create table if not exists "ShopReviewDB"."public"."category"(
    id BIGINT PRIMARY KEY NOT NULL,
    name CHAR(120) NOT NULL UNIQUE
);

create table if not exists "ShopReviewDB"."public"."product"(
    id BIGINT PRIMARY KEY NOT NULL,
    id_category BIGINT REFERENCES "category"(id) NOT NULL,
    name VARCHAR(120) NOT NULL,
    price FLOAT NOT NULL
);

create table if not exists "ShopReviewDB"."public"."shop"(
    id BIGINT PRIMARY KEY NOT NULL,
    name VARCHAR(120) NOT NULL UNIQUE,
    address VARCHAR(120) NOT NULL,
    quantity INT NOT NULL
);

create table if not exists "ShopReviewDB"."public"."productShop"(
    id BIGINT PRIMARY KEY NOT NULL,
    id_product BIGINT REFERENCES "product"(id) NOT NULL,
    id_shop BIGINT REFERENCES "shop"(id) NOT NULL
);

create table if not exists "ShopReviewDB"."public"."purchase"(
    id BIGINT PRIMARY KEY NOT NULL,
    id_product BIGINT REFERENCES "product"(id) NOT NULL,
    id_shop BIGINT REFERENCES "shop"(id) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    quantity INT NOT NULL,
    date DATE NOT NULL
);

create table if not exists "ShopReviewDB"."public"."userPurchase"(
    id BIGINT PRIMARY KEY NOT NULL,
    id_user BIGINT REFERENCES "users"(id) NOT NULL,
    id_purchase BIGINT REFERENCES "purchase"(id) NOT NULL
);
