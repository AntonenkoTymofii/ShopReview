ALTER TABLE purchase DROP COLUMN id_product;

create table if not exists "ShopReviewDB"."public"."purchaseProduct"(
        id BIGINT PRIMARY KEY NOT NULL,
        id_purchase BIGINT REFERENCES "purchase"(id) NOT NULL,
        id_product BIGINT REFERENCES "product"(id) NOT NULL
);