--
-- JBoss, Home of Professional Open Source
-- Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

-- You can use this file to load seed data into the database using SQL statements
insert into Member (id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.com', '2125551212');

insert into Especialidade (especialidade_id, titulo) values (1,'Cardiologista');
insert into Especialidade (especialidade_id, titulo) values (2,'Ginecologita');
insert into Especialidade (especialidade_id, titulo) values (3,'Ortopedista');
insert into Especialidade (especialidade_id, titulo) values (4,'Neurologista');
insert into Especialidade (especialidade_id, titulo) values (5,'Pneumologista');
insert into Especialidade (especialidade_id, titulo) values (6,'Psiquiatra');

insert into Medico(id, primeiroNome, ultimoNome, email, ativo, cidade, estado, status, especialidade_id) values (1,'Lucas','Santos da Silba','lucas@gmail.com',true,'Brasilia','DF','ativo',1);
insert into Medico(id, primeiroNome, ultimoNome, email, ativo, cidade, estado, status, especialidade_id) values (2,'Diogo','Silveira da Costa','diego@gmail.com',true,'Goiania','GO','ativo',2);