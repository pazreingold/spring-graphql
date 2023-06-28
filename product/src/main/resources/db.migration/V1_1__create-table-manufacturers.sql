CREATE TABLE IF NOT EXISTS "manufacturers" (
	"uuid"              uuid NOT NULL PRIMARY KEY,
	"name"              varchar NOT NULL UNIQUE,
	"origin_country"    varchar NOT NULL,
	"description"       varchar
);