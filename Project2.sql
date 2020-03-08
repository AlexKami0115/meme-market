
drop table Patrons CASCADE CONSTRAINTS;
drop table Userz CASCADE CONSTRAINTS;
drop table Rarity CASCADE CONSTRAINTS;
drop table Tags CASCADE CONSTRAINTS;
drop table Cards CASCADE CONSTRAINTS;
drop table CardTags CASCADE CONSTRAINTS;
drop table OwnedCards CASCADE CONSTRAINTS;
drop table TradeStatus CASCADE CONSTRAINTS;
drop table Trades CASCADE CONSTRAINTS;
drop table TradeOwnedCards CASCADE CONSTRAINTS;
drop table PackTiers CASCADE CONSTRAINTS;
drop table PackTiersRarity CASCADE CONSTRAINTS;
drop table Microtransactions CASCADE CONSTRAINTS;
drop table PurchaseLevels CASCADE CONSTRAINTS;
drop table Purchases CASCADE CONSTRAINTS;
drop table Comments CASCADE CONSTRAINTS;

drop sequence Patrons_seq;
drop sequence Userz_seq;
drop sequence Rarity_seq;
drop sequence Tags_seq;
drop sequence Cards_seq;
drop sequence OwnedCards_seq;
drop sequence TradeStatus_seq;
drop sequence Trades_seq;
drop sequence PackTiers_seq;
drop sequence Microtransactions_seq;
drop sequence PurchaseLevels_seq;
drop sequence Purchases_seq;
drop sequence Comments_seq;

create table Patrons(
    id number(10) primary key,
    stonks number(8)
);

create table Userz(
    id number(10) primary key,
    username varchar2(20) not null,
    pass varchar2(20) not null,
    PatronID number(10),
    constraint fk_Userz_Patrons foreign key (PatronID) references Patrons(id)
);

create table Rarity(
    id number(1) primary key,
    rarityName varchar2(20),
    rarityWeight number(2)
);

create table Tags(
    id number(2) primary key,
    tagName varchar2(20) not null
);

create table Cards(
    id number(10) primary key,
    cardImage varchar2(100) not null,
    cardText varchar2(50),
    memeText varchar2(50),
    rarityId number(1),
    constraint fk_Cards_Rarity foreign key (rarityID) references Rarity(id)
);

create table CardTags(
    cardId number(10) not null,
    tagId number(2) not null,
    constraint fk_CardTags_Cards foreign key (cardId) references Cards(id),
    constraint fk_CardTags_Tags foreign key (tagId) references Tags(id)
);

create table OwnedCards(
    id number(10) primary key,
    patronId number(10) not null,
    cardId number(10) not null,
    showcased number(1),
    constraint fk_PatronCards_Patrons foreign key (patronId) references Patrons(id),
    constraint fk_PatronCards_Cards foreign key (cardId) references Cards(id)
);

create table TradeStatus(
    id number(1) primary key,
    statusName varchar(20) not null
);

create table Trades(
    id number(10) primary key,
    tradStatusId number(10),
    patronOneId number(10),
    patronTwoId number(10),
    constraint fk_Trades_TradeStatus foreign key (tradStatusId) references TradeStatus(id),
    constraint fk_Trades_Patrons_One foreign key (patronOneId) references Patrons(id),
    constraint fk_Trades_Patrons_Two foreign key (patronTwoId) references Patrons(id)
);

create table TradeOwnedCards(
    tradeId number(10) not null,
    ownedCardsId number(10) not null,
    constraint fk_TradeCardPatron_Trades foreign key (tradeId) references Trades(id),
    constraint fk_TradeCardPatron_OwnedCards foreign key (ownedCardsId) references OwnedCards(id)
);

create table PackTiers(
    id number(1) primary key,
    tierName varchar2(20) not null,
    tierPrice number(8) not null
);

create table PackTiersRarity(
    packTiersId number(1) not null,
    rarityId number(1) not null,
    constraint pk_PackTiersRarity primary key (packTiersId, rarityId),
    constraint fk_PackTiersRarity_PackTiers foreign key (packTiersId) references PackTiers(id),
    constraint fk_PackTiersRarity_Rarity foreign key (rarityId) references Rarity(id)
);

create table Microtransactions( -- Using stonks to buy packs.
    id number(10) primary key,
    patronId number(10) not null,
    packTierId number(1) not null,
    transDate timestamp default systimestamp,
    constraint fk_Microtransactions_Packs foreign key (packTierId) references PackTiers(id),
    constraint fk_Microtransactions_Patrons foreign key (patronId) references Patrons(id)
);

create table PurchaseLevels(
    id number(1) primary key,
    levelName varchar2(20) not null,
    stonkAmount number(5) not null,
    levelCost number(5,2) not null
);

create table Purchases( -- Using real money to buy stonks.
    id number(10) primary key,
    patronId number(10) not null,
    purchaseLevelId number(1) not null,
    purchaseDate timestamp default systimestamp,
    constraint fk_Purchase_PurchaseLevels foreign key (purchaseLevelId) references PurchaseLevels(id),
    constraint fk_Purchase_Patrons foreign key (patronId) references Patrons(id)
);

create table Comments(
    id number(10) primary key,
    cardId number(10) not null,
    PatronId number(10) not null,
    commentText varchar2(500) not null,
    timeOfComment timestamp default systimestamp,
    constraint fk_Comments_Cards foreign key (cardId) references Cards(id),
    constraint fk_Comments_Patrons foreign key (patronId) references Patrons(id)
);

create sequence Patrons_seq nocache;
create sequence Userz_seq nocache;
create sequence Rarity_seq nocache;
create sequence Tags_seq nocache;
create sequence Cards_seq nocache;
create sequence OwnedCards_seq nocache;
create sequence TradeStatus_seq nocache;
create sequence Trades_seq nocache;
create sequence PackTiers_seq nocache;
create sequence Microtransactions_seq nocache;
create sequence PurchaseLevels_seq nocache;
create sequence Purchases_seq nocache;
create sequence Comments_seq nocache;

commit;

/*
create table Patrons
create table Rarity
create table Tags
create table Cards
create table CardTags
create table PatronCards
create table TradeStatus
create table Trades
create table TradePatronCards
create table PackTiers
create table PackTiersRarity
create table Microtransactions
create table PurchaseLevel
create table Purchase
create table Comments

*/














