CREATE TABLE consulta
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    medico_id   BIGINT   NOT NULL,
    paciente_id BIGINT   NOT NULL,
    data        datetime NOT NULL,
    CONSTRAINT pk_usuario PRIMARY KEY (id),
    constraint fk_consultas_medico_id foreign key (medico_id) references medico (id),
    constraint fk_consultas_paciente_id foreign key (paciente_id) references paciente (id)
);
