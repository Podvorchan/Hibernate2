CREATE SCHEMA IF NOT EXISTS my_store;

-- Создание таблицы
CREATE TABLE IF NOT EXISTS my_store.product
(
    id          serial CONSTRAINT PRIMARY KEY,
    name        text NOT NULL,
    description text NOT NULL,
    price       double PRECISION
    );

-- Создание таблицы
CREATE TABLE IF NOT EXISTS my_store.address
(
    id                 serial CONSTRAINT PRIMARY KEY,
    country            text NOT NULL,
    city               text NOT NULL,
    street             text NOT NULL,
    house              text NOT NULL
);

-- Создание таблицы
CREATE TABLE IF NOT EXISTS my_store.client
(
    id                 serial CONSTRAINT PRIMARY KEY,
    name               text NOT NULL,
    email              text NOT NULL,
    phone              text NOT NULL,
    fk_address_id      integer constraint fk_address_id_fkey references my_store.address,
    orderHistory       integer constraint fk_order_id_fkey references my_store.order
    );

CREATE TABLE IF NOT EXISTS my_store.order_item
(
    id             serial CONSTRAINT,
    fk_order_id    integer constraint fk_order_id_fkey references my_store.order,
    fk_product_id  integer constraint fk_product_id_fkey references my_store.product,
    count          int
);

-- Создание таблицы
CREATE TABLE IF NOT EXISTS my_store.order
(
    id                serial CONSTRAINT PRIMARY KEY,
    fk_client_id      integer NOT NULL constraint fk_client_id_fkey references my_store.client
);