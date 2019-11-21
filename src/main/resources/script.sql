create table user(id bigint not null auto_increment primary key,name varchar(30),email varchar(50),mobile_no int(15));

create table user_group(id bigint not null auto_increment primary key,name varchar(30));

create table group_user_map(id bigint not null auto_increment primary key,user_group_id bigint,user_id bigint);

create table bill(id bigint not null auto_increment primary key,name varchar(30),amount float);

#create table bill_type(id bigint not null auto_increment primary key,bill_id bigint,type varchar(20),type_id bigint);

create table payment_transection(id bigint not null auto_increment primary key,txn_id bigint,bill_id bigint,amount float);

create table txn(id bigint not null auto_increment primary key,bill_id bigint,txn_type char(1),entiry_id bigint,entity_type varchar(30));

