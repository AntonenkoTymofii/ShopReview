create table if not exists "ShopReviewDB"."public"."productCategory"(
        id BIGINT PRIMARY KEY NOT NULL,
        id_product BIGINT REFERENCES "product"(id) NOT NULL,
        id_category BIGINT REFERENCES "category"(id) NOT NULL
);