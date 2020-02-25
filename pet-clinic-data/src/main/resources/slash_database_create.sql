create table analysis
(
    id            bigint not null auto_increment,
    conclusions   varchar(255),
    date          datetime,
    description   varchar(255),
    documentation longblob,
    type          varchar(255),
    primary key (id)
) engine = InnoDB;
create table auth_role_id
(
    id        bigint not null auto_increment,
    role_desc varchar(255),
    role_name varchar(255),
    primary key (id)
) engine = InnoDB;
create table auth_user
(
    id         bigint not null auto_increment,
    first_name varchar(255),
    last_name  varchar(255),
    email      varchar(255),
    mobile     varchar(255),
    password   longtext,
    status     varchar(255),
    username   varchar(255),
    primary key (id)
) engine = InnoDB;
create table auth_user_role
(
    auth_user_id bigint not null,
    auth_role_id bigint not null,
    primary key (auth_user_id, auth_role_id)
) engine = InnoDB;
create table cares
(
    id            bigint not null auto_increment,
    admin_cost    double precision,
    hour_cost     double precision,
    product_cost  double precision,
    products      varchar(255),
    specification varchar(255),
    time          double precision,
    totalcost     double precision,
    type          varchar(255),
    primary key (id)
) engine = InnoDB;
create table owners
(
    id         bigint not null auto_increment,
    first_name varchar(255),
    last_name  varchar(255),
    address    varchar(255),
    city       varchar(255),
    telephone  varchar(255),
    primary key (id)
) engine = InnoDB;
create table pets
(
    id         bigint not null auto_increment,
    birth_date date,
    name       varchar(255),
    owner_id   bigint,
    type_id    bigint,
    primary key (id)
) engine = InnoDB;
create table prescriptions
(
    id              bigint           not null auto_increment,
    description     varchar(255),
    number_of_item  double precision not null,
    renewal         bit              not null,
    validity_period double precision not null,
    primary key (id)
) engine = InnoDB;
create table specialties
(
    id          bigint not null auto_increment,
    description varchar(255),
    primary key (id)
) engine = InnoDB;
create table types
(
    id          bigint not null auto_increment,
    name        varchar(255),
    specificity varchar(255),
    primary key (id)
) engine = InnoDB;
create table vet_specialties
(
    vet_id       bigint not null,
    specialty_id bigint not null,
    primary key (vet_id, specialty_id)
) engine = InnoDB;
create table vets
(
    id         bigint not null auto_increment,
    first_name varchar(255),
    last_name  varchar(255),
    primary key (id)
) engine = InnoDB;
create table visits
(
    id                bigint not null auto_increment,
    date              date,
    description       varchar(255),
    small_description varchar(255),
    tag               varchar(255),
    visit_cost        double precision,
    analysis_id       bigint,
    pet_id            bigint,
    prescription_id   bigint,
    vet_id            bigint,
    primary key (id)
) engine = InnoDB;
create table visits_cares
(
    visit_id bigint not null,
    care_id  bigint not null,
    primary key (visit_id, care_id)
) engine = InnoDB;
alter table auth_user_role
    add constraint FKjbtpvr6t6fc3b0knpqxqwnftx foreign key (auth_role_id) references auth_role_id (id);
alter table auth_user_role
    add constraint FKptn1b1vvejcvel3tq402eyl2c foreign key (auth_user_id) references auth_user (id);
alter table pets
    add constraint FK6teg4kcjcnjhduguft56wcfoa foreign key (owner_id) references owners (id);
alter table pets
    add constraint FKtmmh1tq8pah5vxf8kuqqplo4p foreign key (type_id) references types (id);
alter table vet_specialties
    add constraint FK35uiboyrpfn1bndrr5jorcj0m foreign key (specialty_id) references specialties (id);
alter table vet_specialties
    add constraint FKby1c0fbaa0byaifi63vt18sx9 foreign key (vet_id) references vets (id);
alter table visits
    add constraint FKh38tmlb2wi28at53k0nbxmf8i foreign key (analysis_id) references analysis (id);
alter table visits
    add constraint FK6jcifhlqqlsfseu67utlouauy foreign key (pet_id) references pets (id);
alter table visits
    add constraint FKnko1lfu2mrdrxclmfk3xgy5aj foreign key (prescription_id) references prescriptions (id);
alter table visits
    add constraint FK8036qgt84d8h5cckxrj952qoe foreign key (vet_id) references vets (id);
alter table visits_cares
    add constraint FK55gsm5u8tits2vi73tmx8yas1 foreign key (care_id) references cares (id);
alter table visits_cares
    add constraint FK3r140mqyg9t2tatmsafh7eb3 foreign key (visit_id) references visits (id);
