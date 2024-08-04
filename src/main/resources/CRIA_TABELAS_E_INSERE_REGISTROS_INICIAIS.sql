CREATE TABLE exame (rowid bigint PRIMARY KEY auto_increment, nm_exame VARCHAR(255));
INSERT INTO exame (nm_exame) VALUES ('Acuidade Visual'), ('Urina'), ('Clinico'), ('Sangue');

CREATE TABLE funcionario (rowid bigint PRIMARY KEY auto_increment, nm_funcionario VARCHAR(255));
INSERT INTO funcionario (nm_funcionario) VALUES ('Gustavo'), ('Leonardo'), ('Michel'), ('Felipe');

CREATE TABLE exame_funcionario (
    rowid_funcionario BIGINT,
    rowid_exame BIGINT,
    dt_exame DATE,
    CONSTRAINT pk_exame_funcionario PRIMARY KEY (rowid_funcionario, rowid_exame, dt_exame),
    CONSTRAINT fk_funcionario_exame_funcionario FOREIGN KEY (rowid_funcionario) REFERENCES funcionario (rowid),
    CONSTRAINT fk_exame_exame_funcionario FOREIGN KEY (rowid_exame) REFERENCES exame (rowid)
);

/*INSERT INTO exame_funcionario (rowid_funcionario, rowid_exame, dt_exame) VALUES (1, 2, '2024-08-01');
INSERT INTO exame_funcionario (rowid_funcionario, rowid_exame, dt_exame) VALUES (2, 1, '2024-08-05');
INSERT INTO exame_funcionario (rowid_funcionario, rowid_exame, dt_exame) VALUES (3, 3, '2024-08-03');*/
