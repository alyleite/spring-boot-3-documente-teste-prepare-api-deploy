CREATE TABLE usuario
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    login VARCHAR(100)          NOT NULL,
    senha VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_usuario PRIMARY KEY (id)
);
