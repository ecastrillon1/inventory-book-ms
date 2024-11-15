CREATE TABLE book
(
    book_id serial NOT NULL,
    tittle character varying NOT NULL,
    author character varying NOT NULL,
    availability boolean NOT NULL,
    CONSTRAINT book_pk PRIMARY KEY (book_id)
);

ALTER TABLE IF EXISTS book_id
    OWNER to postgres;

CREATE TABLE book_history
(
    book_history_id serial NOT NULL,
    book_id integer NOT NULL,
    departure_date time with time zone NOT NULL,
    arrival_date time with time zone NOT NULL,
    CONSTRAINT book_history_pk PRIMARY KEY (book_history_id),
    CONSTRAINT book_fk FOREIGN KEY (book_id)
        REFERENCES book (book_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS book_history
    OWNER to postgres;