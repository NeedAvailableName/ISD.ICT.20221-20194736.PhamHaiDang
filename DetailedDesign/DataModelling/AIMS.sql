create database ITSS_AIMS;

create table Customer(customer_id int not null primary key,
						customer_name varchar(256) not null,
						phone_number varchar(11),
						address varchar(50) not null);

create table AIMSOrder(order_id int not null primary key,
					   customer_id int not null,
					   total_cost float not null,
					   is_rush_order bit not null,
					   constraint FK_OrderCustomer foreign key (customer_id) references Customer(customer_id));
                       
                       
create table CreditCard(credit_number varchar(20) not null primary key,
						card_holder_name varchar(50) not null,
						issuing_bank varchar(100) not null,
						expiration_date date not null);

create table Media(media_id varchar(4) not null primary key,
				   order_id int not null,
				   title varchar(128) not null,
				   price float not null,
				   available_quantity int not null,
				   is_rush_support bit not null,
                   constraint FK_MediaID foreign key (order_id) references AIMSOrder(order_id));

create table Book(book_id varchar(4) not null primary key,
				author varchar(40) not null,
                category varchar(40) not null,
				constraint FK_BookMediaID foreign key (book_id) references Media(media_id));

create table CD(cd_id varchar(4) not null primary key,
				artist varchar(40) not null,
                music_type varchar(40),
				constraint FK_CDMediaID foreign key (cd_id) references Media(media_id));

create table DVD(dvd_id varchar(4) not null primary key,
				director varchar(40) not null,
                runtime float not null,
				constraint FK_DVDMediaID foreign key (dvd_id) references Media(media_id));


create table InterBankTransaction(transaction_id int not null primary key,
							transaction_detail varchar(256),
							credit_number varchar(20) not null,
							constraint FK_TransactionCard foreign key (credit_number) references CreditCard(credit_number));

create table Invoice(invoice_id int not null,
					order_id int not null,
					transaction_id int not null,
					constraint FK_InvoiceOrderID foreign key (order_id) references AIMSOrder(order_id),
					constraint FK_InvoiceTransactionID foreign key (transaction_id) references InterBankTransaction(transaction_id));
create table DeliveryInfo(delivery_info_id int not null primary key,
						order_id int not null,
                        customer_name varchar(40) not null,
                        instruction varchar(100),
                        address varchar(40),
                        constraint FK_DeliveryInfoID foreign key (order_id) references AIMSOrder(order_id));
