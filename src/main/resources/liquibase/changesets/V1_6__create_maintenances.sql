create table if not exists maintenances
(
    id    bigserial primary key,
    name  varchar(255)   not null,
    price decimal(10, 2) not null
);