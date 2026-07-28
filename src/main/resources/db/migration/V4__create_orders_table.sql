CREATE TABLE orders (

                        id UUID PRIMARY KEY,

                        customer_id UUID NOT NULL,

                        total NUMERIC(10,2) NOT NULL,

                        status VARCHAR(30) NOT NULL,

                        created_at TIMESTAMP,

                        updated_at TIMESTAMP,

                        CONSTRAINT fk_order_customer
                            FOREIGN KEY(customer_id)
                                REFERENCES customers(id)

);