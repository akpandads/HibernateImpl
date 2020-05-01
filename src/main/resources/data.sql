/*create table Person(
id integer not null ,
name varchar(255) not null,
location varchar(255) ,
birth_date timestamp ,
primary key(id)
);*/
--Above not required for jpa

insert into person (id,name,location,birth_date) values (1001,'ranga','mars',sysdate);
insert into person (id,name,location,birth_date) values (1002,'james','earth',sysdate);
insert into person (id,name,location,birth_date) values (1003,'peter','version',sysdate);
