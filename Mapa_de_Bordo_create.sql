-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2017-06-19 20:34:38.385

-- tables
-- Table: captura
CREATE TABLE captura (
    id serial  NOT NULL,
    peso decimal(10,5)  NOT NULL,
    especie_id int  NOT NULL,
    lance_id int  NOT NULL,
    CONSTRAINT captura_pk PRIMARY KEY (id)
);

-- Table: embarcacao
CREATE TABLE embarcacao (
    id serial  NOT NULL,
    nome varchar(255)  NOT NULL,
    tamanho decimal(10,5)  NOT NULL,
    CONSTRAINT embarcacao_pk PRIMARY KEY (id)
);

-- Table: especie
CREATE TABLE especie (
    id serial  NOT NULL,
    nome varchar(255)  NOT NULL,
    profundidade_minima decimal(10,5)  NOT NULL,
    profundidade_maxima decimal(10,5)  NOT NULL,
    CONSTRAINT especie_pk PRIMARY KEY (id)
);

-- Table: fotografia
CREATE TABLE fotografia (
    id serial  NOT NULL,
    nome_arquivo varchar(255)  NOT NULL,
    especie_id int  NOT NULL,
    CONSTRAINT fotografia_pk PRIMARY KEY (id)
);

-- Table: lance
CREATE TABLE lance (
    id serial  NOT NULL,
    data date  NOT NULL,
    hora_inicial time  NOT NULL,
    hora_final time  NOT NULL,
    comprimento_rede decimal(10,5)  NOT NULL,
    altura_rede decimal(10,5)  NOT NULL,
    tamanho_malha decimal(10,5)  NOT NULL,
    profundidade decimal(10,5)  NOT NULL,
    latitude_inicial decimal(10,8)  NOT NULL,
    longitude_inicial decimal(11,8)  NOT NULL,
    viagem_id int  NOT NULL,
    CONSTRAINT lance_pk PRIMARY KEY (id)
);

-- Table: porto
CREATE TABLE porto (
    id serial  NOT NULL,
    nome varchar(255)  NOT NULL,
    administracao char(3)  NOT NULL,
    ano_fundacao int  NOT NULL,
    CONSTRAINT porto_pk PRIMARY KEY (id)
);

-- Table: viagem
CREATE TABLE viagem (
    id serial  NOT NULL,
    data_saida date  NOT NULL,
    data_chegada date  NOT NULL,
    embarcacao_id int  NOT NULL,
    id_porto_chegada int  NOT NULL,
    id_porto_saida int  NOT NULL,
    CONSTRAINT viagem_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: captura_especie_especie (table: captura)
ALTER TABLE captura ADD CONSTRAINT captura_especie_especie
    FOREIGN KEY (especie_id)
    REFERENCES especie (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: captura_especie_lance (table: captura)
ALTER TABLE captura ADD CONSTRAINT captura_especie_lance
    FOREIGN KEY (lance_id)
    REFERENCES lance (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: captura_viagem (table: lance)
ALTER TABLE lance ADD CONSTRAINT captura_viagem
    FOREIGN KEY (viagem_id)
    REFERENCES viagem (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: fotografia_especie (table: fotografia)
ALTER TABLE fotografia ADD CONSTRAINT fotografia_especie
    FOREIGN KEY (especie_id)
    REFERENCES especie (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: viagem_embarcacao (table: viagem)
ALTER TABLE viagem ADD CONSTRAINT viagem_embarcacao
    FOREIGN KEY (embarcacao_id)
    REFERENCES embarcacao (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: viagem_porto_chegada (table: viagem)
ALTER TABLE viagem ADD CONSTRAINT viagem_porto_chegada
    FOREIGN KEY (id_porto_chegada)
    REFERENCES porto (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: viagem_porto_saida (table: viagem)
ALTER TABLE viagem ADD CONSTRAINT viagem_porto_saida
    FOREIGN KEY (id_porto_saida)
    REFERENCES porto (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

