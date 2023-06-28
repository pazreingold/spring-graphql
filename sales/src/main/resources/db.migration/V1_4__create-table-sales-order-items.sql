CREATE TABLE IF NOT EXISTS "sales_order_items" (
	"uuid"                  uuid NOT NULL PRIMARY KEY,
	"sales_order_uuid"      uuid references "sales_orders",
	"quantity" 	            integer NOT NULL,
	"model_uuid"		    uuid NOT NULL
);