CREATE TABLE USERS
(
    USERNAME  VARCHAR PRIMARY KEY,
    PASSWORD  VARCHAR NOT NULL,
    FIRSTNAME VARCHAR,
    LASTNAME  VARCHAR
);

CREATE TABLE DOZENT
(
    USERNAME VARCHAR PRIMARY KEY,
    CONSTRAINT FK_DOZENT_USERS FOREIGN KEY (USERNAME) REFERENCES USERS (USERNAME)
);
CREATE TABLE UMSCHULER
(
    USERNAME VARCHAR PRIMARY KEY,
    CONSTRAINT FK_UMSCHULER_USERS FOREIGN KEY (USERNAME) REFERENCES USERS (USERNAME)
);
CREATE TABLE VERWALTUNG
(
    USERNAME VARCHAR PRIMARY KEY,
    CONSTRAINT FK_VERWALTUNG_USERS FOREIGN KEY (USERNAME) REFERENCES USERS (USERNAME)
);
CREATE TABLE ANWESENHEIT
(
    ID                 BIGSERIAL PRIMARY KEY,
    UMSCHULER_USERNAME VARCHAR   NOT NULL,
    DATUM              TIMESTAMP NOT NULL,
    SIGNATURE          VARCHAR   NOT NULL,
    CONSTRAINT FK_ANWESENHEIT_UMSCHULER FOREIGN KEY (UMSCHULER_USERNAME) REFERENCES UMSCHULER (USERNAME)
);