
-- schema bd 1

drop table aPrTransmission;
drop table transmission ;
drop table virus;

create table virus (
acronyme varchar(5),
nom_v varchar(20),
type_genome varchar(3),
famille_v varchar(18), constraint v_pk primary key (acronyme));

create table transmission (
mode_t varchar(20), constraint t_pk primary key (mode_t));

create table aPrTransmission (
acronyme_v varchar(5), mode_t varchar(20),
constraint vt_pk primary key (acronyme_v, mode_t),
constraint fk1_vt foreign key (acronyme_v) references virus (acronyme),
constraint fk2_vt foreign key (mode_t) references transmission(mode_t));



-- Table Virus
insert into Virus values ('HAV', 'Hepatitis A Virus', 'ARN', 'Picornaviridae');
insert into  Virus values ('HBV','Hepatitis B Virus',  'ADN', 'Hepadnanaviridae');
insert into Virus values ('HCV', 'Hepatitis C Virus', 'ARN', 'Flaviviridae');
insert into Virus values ('DENV', 'Dengue Virus','ARN', 'Flaviviridae');
insert into Virus values ('YFV', 'Yellow Fever Virus','ARN', 'Flaviviridae');
insert into Virus values ('WNV', 'West Nile Virus','ARN', 'Flaviviridae');
insert into Virus values ('FLUAV', 'Influenza A Virus', 'ARN', 'Orthomyxoviridae');

-- Table Transmission
insert into Transmission values ('voie aerienne');
insert into Transmission values ('voie sexuelle');
insert into Transmission values ('voie sanguine');
insert into Transmission values ('in utero');
insert into Transmission values ('voie digestive');
insert into Transmission values ('voie transcutanee');


-- Table Virus_Transmission
insert into aPrTransmission values ('FLUAV', 'voie aerienne');
insert into aPrTransmission values ('YFV', 'voie transcutanee');
insert into aPrTransmission values ('WNV', 'voie transcutanee');
insert into aPrTransmission values ('HCV', 'voie sanguine');
insert into aPrTransmission values ('HCV', 'voie transcutanee');
insert into aPrTransmission values ('HCV', 'voie sexuelle');
insert into aPrTransmission values ('HAV', 'voie digestive');
insert into aPrTransmission values ('HBV', 'voie sanguine');
insert into aPrTransmission values ('DENV', 'voie transcutanee');

commit;

-- schema bd 2
drop table APrOrigine;
drop table Facteur;
drop table Maladie;

create table Facteur (
acro_facteur varchar(16),
nom_f varchar(26),
type_facteur varchar(15) check (type_facteur in ('Virus','Bacterie')),
constraint fact_pk primary key (acro_facteur));

create table Maladie (
nom_m varchar(20),
definition varchar(20),
constraint mal_pk primary key (nom_m));

create table AprOrigine (
nom_m varchar(20),
acro_facteur varchar(16),
souche varchar(5),
constraint apo_pk primary key (nom_m, acro_facteur, souche),
constraint apof1_k foreign key (nom_m) references maladie(nom_m),
constraint apof2_k foreign key (acro_facteur) references facteur(acro_facteur));


insert into Facteur values ('HAV', 'Hepatitis A Virus', 'Virus');
insert into Facteur values ('HBV', 'Hepatitis B Virus', 'Virus');
insert into Facteur values ('HCV', 'Hepatitis C Virus', 'Virus');
insert into Facteur values ('DENV', 'Dengue Virus', 'Virus');
insert into Facteur values ('YFV', 'Yellow Fever Virus', 'Virus');
insert into Facteur values ('WNV', 'West Nile Virus', 'Virus');
insert into Facteur values ('FLUAV', 'Influenzavirus A', 'Virus');
insert into Facteur values ('HHV-5','Cytomegalovirus','Virus');
insert into Facteur values ('Meningococcus', 'Neisseria meningitidis', 'Bacterie');
insert into Facteur values ('Bacille de Koch', 'Mycobacterium tuberculosis', 'Bacterie');



insert into Maladie values ('Hepatite A','');
insert into Maladie values ('Hepatite B','');
insert into Maladie values ('Hepatite C','');
insert into Maladie values ('Dengue','');
insert into Maladie values ('Fievre du Nil','');
insert into Maladie values ('Meningite','');
insert into Maladie values ('Fievre Jaune','');
insert into Maladie values ('Grippe A','');
insert into Maladie values ('Grippe B','');
insert into Maladie values ('Grippe C','');
insert into Maladie values ('Tuberculose','');





insert into APrOrigine values ('Hepatite A','HAV','AEV');
insert into APrOrigine values ('Hepatite B','HBV','NA');
insert into APrOrigine values ('Hepatite C','HCV','NA');
insert into APrOrigine values ('Dengue','DENV','DENV-4');
insert into APrOrigine values ('Dengue','DENV','DENV-4');
insert into APrOrigine values ('Dengue','DENV','DENV-4');
insert into APrOrigine values ('Dengue','DENV','DENV-4');
insert into APrOrigine values ('Fievre Jaune','YFV','NA');
insert into APrOrigine values ('Fievre du Nil','WNV','NA');
insert into APrOrigine values ('Grippe A','FLUAV','H1-N1');
insert into APrOrigine values ('Grippe A','FLUAV','H5-N1');
insert into APrOrigine values ('Grippe A','FLUAV','H3-N2');
insert into APrOrigine values ('Meningite','Meningococcus','B');
insert into APrOrigine values ('Meningite','Meningococcus','C');
insert into APrOrigine values ('Meningite','Meningococcus','A');
insert into APrOrigine values ('Meningite','Meningococcus','Y');
insert into APrOrigine values ('Meningite','Meningococcus','W135');
insert into APrOrigine values ('Tuberculose','Bacille de Koch','NA');
insert into APrOrigine values ('Meningite','Bacille de Koch','NA');
insert into APrOrigine values ('Meningite','HHV-5','NA');
commit;

--- extension pour decomposition


create table Patient (
code_p varchar(12),
nom_p varchar(15),
prenom_p varchar(15),
age integer,
genre varchar(1),
affection varchar(20),
hopital varchar(15),
constraint patient_pk primary key (code_p),
constraint patient_k foreign key (affection) references maladie(nom_m));


insert into Patient values ('A1C','Martin', 'Pierre', 24,'H','Grippe A','SaintEloi');
insert into Patient values ('B2C','Martin', 'Marie', 52,'F','Grippe A','GDeChauliac');
insert into Patient values ('A2C','Martin', 'Elodie', 28,'F','Dengue','SaintEloi');
insert into Patient values ('B3C','Martin', 'Paul', 50,'H','Tuberculose','GDeChauliac');
insert into Patient values ('A3C','Martin', 'Christine', 48,'F','Dengue','SaintEloi');
insert into Patient values ('A4C','Martin', 'Marc', 48,'F','Dengue','SaintEloi');

commit;
