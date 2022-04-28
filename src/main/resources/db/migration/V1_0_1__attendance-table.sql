

CREATE TABLE ATTENDANCE (anwesenheit_id int PRIMARY KEY,
                         user_id int not null,
                         Datum timestamp not null,
                         signature varchar not null,
                         CONSTRAINT FK_attendance_users FOREIGN KEY (user_id) REFERENCES users (user_id)
);
