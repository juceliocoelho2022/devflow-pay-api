CREATE TABLE products (

                          id UUID PRIMARY KEY,

                          name VARCHAR(120) NOT NULL,

                          description VARCHAR(600),

                          sku VARCHAR(60) UNIQUE NOT NULL,

                          price NUMERIC(10,2) NOT NULL,

                          stock INTEGER NOT NULL,

                          active BOOLEAN,

                          image_url VARCHAR(255),

                          category VARCHAR(50),

                          created_at TIMESTAMP,

                          updated_at TIMESTAMP

);