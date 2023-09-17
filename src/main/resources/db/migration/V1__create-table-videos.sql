create table videos(
    id bigint not null auto_increment,
    title varchar(200) not null,
    description varchar(500) not null,
    url varchar(1000) not null,
    active tinyint not null,

    primary key(id)
)