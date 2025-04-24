create table if not exists rooms
(
    id          bigserial primary key,
    room_number varchar(255) unique not null,
    room_type   varchar(255)        not null,
    amount      integer             not null check ( amount >= 0 ),
    price       decimal(10, 2)      not null check ( price >= 0 ),
    description varchar(255)        not null,
    status      varchar(255)        not null default 'AVAILABLE'
);