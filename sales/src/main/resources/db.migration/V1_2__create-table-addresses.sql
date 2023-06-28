CREATE TABLE IF NOT EXISTS "addresses" (
	"uuid"              uuid NOT NULL PRIMARY KEY,
	"customer_uuid"     uuid REFERENCES "customers",
	"street"      	    varchar NOT NULL,
	"city"      	    varchar NOT NULL,
	"zipcode"      	    varchar NOT NULL
);