--CREACION DE SECUENCIAS

CREATE SEQUENCE SEC_CLIENTES
start with 1
increment by 1
minvalue 1;

CREATE SEQUENCE SEC_ADMIN
start with 1
increment by 1
minvalue 1;


CREATE SEQUENCE SEC_TIPO_LIBROS
start with 1
increment by 1
minvalue 1;

CREATE SEQUENCE SEC_PRESTAMOS_LIBROS
start with 1
increment by 1
minvalue 1;

--CREACION DE TABLAS
CREATE TABLE CLIENTES(
ID_CLIENTE INTEGER,
NOMBRE_COMPLETO VARCHAR(100),
DIRECCION VARCHAR(100),
TELEFONO VARCHAR(40),
USERNAME VARCHAR(40),
CONTRASENNA VARCHAR(40)
);

CREATE TABLE ADMINISTRADOR(
ID_ADMINISTRADOR INTEGER,
NOMBRE_COMPLETO VARCHAR(100),
DIRECCION VARCHAR(100),
TELEFONO VARCHAR(40),
USERNAME VARCHAR(40),
CONTRASENNA VARCHAR(40)
);


CREATE TABLE LIBROS(
ID_LIBRO INTEGER,
TITULO VARCHAR(100),
AUTOR VARCHAR(100),
CATEGORIA VARCHAR(100)
);

CREATE TABLE PRESTAMOS_LIBROS(
ID_PRESTAMO INTEGER,
ID_CLIENTE INTEGER,--RELACIONAR EL CLIENTE AL LIBRO
ID_LIBRO INTEGER,
FECHA_DEVOLUCION DATE,
ESTADO INTEGER-- 1=DISPONIBLE 2=OCUPADO
);

--CONSTRAINTS

ALTER TABLE CLIENTES ADD CONSTRAINT PK_ID_CLIENTE PRIMARY KEY(ID_CLIENTE);

ALTER TABLE ADMINISTRADOR ADD CONSTRAINT PK_ADMIN PRIMARY KEY(ID_ADMINISTRADOR);

ALTER TABLE LIBROS ADD CONSTRAINT PK_ID_LIBRO PRIMARY KEY(ID_LIBRO);

ALTER TABLE PRESTAMOS_LIBROS ADD CONSTRAINT PK_ID_PRESTAMO PRIMARY KEY(ID_PRESTAMO);

ALTER TABLE PRESTAMOS_LIBROS ADD CONSTRAINT FK_ID_CLIENTE FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTES(ID_CLIENTE);

ALTER TABLE PRESTAMOS_LIBROS ADD CONSTRAINT FK_ID_LIBROS FOREIGN KEY (ID_LIBRO) REFERENCES LIBROS(ID_LIBRO);

--GENERAR DATOS ADMINISTRADOR
INSERT INTO ADMINISTRADOR VALUES(nextval('SEC_ADMIN'),'Steph','Heredia CR','88912354','steph123','1234');
INSERT INTO ADMINISTRADOR VALUES(nextval('SEC_ADMIN'),'Letta','Room 112','7816971837','lswancock0','hFFFqN89F6d');
INSERT INTO ADMINISTRADOR VALUES(nextval('SEC_ADMIN'),'Lynnell','Room 1165','8302828883','ltilburn1','xz3hTQgB');
INSERT INTO ADMINISTRADOR VALUES(nextval('SEC_ADMIN'),'Carley','15th Floor','6301815763','cmoxstead2','OLL75d4raY');
INSERT INTO ADMINISTRADOR VALUES(nextval('SEC_ADMIN'),'Slade','6th Floor','9874728124','syurenev3','xCOgpU0e');
INSERT INTO ADMINISTRADOR VALUES(nextval('SEC_ADMIN'),'Leonid','Suite 19','8159282510','lblowfelde4','J7mVBi61ESB');

--GENERAR DATOS CLIENTES
INSERT INTO CLIENTES VALUES(nextval('SEC_CLIENTES'),'Ruddie','PO Box 1761','7414606119','rfernier5','mfbQFDL');
INSERT INTO CLIENTES VALUES(nextval('SEC_CLIENTES'),'Gottfried','Room 783','2023934133','gbaldack6','FnxNIoMH');
INSERT INTO CLIENTES VALUES(nextval('SEC_CLIENTES'),'Saloma','9th Floor','3897482412','sglasson7','s1i5eQk');
INSERT INTO CLIENTES VALUES(nextval('SEC_CLIENTES'),'Killian','Apt 662','7919020468','kbowen8','jPD2jFC75Pr');
INSERT INTO CLIENTES VALUES(nextval('SEC_CLIENTES'),'Riannon','15th Floor','8629320016','rcheson9','1I15WPClEl');
INSERT INTO CLIENTES VALUES(nextval('SEC_CLIENTES'),'Elvis','Suite 40','6954617439','eolyffa','x0ujVSrccNbS');
INSERT INTO CLIENTES VALUES(nextval('SEC_CLIENTES'),'Thedrick','Room 1578','1163857915','tkippaxb','chgQeYsHxPcJ');
INSERT INTO CLIENTES VALUES(nextval('SEC_CLIENTES'),'Tory','Apt 1399','9978416267','tcostenc','GBjhs8cSx8Oi');
INSERT INTO CLIENTES VALUES(nextval('SEC_CLIENTES'),'Paxon','PO Box 22447','1269728651','pwittd','9BkIlCmJ9Aqk');
INSERT INTO CLIENTES VALUES(nextval('SEC_CLIENTES'),'Donica','Room 883','4064119358','dphilipsone','Goj2aHflq');

--GENERAR DATOS LIBROS
INSERT INTO LIBROS(ID_LIBRO,TITULO,AUTOR,CATEGORIA) VALUES(nextval('SEC_TIPO_LIBROS'),'El librito Misterioso 1','STEPH L.V','MIEDO');
INSERT INTO LIBROS(ID_LIBRO,TITULO,AUTOR,CATEGORIA) VALUES(nextval('SEC_TIPO_LIBROS'),'Dark Book','PEPE F','ROMANCE');
INSERT INTO LIBROS(ID_LIBRO,TITULO,AUTOR,CATEGORIA) VALUES(nextval('SEC_TIPO_LIBROS'),'Living in Oblivion','LOPEZ JR','AVENTURAS');
INSERT INTO LIBROS(ID_LIBRO,TITULO,AUTOR,CATEGORIA) VALUES(nextval('SEC_TIPO_LIBROS'),'League of Extraordinary','MARIO R.C','COMEDIA');
INSERT INTO LIBROS(ID_LIBRO,TITULO,AUTOR,CATEGORIA) VALUES(nextval('SEC_TIPO_LIBROS'),'Wicked Blood','JOSE P','DRAMA');

--GENERAR DATOS PRESTAMOS DE LOS LIBROS
INSERT INTO PRESTAMOS_LIBROS(ID_PRESTAMO,ID_CLIENTE,ID_LIBRO,FECHA_DEVOLUCION,ESTADO) VALUES(nextval('SEC_PRESTAMOS_LIBROS'),1,2,current_date,1);
INSERT INTO PRESTAMOS_LIBROS(ID_PRESTAMO,ID_CLIENTE,ID_LIBRO,FECHA_DEVOLUCION,ESTADO) VALUES(nextval('SEC_PRESTAMOS_LIBROS'),2,3,current_date,1);
INSERT INTO PRESTAMOS_LIBROS(ID_PRESTAMO,ID_CLIENTE,ID_LIBRO,FECHA_DEVOLUCION,ESTADO) VALUES(nextval('SEC_PRESTAMOS_LIBROS'),3,1,current_date,1);
COMMIT;



--CONSULTA DE TABLAS
SELECT * FROM CLIENTES;

SELECT * FROM ADMINISTRADOR;

SELECT * FROM LIBROS;

SELECT * FROM PRESTAMOS_LIBROS;


--ELIMINAR TABLAS...
DROP TABLE ADMINISTRADOR;

DROP TABLE CLIENTES;

DROP TABLE LIBROS;

DROP TABLE PRESTAMOS_LIBROS;

--ELIMINAR SECUENCIAS

DROP SEQUENCE SEC_CLIENTES;

DROP SEQUENCE SEC_ADMIN;

DROP SEQUENCE SEC_PRESTAMOS_LIBROS;

DROP SEQUENCE SEC_TIPO_LIBROS;