CREATE TABLE if not exists item_entity
(
    id             BIGINT       NOT NULL,
    property_one   VARCHAR(255) NULL,
    property_two   VARCHAR(255) NULL,
    property_three VARCHAR(255) NULL,
    property_four  VARCHAR(255) NULL,
    property_five  VARCHAR(255) NULL,
    property_six   VARCHAR(255) NULL,
    property_seven VARCHAR(255) NULL,
    CONSTRAINT pk_itementity PRIMARY KEY (id)
);