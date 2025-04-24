create table if not exists bookings
(
    id         bigserial primary key,
    start_date date   not null,
    end_date   date   not null,
    user_id    bigint not null,
    room_id    bigint not null,
    foreign key (user_id) references users (id) on delete cascade,
    foreign key (room_id) references rooms (id) on delete cascade
);