CREATE TABLE orders (

                        id UUID PRIMARY KEY,

                        customer_id UUID,

                        total NUMERIC(10,2),

                        status VARCHAR(30),

                        created_at TIMESTAMP,

                        updated_at TIMESTAMP,

                        CONSTRAINT fk_customer
                            FOREIGN KEY(customer_id)
                                REFERENCES customers(id)

);