create SEQUENCE project_id_seq START WITH 1 INCREMENT BY 1;
create SEQUENCE task_id_seq START WITH 1 INCREMENT BY 1;

create table project(
    project_id bigint primary key default nextval('project_id_seq'),
    name varchar(100) not null CHECK (char_length(name) BETWEEN 3 AND 100),
    description TEXT,
    start_date timestamp not null,
    end_date timestamp
);

create table task(
    task_id int primary key default nextval('task_id_seq'),
    title varchar(150) not null CHECK (char_length(title) BETWEEN 5 AND 150),
    description TEXT,
    status varchar(50),
    priority varchar(50),
    due_date timestamp not null,
    project_id_fk int REFERENCES project (project_id)
);