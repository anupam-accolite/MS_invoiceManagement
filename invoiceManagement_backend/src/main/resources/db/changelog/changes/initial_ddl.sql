create table login(
	userid character varying(20),
	password character varying(20),
	primary key (userid)
);

create table timesheet(
	timesheetid text primary key,
    workername text,
    timestampend date,
    location text,
    status text,
    sthours numeric,
    othours numeric,
    strate numeric,
    otrate numeric,
    invoiced boolean default false
);

create table invoice_mapping(
	invoice_id SERIAL primary key,
 	timesheet_id character varying(40),
 	paid boolean default false,
 	foreign key(timesheet_id) references timesheet(timesheetid)
);

CREATE TABLE IF NOT EXISTS tfr
(
  	projectId INTEGER not null ,
  	workerId character varying not null PRIMARY KEY,
  	status INTEGER not null
);

create table IF NOT EXISTS fglevel(
 	fg int primary key,
 	lower int,
 	upper int
);

CREATE TABLE IF NOT EXISTS Worker
(
    eid text NOT NULL primary key,
    sdate date,
    edate date,
    status text,
    rate numeric default 1.0,
    location text,
    experience integer,
    fg integer,
    ason date,
    foreign key(fg) references fglevel(fg)
);