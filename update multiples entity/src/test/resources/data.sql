insert into company (id, name, size)
values (1, 'SG', 10);
insert into company (id, name, size)
values (2, 'Apple', 100);
insert into company (id, name, size)
values (3, 'Microsoft', 1000);
insert into company (id, name, size)
values (4, 'Google', 10000);

insert into owner (id, name, not_updated, company_id)
VALUES (1, 'myself', 'DO NOT UPDATE THESE FIELD', 1);
insert into owner (id, name, not_updated, company_id)
VALUES (2, 'QUENTIN', 'DO NOT UPDATE THESE FIELD', 2);
insert into owner (id, name, not_updated, company_id)
VALUES (3, 'JP', 'DO NOT UPDATE THESE FIELD', 3);
insert into owner (id, name, not_updated, company_id)
VALUES (4, 'DIVYA', 'DO NOT UPDATE THESE FIELD', 4);

insert into item(id, name, item_value, owner_id)
VALUES (1, 'first item', 10.0, 1);
insert into item(id, name, item_value, owner_id)
VALUES (2, 'second item', 10.0, 1);
insert into item(id, name, item_value, owner_id)
VALUES (3, 'third item', 10.0, 1);
insert into item(id, name, item_value, owner_id)
VALUES (4, 'fourth item', 10.0, 1);
insert into item(id, name, item_value, owner_id)
VALUES (5, 'fifth item', 10.0, 1);
insert into item(id, name, item_value, owner_id)
VALUES (6, 'sixth item', 10.0, 1);