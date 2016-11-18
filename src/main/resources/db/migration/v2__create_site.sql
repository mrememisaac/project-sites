CREATE TABLE site (
 id bigserial,
 name varchar(255) not null,
 description varchar(500) not null,
 condition varchar(100) not null,
 latitude double precision not null,
 longtitude double precision not null,
 yearStarted int not null,
 PRIMARY KEY (id)
);