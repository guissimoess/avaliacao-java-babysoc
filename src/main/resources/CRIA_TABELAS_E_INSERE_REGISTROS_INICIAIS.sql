CREATE TABLE exame (rowid bigint PRIMARY KEY auto_increment, nm_exame VARCHAR(255));
INSERT INTO exame (nm_exame) VALUES ('Acuidade Visual'), ('Urina'), ('Clinico'), ('Sangue');

CREATE TABLE funcionario (rowid bigint PRIMARY KEY auto_increment, nm_funcionario VARCHAR(255));
INSERT INTO funcionario (nm_funcionario) VALUES ('Gustavo'), ('Leonardo'), ('Michel'), ('Felipe');

CREATE TABLE exame_funcionario (
    rowid_funcionario bigint,
    rowid_exame bigint,
    dt_exame date,
    PRIMARY KEY (rowid_funcionario, rowid_exame, dt_exame),
    FOREIGN KEY (rowid_funcionario) REFERENCES funcionario (rowid),
    FOREIGN KEY (rowid_exame) REFERENCES exame (rowid)
);

INSERT INTO exame_funcionario (rowid_funcionario, rowid_exame, dt_exame) VALUES (1, 2, '2024-08-01');
INSERT INTO exame_funcionario (rowid_funcionario, rowid_exame, dt_exame) VALUES (2, 1, '2024-08-05');
INSERT INTO exame_funcionario (rowid_funcionario, rowid_exame, dt_exame) VALUES (3, 3, '2024-08-03');
