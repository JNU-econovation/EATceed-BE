use gaebaljip;

CREATE TABLE `AGREEMENT_TB`
(
    `AGREEMENT_PK` bigint(20) NOT NULL AUTO_INCREMENT,
    `CREATED_DATE`    datetime(6)  NOT NULL,
    `UPDATED_DATE`    datetime(6)  NOT NULL,
    `AGREEMENT_IS_PRIVACY_POLICY_AGREE` tinyint NOT NULL,
    `AGREEMENT_IS_TERMS_SERVICE_AGREE` tinyint NOT NULL,
    `AGREEMENT_IS_OVER_AGE` tinyint NOT NULL,
    `AGREEMENT_IS_SENSITIVE_DATA_AGREE` tinyint NOT NULL,
    PRIMARY KEY (`AGREEMENT_PK`)
) ENGINE=InnoDB;

CREATE TABLE `MEMBER_TB`
(
    `MEMBER_PK`       bigint(20)   NOT NULL AUTO_INCREMENT,
    `CREATED_DATE`    datetime(6)  NOT NULL,
    `UPDATED_DATE`    datetime(6)  NOT NULL,
    `MEMBER_ACTIVITY` varchar(255) DEFAULT NULL,
    `MEMBER_AGE`      int(11)      DEFAULT NULL,
    `MEMBER_ETC`      varchar(255) DEFAULT NULL,
    `MEMBER_GENDER`   tinyint      DEFAULT NULL,
    `MEMBER_HEIGHT`   double       DEFAULT NULL,
    `MEMBER_EMAIL`    varchar(255) NOT NULL UNIQUE,
    `MEMBER_PASSWORD` varchar(255) NOT NULL,
    `MEMBER_ROLE`     varchar(255) NOT NULL DEFAULT 'MEMBER',
    `MEMBER_WEIGHT`   double       DEFAULT NULL,
    `MEMBER_TARGET_WEIGHT`   double       DEFAULT NULL,
    `MEMBER_CHECKED`  bit(1)       NOT NULL DEFAULT 0,
    `AGREEMENT_FK`    bigint(20)   NOT NULL,
    PRIMARY KEY (`MEMBER_PK`),
    FOREIGN KEY (`AGREEMENT_FK`) REFERENCES `AGREEMENT_TB` (`AGREEMENT_PK`)
) ENGINE=InnoDB;

CREATE TABLE `FOOD_TB`
(
    `FOOD_PK`            bigint(20)   NOT NULL AUTO_INCREMENT,
    `FOOD_CALORIE`       double       NOT NULL,
    `FOOD_CARBOHYDRATE`  double       NOT NULL,
    `FOOD_FAT`           double       NOT NULL,
    `FOOD_NAME`          varchar(255) NOT NULL,
    `FOOD_PROTEIN`       double       NOT NULL,
    `FOOD_SERVING_SIZE`  double       NOT NULL,
    `FOOD_SUGARS`        double       NOT NULL,
    `FOOD_DIETARY_FIBER` double       NOT NULL,
    `FOOD_SODIUM`        double       NOT NULL,
    `MEMBER_FK`          bigint(20) DEFAULT NULL,
    PRIMARY KEY (`FOOD_PK`),
    FOREIGN KEY (`MEMBER_FK`) REFERENCES `MEMBER_TB` (`MEMBER_PK`)
) ENGINE=InnoDB;


CREATE TABLE `MEAL_TB`
(
    `MEAL_PK`            bigint(20)   NOT NULL AUTO_INCREMENT,
    `CREATED_DATE`       datetime(6)  NOT NULL,
    `UPDATED_DATE`       datetime(6)  NOT NULL,
    `MEAL_TYPE`          varchar(255) NOT NULL,
    `MEMBER_FK`          bigint(20) DEFAULT NULL,
    PRIMARY KEY (`MEAL_PK`),
    FOREIGN KEY (`MEMBER_FK`) REFERENCES `MEMBER_TB` (`MEMBER_PK`)
) ENGINE = InnoDB;

CREATE TABLE `MEAL_FOOD_TB`
(
    `MEAL_FOOD_PK` bigint(20)  NOT NULL AUTO_INCREMENT,
    `CREATED_DATE` datetime(6) NOT NULL,
    `UPDATED_DATE` datetime(6) NOT NULL,
    `FOOD_FK`      bigint(20) DEFAULT NULL,
    `MEAL_FK`      bigint(20) DEFAULT NULL,
    `MEAL_FOOD_MULTIPLE` double DEFAULT NULL,
    `MEAL_FOOD_G` int DEFAULT NULL,
    PRIMARY KEY (`MEAL_FOOD_PK`),
    FOREIGN KEY  (`FOOD_FK`) REFERENCES `FOOD_TB` (`FOOD_PK`),
    FOREIGN KEY  (`MEAL_FK`)REFERENCES `MEAL_TB` (`MEAL_PK`)
) ENGINE=InnoDB;

CREATE TABLE `EAT_HABITS_TB`
(
    `EAT_HABITS_PK` bigint(20) NOT NULL AUTO_INCREMENT,
    `MEMBER_FK` bigint(20) DEFAULT NULL,
    `CREATED_DATE` datetime(6) NOT NULL,
    `FLAG` tinyint(1) NOT NULL,
    `WEIGHT_PREDICTION` text NOT NULL,
    `ADVICE_CARBO` text NOT NULL,
    `ADVICE_PROTEIN` text NOT NULL,
    `ADVICE_FAT` text NOT NULL,
    `SYNTHESIS_ADVICE` text NOT NULL,
    PRIMARY KEY (`EAT_HABITS_PK`),
    FOREIGN KEY (`MEMBER_FK`) REFERENCES `MEMBER_TB` (`MEMBER_PK`)
) ENGINE = InnoDB;

CREATE TABLE `HISTORY_TB`
(
    `HISTORY_PK` bigint(20) NOT NULL AUTO_INCREMENT,
    `CREATED_DATE`      datetime(6)  NOT NULL,
    `UPDATED_DATE`       datetime(6)  NOT NULL,
    `HISTORY_ACTIVITY` varchar(255) NOT NULL ,
    `HISTORY_AGE`      int(11)      NOT NULL,
    `HISTORY_GENDER`   tinyint      NOT NULL,
    `HISTORY_HEIGHT`   double       NOT NULL,
    `HISTORY_WEIGHT`   double       NOT NULL,
    `HISTORY_TARGET_WEIGHT`   double       NOT NULL,
    `MEMBER_FK` bigint(20) DEFAULT NULL,
    PRIMARY KEY (`HISTORY_PK`),
    FOREIGN KEY (`MEMBER_FK`) REFERENCES `MEMBER_TB` (`MEMBER_PK`)
) ENGINE=InnoDB;

CREATE TABLE `NOTIFY_TB`
(
    `NOTIFY_PK` bigint(20) NOT NULL AUTO_INCREMENT,
    `CREATED_DATE` datetime(6) NOT NULL,
    `UPDATED_DATE` datetime(6) NOT NULL,
    `NOTIFY_URL` varchar(255) NOT NULL,
    `NOTIFY_IS_READ` bit(1) NOT NULL,
    `NOTIFY_CONTENT` varchar(255) NOT NULL,
    `NOTIFY_TYPE` varchar(255) NOT NULL,
    `MEMBER_FK` bigint(20) DEFAULT NULL,
    PRIMARY KEY (`NOTIFY_PK`),
    FOREIGN KEY (`MEMBER_FK`) REFERENCES `MEMBER_TB` (`MEMBER_PK`)
) ENGINE=InnoDB;

create table ANNOUNCE_TB
(
    ANNOUNCE_PK bigint auto_increment
        primary key,
    CREATED_DATE datetime(6) not null,
    UPDATED_DATE datetime(6) not null,
    ANNOUNCE_CONTENT varchar(255) not null,
    ANNOUNCE_TITLE varchar(255) not null
);
