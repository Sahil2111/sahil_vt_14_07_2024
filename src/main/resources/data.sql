-- Initial data for permissions
INSERT INTO PERMISSIONS (name) VALUES ('AllowRead');
INSERT INTO PERMISSIONS (name) VALUES ('AllowWrite');
INSERT INTO PERMISSIONS (name) VALUES ('AllowUpdate');

-- Initial data for roles
INSERT INTO USER_ROLES (name) VALUES ('Admin');
INSERT INTO USER_ROLES (name) VALUES ('User');

-- Mapping permissions to roles
INSERT INTO PER_ROLE_MAP (pid, rid, status) VALUES (1, 1, true);
INSERT INTO PER_ROLE_MAP (pid, rid, status) VALUES (2, 1, true);
INSERT INTO PER_ROLE_MAP (pid, rid, status) VALUES (3, 1, true);
INSERT INTO PER_ROLE_MAP (pid, rid, status) VALUES (1, 2, true);

-- Initial data for users
INSERT INTO USERS (name, email, pass) VALUES ('admin', 'admin@example.com', 'admin_pass');
INSERT INTO USERS (name, email, pass) VALUES ('user', 'user@example.com', 'user_pass');

-- Mapping users to roles
INSERT INTO USER_ROLES_MAP (uid, rid) VALUES (1, 1);
INSERT INTO USER_ROLES_MAP (uid, rid) VALUES (2, 2);
