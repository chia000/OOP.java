use master
go

use Gestionale
go

alter table [dbo].[User]
add constraint PK_user_pass
primary key (username, password)

alter table [dbo].[User]
add constraint unq_user_pass
unique(username, password)

alter table prodotto
add constraint PK_cod
primary key (Codice)

alter table prodotto
add constraint unq_cod_marca
unique(codice, marca)

alter table fornitore
add constraint PK_piva
primary key (p_iva)

alter table cliente
add constraint PK_cf
primary key (cf)

alter table ordine_fornitore
add constraint PK_cod_piva
primary key (cod_prod, p_iva_fornitore)

alter table ordine_cliente
add constraint PK_cod_cliente
primary key (cod_prod, cf_cliente)

alter table ORDINE_fornitore
add constraint FK_ordine_fornitore
foreign key (p_iva_fornitore)
references fornitore(p_iva)

alter table ORDINE_fornitore
add constraint FK_ordine_fornitore_prodotto
foreign key (cod_prod)
references prodotto(codice)

alter table ORDINE_cliente
add constraint FK_ordine_cliente
foreign key (cf_cliente)
references cliente(cf)

alter table ORDINE_cliente
add constraint FK_ordine_cliente_prodotto
foreign key (cod_prod)
references prodotto(codice)