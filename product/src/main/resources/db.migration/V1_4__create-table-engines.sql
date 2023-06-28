CREATE TABLE IF NOT EXISTS "engines" (
	"uuid" 			uuid NOT NULL PRIMARY KEY,
	"description"	varchar,
	"horse_power"	int NOT NULL DEFAULT 0,
	"torque"		int NOT NULL DEFAULT 0,
	"capacity_cc"	int NOT NULL DEFAULT 0
);