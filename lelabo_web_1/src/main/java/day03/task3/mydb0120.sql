drop database if exists mydb0121;
create database mydb0121;
use mydb0121;
create  table visit(
num int auto_increment ,
cotent longtext ,
age int ,
constraint primary key(num)
);