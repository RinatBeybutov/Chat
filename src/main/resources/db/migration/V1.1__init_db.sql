CREATE TABLE cities (
   id INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   name VARCHAR(255),
   CONSTRAINT cities_pkey PRIMARY KEY (id)
);

CREATE TABLE users (
   id INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   email VARCHAR(255),
   name VARCHAR(255),
   city_id INTEGER NOT NULL,
   CONSTRAINT users_pkey PRIMARY KEY (id)
);

ALTER TABLE users ADD FOREIGN KEY (city_id) REFERENCES cities(id);
