CREATE TABLE users (

                       id UUID PRIMARY KEY,

                       full_name VARCHAR(150) NOT NULL,

                       email VARCHAR(150) UNIQUE NOT NULL,

                       password VARCHAR(255) NOT NULL,

                       role VARCHAR(30),

                       status VARCHAR(30),

                       active BOOLEAN,

                       created_at TIMESTAMP,

                       updated_at TIMESTAMP

);