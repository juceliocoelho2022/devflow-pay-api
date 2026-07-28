CREATE TABLE customers (

                           id UUID PRIMARY KEY,

                           full_name VARCHAR(150),

                           email VARCHAR(150),

                           phone VARCHAR(20),

                           document VARCHAR(20),

                           created_at TIMESTAMP,

                           updated_at TIMESTAMP

);