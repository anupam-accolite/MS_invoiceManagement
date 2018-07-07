CREATE TABLE IF NOT EXISTS SampleTable
(
   name character varying not null
);

CREATE TABLE IF NOT EXISTS Login
(
   userId character varying not null primary key,
   password character varying not null
);