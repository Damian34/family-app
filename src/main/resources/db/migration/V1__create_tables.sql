CREATE TABLE family(
	id uuid PRIMARY KEY,
	name varchar,
	nr_of_adults int default 0,
	nr_of_children int default 0,
	nr_of_infants int default 0
);

CREATE TABLE family_member(
	id uuid PRIMARY KEY,
	family_id uuid NOT NULL,
	name varchar,
	age int
);

ALTER TABLE family_member ADD CONSTRAINT fk_family FOREIGN KEY(family_id) REFERENCES family(id);