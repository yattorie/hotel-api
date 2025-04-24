create table if not exists employees
(
    id             bigserial primary key,
    first_name     varchar(255)       not null,
    last_name      varchar(255)       not null,
    middle_name    varchar(255),
    position       varchar(255)       not null,
    salary         decimal(10, 2)     not null check ( salary >= 0 ),
    phone_employee varchar(20) unique not null
);