This is a backend English vocabulary and grammar learning application being developed in java, spring(boot, webflux).

No migrations have been added yet, but here are all the migration created for the user service (postgres):

CREATE DATABASE verb_verse;
CREATE TYPE role AS enum('STUDENT', 'TEACHER', 'WORDSMITH', 'MODER', 'ADMIN');

CREATE TABLE IF NOT EXISTS account(
uuid UUID NOT NULL PRIMARY KEY,
username varchar(100) NOT NULL UNIQUE,
email varchar(255) NOT NULL UNIQUE,
password varchar(255) NOT NULL,
birth_date timestamp,
created_at timestamp NOT NULL,
role role NOT NULL,
is_active boolean NOT NULL
);

CREATE OR REPLACE FUNCTION smallint_to_boolean_cast(i smallint) RETURNS boolean AS $$
BEGIN
    RETURN (i::smallint)::int::bool;
END;
$$ LANGUAGE plpgsql;

CREATE CAST (character varying AS role) WITH INOUT AS ASSIGNMENT;
CREATE CAST (smallint AS boolean) WITH FUNCTION smallint_to_boolean_cast(smallint) AS ASSIGNMENT;