SELECT setval(pg_get_serial_sequence('USERS', 'USERNAME'), coalesce(max(id)+1, 1), false) FROM USERS;
