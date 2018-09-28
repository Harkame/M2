Vous testerez les sequences d''instruction suivantes et vous expliquerez les effets obtenus

-- sequence 1
set transaction read only;
select * from cat;
update emp set fonction='commerciale' where fonction='commercial';

-- Impossible, transaction en read only


--sequence 2
select * from cat;
set transaction read only;
rollback;

-- La transaction doit etre ecrite en premier
-- Pas d'ecriture avant la transaction


--sequence 3
set transaction read only;
create table PrVoir (valeur integer primary key);
update emp set fonction='commerciale' where fonction='commercial';
rollback;

-- Commit avant et apres le create table
-- Le create table reste car il y a eu un commit automatique mais ne fonctionne pas
-- Le Rollback annule l'update qui a fonctionner
X

--sequence 4
insert into PrVoir values (1);
insert into PrVoir values (2);
insert into PrVoir values (3);
insert into PrVoir values (4);
insert into PrVoir values (5);
create table EncorePrVoir (valeur integre cle primaire);
rollback;

-- Tout est annule car pas de commit apres les insert et la table n'est pas creee (integre cle primaire) (erreur importante)


--sequence 5
insert into PrVoir values (1);
insert into PrVoir values (2);
insert into PrVoir values (3);
insert into PrVoir values (4);
insert into PrVoir values (5);
create table EncorePrVoir (valeur integer primary key);
rollback;

-- Aucune annulation, car le create table a fait un commit, meme pour les insert precedent


--sequence 6
delete from PrVoir;
create table CorePrVoir (valeur integer primary key);
insert into PrVoir values (1);
insert into PrVoir values (2);
insert into PrVoir values (3);
insert into PrVoir values (4);
insert into PrVoir values (5);
rollback;

-- Supression par le commit de create table, Table creee car commit automatique, les insert sont annules


--sequence 7
insert into PrVoir values (1);
create table CorePrVoir (valeur integre);
rollback;
select * from PrVoir;

-- Aucune annulation, le create table fait un commit, commit avant le create ok mais pas apres, erreur moindre donc le premier commit ok


-- sequence 8
-- deux sessions ouvertes par ex. user1/user1 et user2/user2 sur master (travaillez en binôme)

-- sur user2
donner tous les droits a user1 sur la table emp

GRANT ALL ON emp TO USER
-- sur user1
set transaction isolation level serializable;
-- ok
insérer un tuple dans la table emp (de user2)
-- Insertion ok
consulter la table user2.emp
constatation ?
-- Rien
valider la transaction
-- Toujours rien
consulter la table user2.emp
constatation ? quel aurait été le résultat avec un mode transactionnel read committed ?
-- user1 ne voit pas les modifications de user2 meme si validees en read commited il les aurait vues.

-- sur user2
-- mettre à jour un tuple
update emp set salaire =1000 where num=12;

-- Update ok
-- essayer de mettre à jour le même tuple
update user2.compte set salaire =2000 where num=12;
constatation ?
-- User1 bloque
valider la transaction
-- Deblocagen erreur "can't serialize access for this transaction", pas a jour
constatation ? quel aurait été le résultat avec un mode transactionnel read committed ?
-- Deblocage puis ok, il faut cependant commit manuellement

-- sequence 9
-- interblocage
-- deux sessions ouvertes en mode read committed
-- sur user2
-- mettre à jour un tuple
update emp set salaire =1000 where num=10;

-- sur user1
-- essayer de mettre à jour le même tuple
update user2.compte set salaire =2000 where num=11;

-- sur user2
-- mettre à jour le tuple verrouillé par user 1
update emp set salaire =1000 where num=11;

-- sur user1
-- mettre à jour le tuple verrouillé par user 2
update user2.compte set salaire =2000 where num=10;

-- constatation ? comment sortir de l''interblocage et quelle est l''information perdue
-- quel aurait été le résultat avec un mode transactionnel serializable ?

-- Le system a detecter un interblocage pour le premier utilisateur ou alors faire ctrl-alt-supp

-- 1 ok
-- 2 ko, pas commit
-- 3 ko, interblocage
-- 4 ko, interblocage

-- En serializable

-- 1 ok
-- 2 ok
-- 3 ko, interblocage
-- 4 ko, interblocage

-- Au moment du commit, erreur "can't  serialize access for this transaction"
