CREATE TABLE IF NOT EXISTS "customers" (
	"uuid"			uuid NOT NULL PRIMARY KEY,
	"full_name"		varchar NOT NULL,
	"birth_date"	date NOT NULL,
	"phone"    		varchar NOT NULL,
	"email"       	varchar NOT NULL UNIQUE
);