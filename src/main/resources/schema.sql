create table if not exists sensor (
    id int primary key generated by default as identity,
    name varchar(30) unique not null
);
create table if not exists measurement (
    id int primary key generated by default as identity,
    value double precision not null,
    raining boolean not null,
    datetime timestamp,
    sensor_id int references sensor
);