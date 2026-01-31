ALTER TABLE category
    ADD count_of_products INT NULL;

ALTER TABLE category
    MODIFY count_of_products INT NOT NULL;

ALTER TABLE category
    ADD CONSTRAINT uc_category_category_name UNIQUE (category_name);

ALTER TABLE category
    MODIFY category_name VARCHAR(255) NOT NULL;