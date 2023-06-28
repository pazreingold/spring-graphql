CREATE TABLE IF NOT EXISTS "sales_orders" (
	"uuid"            	uuid NOT NULL PRIMARY KEY,
	"customer_uuid"   	uuid REFERENCES "customers",
	"order_date_time"	timestamptz NOT NULL,
	"order_number"		varchar NOT NULL UNIQUE
);