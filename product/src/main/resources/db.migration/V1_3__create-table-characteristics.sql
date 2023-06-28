CREATE TABLE IF NOT EXISTS "characteristics" (
	"uuid"          uuid NOT NULL PRIMARY KEY,
	"series_uuid"   uuid REFERENCES "series",
	"name"          varchar NOT NULL,
	UNIQUE ("series_uuid", "name")
);