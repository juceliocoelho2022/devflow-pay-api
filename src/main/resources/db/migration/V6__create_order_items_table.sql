CREATE TABLE order_items (

                             id UUID PRIMARY KEY,

                             order_id UUID NOT NULL,

                             product_id UUID NOT NULL,

                             quantity INTEGER NOT NULL,

                             unit_price NUMERIC(10,2) NOT NULL,

                             subtotal NUMERIC(10,2) NOT NULL,

                             created_at TIMESTAMP,

                             updated_at TIMESTAMP,

                             CONSTRAINT fk_order_item_order
                                 FOREIGN KEY (order_id)
                                     REFERENCES orders(id),

                             CONSTRAINT fk_order_item_product
                                 FOREIGN KEY (product_id)
                                     REFERENCES products(id)

);