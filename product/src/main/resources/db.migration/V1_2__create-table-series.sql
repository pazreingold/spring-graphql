CREATE TABLE IF NOT EXISTS "series" (
	"uuid"                  uuid NOT NULL PRIMARY KEY,
	"manufacturer_uuid"     uuid REFERENCES "manufacturers",
	"name"                  varchar NOT NULL,
	UNIQUE ("manufacturer_uuid", "name")
);