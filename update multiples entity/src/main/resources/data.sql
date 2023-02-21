CREATE TABLE if not exists company
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR(255),
    size INT                                     NOT NULL,
    CONSTRAINT pk_company PRIMARY KEY (id)
);

CREATE TABLE if not exists item
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name       VARCHAR(255),
    item_value DOUBLE PRECISION,
    owner_id   BIGINT,
    CONSTRAINT pk_objects PRIMARY KEY (id)
);

CREATE TABLE if not exists owner
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name       VARCHAR(255),
    not_updated VARCHAR(255),
    company_id BIGINT,
    CONSTRAINT pk_owner PRIMARY KEY (id)
);


ALTER TABLE owner
    ADD CONSTRAINT FK_OWNER_ON_COMPANY FOREIGN KEY (company_id) REFERENCES company (id);

ALTER TABLE item
    ADD CONSTRAINT FK_ITEM_ON_OWNER FOREIGN KEY (owner_id) REFERENCES owner (id);