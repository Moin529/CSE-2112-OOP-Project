create database travelmanagementsystem;

show databases;

use travelmanagementsystem;

create table account(username varchar(20), name varchar(40), password varchar(20), phone varchar(14), email varchar(30));

show tables;

select * from account;

create table customer(username varchar(20), id varchar(30), number varchar(40), name varchar(40), gender varchar(10), country varchar(30), address varchar(60), phone varchar(15), email varchar(30));

select * from customer;

create table bookpackage(username varchar(20), package varchar(30), person varchar(20), id varchar(30), number varchar(40), phone varchar(15), price varchar(20));

select * from bookpackage;

create table hotel(name varchar(40), costperperson varchar(20), acroom varchar(10), foodincluded varchar(10));

insert into hotel values('Atlantis Hotel', '3400', '1000', '1700');
insert into hotel values('Sea Pearl Hotel', '3000', '1500', '1200');
insert into hotel values('Four Seasons Hotel', '5000', '2100', '1600');
insert into hotel values('Raddisson Blue Hotel', '4400', '1200', '1800');
insert into hotel values('Hotel Haven', '4000', '1300', '1000');
insert into hotel values('The Bay Club Hotel', '4500', '2000', '1400');
insert into hotel values('Breeze Blow Hotel', '3300', '1100', '1700');
insert into hotel values('Grand Hotel', '3800', '1600', '1200');
insert into hotel values('Dream Hotel', '5000', '2200', '2000');
insert into hotel values('River View Hotel', '4700', '1900', '1900');

select * from hotel;

create table bookhotel(username varchar(20), name varchar(40), person varchar(20), days varchar(10), ac varchar(10), food varchar(10), id varchar(30), number varchar(40), phone varchar(15), price varchar(20));

select * from bookhotel;

