CREATE TABLE payments (

                          id UUID PRIMARY KEY,

                          order_id UUID,

                          amount NUMERIC(10,2),

                          status VARCHAR(30),

                          provider VARCHAR(50),

                          transaction_id VARCHAR(100),

                          created_at TIMESTAMP,

                          updated_at TIMESTAMP,

                          CONSTRAINT fk_order
                              FOREIGN KEY(order_id)
                                  REFERENCES orders(id)

);