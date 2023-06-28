CREATE TABLE IF NOT EXISTS "loans" (
	"uuid"                      uuid NOT NULL PRIMARY KEY,
	"finance_uuid"              uuid references "finances",
	"finance_company" 	        varchar NOT NULL,
	"contact_person_name"       varchar NOT NULL,
	"contact_person_phone"      varchar NOT NULL,
	"contact_person_email"      varchar NOT NULL
);