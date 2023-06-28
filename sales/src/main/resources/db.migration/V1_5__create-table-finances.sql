CREATE TABLE IF NOT EXISTS "finances" (
	"uuid"                  uuid NOT NULL PRIMARY KEY,
	"sales_order_uuid"      uuid references "sales_orders",
	"base_amount" 	        float NOT NULL,
	"tax_amount"		    float NOT NULL,
	"discount_amount"       float NOT NULL,
	"is_loan"               boolean NOT NULL
);