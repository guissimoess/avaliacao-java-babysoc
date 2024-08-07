	CREATE TABLE exame (rowid bigint PRIMARY KEY auto_increment, nm_exame VARCHAR(255));
	INSERT INTO exame (nm_exame) VALUES ('Acuidade Visual'), ('Urina'), ('Clinico'), ('Sangue'), ('Eletrocardiograma'), ('Raio X'), ('Ultrassonografia'), ('Tomografia');
	
	CREATE TABLE funcionario (rowid bigint PRIMARY KEY auto_increment, nm_funcionario VARCHAR(255));
	INSERT INTO funcionario (nm_funcionario) VALUES  ('Gustavo'),('Leonardo'),('Michel'),('Felipe'),('Ana'),('Maria'),('João'),('Carlos');
	
	CREATE TABLE exame_funcionario (
	    rowid_funcionario bigint,
	    rowid_exame bigint,
	    dt_exame date,
	    PRIMARY KEY (rowid_funcionario, rowid_exame, dt_exame),
	    FOREIGN KEY (rowid_funcionario) REFERENCES funcionario (rowid),
	    FOREIGN KEY (rowid_exame) REFERENCES exame (rowid)
	);
	
INSERT INTO exame_funcionario (rowid_funcionario, rowid_exame, dt_exame) VALUES 
    (1, 2, '2024-08-01'),
    (2, 1, '2024-08-05'),
    (4, 4, '2024-08-07'),
    (5, 5, '2024-08-08'),
    (6, 6, '2024-08-09'),
    (7, 7, '2024-08-10'),
    (8, 8, '2024-08-11'),
    (1, 6, '2024-08-12'),
    (2, 7, '2024-08-13'),
    (3, 8, '2024-08-14'),
    (4, 5, '2024-08-15'),
    (5, 4, '2024-08-16'),
    (7, 2, '2024-08-18'),
    (8, 1, '2024-08-19');