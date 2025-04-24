create table if not exists tokens
(
    id            bigserial primary key,
    access_token  varchar(255) not null,
    refresh_token varchar(255) not null,
    is_logged_out boolean      not null default false,
    user_id       bigint       not null,
    foreign key (user_id) references users (id) on delete cascade
);