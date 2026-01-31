CREATE TABLE category
(
    id              BIGINT       NOT NULL AUTO_INCREMENT,
    created_at      datetime     NULL,
    last_updated_at datetime     NULL,
    is_deleted      BIT(1)       NOT NULL,
    category_name            VARCHAR(255) NULL,
    `description`   VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE category_featured_products
(
    category_id          BIGINT NOT NULL ,
    featured_products_id BIGINT NOT NULL
);

CREATE TABLE product_model
(
    id              BIGINT       NOT NULL AUTO_INCREMENT,
    created_at      datetime     NULL,
    last_updated_at datetime     NULL,
    is_deleted      BIT(1)       NOT NULL,
    title           VARCHAR(255) NULL,
    `description`   VARCHAR(255) NULL,
    price           DOUBLE       NULL,
    category_id     BIGINT       NULL,
    imageurl        VARCHAR(255) NULL,
    CONSTRAINT pk_productmodel PRIMARY KEY (id)
);

ALTER TABLE category_featured_products
    ADD CONSTRAINT uc_category_featured_products_featuredproducts UNIQUE (featured_products_id);

ALTER TABLE product_model
    ADD CONSTRAINT FK_PRODUCTMODEL_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE category_featured_products
    ADD CONSTRAINT fk_catfeapro_on_category FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE category_featured_products
    ADD CONSTRAINT fk_catfeapro_on_product_model FOREIGN KEY (featured_products_id) REFERENCES product_model (id);