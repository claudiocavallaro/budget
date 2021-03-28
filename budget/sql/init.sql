create schema budget;

CREATE table "budget".metodo(
	id serial primary key,
	tipo varchar(255) UNIQUE
);
CREATE INDEX metodo_DB_ID
  ON "budget".metodo (ID);

 CREATE table "budget".pagamento_effettuato(
	id serial primary key,
	importo numeric(14,4),
	note varchar(255),
	data date,
	metodo serial references "budget".metodo(id)
);
CREATE INDEX pagamento_effettuato_DB_ID
  ON "budget".pagamento_effettuato (ID);

CREATE table "budget".pagamento_noto(
	id serial primary key,
	importo numeric(14,4),
	note varchar(255),
	data date,
	segnalato boolean,
	metodo serial references "budget".metodo(id)
);
CREATE INDEX pagamento_noto_DB_ID
  ON "budget".pagamento_noto (ID);

insert into budget.metodo(tipo)
values ('Paypal'),
       ('Carta 1'),
       ('Carta 2'),
       ('Contanti');
