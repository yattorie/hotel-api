create table if not exists inventories
(
    id        bigserial primary key,
    name      varchar(255) not null,
    quantity  integer      not null,
    condition varchar(100) not null
);