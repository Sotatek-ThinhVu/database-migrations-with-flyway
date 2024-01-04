CREATE TABLE IF NOT EXISTS users
(
    id serial primary key,
    fullname varchar(255) not null,
    age bigint not null,
    address varchar(255) not null
);