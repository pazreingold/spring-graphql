CREATE TABLE IF NOT EXISTS "models" (
	"uuid" 					uuid NOT NULL PRIMARY KEY,
	"series_uuid" 			uuid REFERENCES "series",
	"name"                  varchar NOT NULL,
	"on_the_road_price" 	float NOT NULL DEFAULT 0,
	"length_mm"				int NOT NULL DEFAULT 0,
	"width_mm"				int NOT NULL DEFAULT 0,
	"height_mm"				int NOT NULL DEFAULT 0,
	"exterior_color"		varchar NOT NULL,
	"interior_color"		varchar NOT NULL,
	"release_year"			int NOT NULL DEFAULT 0,
	"transmission"			varchar NOT null,
	"body_type"				varchar NOT NULL,
	"fuel"					varchar NOT NULL,
	"doors"					int NOT NULL DEFAULT 0,
	"airbags"				int NOT NULL DEFAULT 0,
	"is_available"			boolean NOT NULL,
	"engine_uuid"           uuid REFERENCES "engines"
);