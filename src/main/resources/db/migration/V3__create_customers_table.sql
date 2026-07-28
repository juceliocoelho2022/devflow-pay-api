CREATE TABLE customers(

                          id UUID PRIMARY KEY,

                          full_name VARCHAR(150) NOT NULL,

                          email VARCHAR(150) UNIQUE NOT NULL,

                          document VARCHAR(20) UNIQUE NOT NULL,

                          phone VARCHAR(20),

                          active BOOLEAN NOT NULL,

                          created_at TIMESTAMP,

                          updated_at TIMESTAMP

);