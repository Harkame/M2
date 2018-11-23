Donner les informations générales sur les virus
CREATE VIEW InfoVirusView AS
SELECT *
FROM virus@LeNomDuLienLaRevanche;

Donner les acronymes des virus, leurs familles virales et leur mode de transmission
CREATE VIEW VirusEtTransmissionView AS
SELECT acronyme,famille_v, mode_t
FROM Virus@LeNomDuLienLaRevanche v
INNER JOIN aPrTransmission@LeNomDuLienLaRevanche ON acronyme = v.acronyme
group by acronyme,famille_v, mode_t;

Donner les facteurs viraux
CREATE VIEW InfoFacteurView AS
select * from facteur@LeNomDuLienApocalypse where type_facteur like 'Virus';

Donner le nom des maladies bactériennes
CREATE VIEW MaladieBactView AS
SELECT m.nom_m
FROM maladie@LeNomDuLienApocalypse m
INNER JOIN aprOrigine@LeNomDuLienApocalypse o ON m.nom_m=o.nom_m
INNER JOIN facteur@LeNomDuLienApocalypse f ON f.acro_facteur=o.acro_facteur
AND type_facteur like 'Bacterie';

Donner les informations que vous pouvez obtenir de part et d’autre des deux schémas concernant les virus d’un côté et les facteurs viraux d’un autre côté :
acronyme, nom du virus, famille virale, type de génome
CREATE VIEW VirusMaladieView AS
SELECT *
FROM virus@LeNomDuLienLaRevanche v
INNER JOIN facteur@LeNomDuLienApocalypse f ON v.acronyme = f.acro_facteur
WHERE f.type_facteur LIKE 'Virus';

Donner les maladies virales qui se transmettent par voie aérienne
CREATE VIEW MaladieViralView AS
SELECT m.nom_m
FROM maladie@LeNomDuLienApocalypse m
INNER JOIN aprOrigine@LeNomDuLienApocalypse o ON m.nom_m=o.nom_m
INNER JOIN facteur@LeNomDuLienApocalypse f ON f.acro_facteur=o.acro_facteur
INNER JOIN aPrTransmission@LeNomDuLienLaRevanche t ON t.acronyme_v=f.acro_facteur
AND type_facteur like 'Virus'
AND mode_t like 'voie aerienne'
GROUP BY m.nom_m;

Donner les facteurs viraux qui ne sont pas référencés en tant que virus dans la base de données Virus-Transmission


CREATE VIEW FacteurVirauxNonRefView AS
SELECT nom_f
FROM facteur@LeNomDuLienApocalypse
WHERE type_facteur like 'Virus'
AND nom_f NOT IN (SELECT nom_v from Virus@LeNomDuLienLaRevanche)
GROUP BY nom_f;

2.1:


drop materialized view test;

create materialized view t as select * from maladie@LeNomDuLienApocalypse;

create materialized view log on maladie@LeNomDuLienApocalypse;
create materialized view test refresh fast on commit as select * from maladieLeNomDuLienApocalypse;

create materialized view log on maladie@LeNomDuLienApocalypse
create materialized view test as select * from maladie@LeNomDuLienApocalypse;
view test1 as select * from maladie@LeNomDuLienApocalypse;
create materialized view test refresh fast as select * from maladie@LeNomDuLienApocalypse;

select mview_name from user_mviews;
select primary_key from user_mview_logs;

execute DBMS_MVIEW.REFRESH(’test’);



3:
    voir page 13-14 et 9-10 du cours


Schema de fragmentation :
    Patient = F1 U F2
    F1 = sigma(hospital)='GDeChauliac'(Patient)
    F2 = sigma(hospital)='StEloi'(Patien)

Schema d'allocation
APrOrigine@lien JOIN Maladie@Lien2



    Create view v1 as
    select code_p, genre from patient@LeNomDuLienApocalypse where hopital like 'GDeChauliac';

    CREATE VIEW v2 as
    select code_p, genre from patient@LeNomDuLienApocalypse where hopital like 'SaintEloi';

    CREATE VIEW v3 as
    select affection, age from patient@LeNomDuLienApocalypse where hopital like 'GDeChauliac';

    CREATE VIEW v4 as
    select affection, age from patient@LeNomDuLienApocalypse where hopital like 'SaintEloi';
