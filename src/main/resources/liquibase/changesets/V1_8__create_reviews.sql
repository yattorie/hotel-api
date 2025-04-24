create table if not exists reviews
(
    id         bigserial primary key,
    comment    varchar(255) not null,
    rating     integer      not null check ( rating between 1 and 5),
    created_at timestamp    not null default current_timestamp,
    user_id    bigint       not null,
    room_id    bigint       not null,
    foreign key (user_id) references users (id) on delete cascade,
    foreign key (room_id) references rooms (id) on delete cascade
);