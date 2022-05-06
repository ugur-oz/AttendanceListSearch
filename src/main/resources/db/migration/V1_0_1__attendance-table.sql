CREATE TABLE ATTENDANCE
(
    anwesenheit_id int       not null Auto_increment,
    user_id        int       not null,
    Datum          timestamp not null,
    signature      clob   not null,
    CONSTRAINT FK_attendance_users FOREIGN KEY (user_id) REFERENCES users (user_id)
);
