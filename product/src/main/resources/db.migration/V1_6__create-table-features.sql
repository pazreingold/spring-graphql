CREATE TABLE IF NOT EXISTS "features" (
	"uuid"                  uuid NOT NULL PRIMARY KEY,
	"model_uuid"            uuid REFERENCES "models",
	"name"                  varchar NOT NULL,
	"active_by_default"     boolean NOT NULL,
	"active_by_request"     boolean NOT NULL,
	"installation_price"    float NOT NULL DEFAULT 0,
	"is_safety"             boolean NOT NULL,
	"is_entertainment"      boolean NOT NULL,
	"is_performance"        boolean NOT NULL,
	"is_convenience"        boolean NOT NULL,
	"is_display"            boolean NOT NULL
);
