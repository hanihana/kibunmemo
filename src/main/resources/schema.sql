DROP TABLE IF EXISTS kibun_memo;

CREATE TABLE IF NOT EXISTS kibun_memo (
	id INT NOT NULL AUTO_INCREMENT,
	feeling VARCHAR(100) NOT NULL,
	text VARCHAR(100) NOT NULL,
	datetime DATE NOT NULL,
	PRIMARY KEY(id)
);