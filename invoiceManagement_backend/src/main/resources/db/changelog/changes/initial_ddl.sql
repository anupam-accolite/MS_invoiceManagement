CREATE TABLE IF NOT EXISTS Login
(
   userId character varying primary key, 
   password character varying not null 
);

create table IF NOT EXISTS fglevel
(
	fg integer primary key,
	lower integer,
	upper integer
);
CREATE TABLE IF NOT EXISTS Calendar
(
    month integer primary key,
    msdate date,
    medate date,
    holidays integer
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
CREATE TABLE IF NOT EXISTS Timesheet
(
    timesheetid text primary key,
    workername text,
    timestampend date,
    location text,
    status text,
    sthours numeric,
    othours numeric,
    strate numeric,
    otrate numeric,
    invoiced boolean
);

create table if not exists tfr (
   	projectId INTEGER not null ,
  	workerId character varying not null PRIMARY KEY,
  	status INTEGER not null
);


create table IF NOT EXISTS invoice_mapping(
 invoice_id SERIAL primary key,
 timesheet_id character varying(40),
 paid boolean default false,
 foreign key(timesheet_id) references timesheet(timesheetid)
);