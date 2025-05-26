CREATE TABLE IF NOT EXISTS client (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255),
    last_name VARCHAR(255) NOT NULL
);

CREATE TYPE account_type AS ENUM ('DEBIT', 'CREDIT');

CREATE TABLE IF NOT EXISTS account (
    id BIGSERIAL PRIMARY KEY,
    client_id BIGINT NOT NULL,
    type account_type NOT NULL,
    balance DECIMAL(19, 2) NOT NULL DEFAULT 0.00
        CHECK (balance >= 0),
    CONSTRAINT fk_account_client
       FOREIGN KEY (client_id)
       REFERENCES client(id)
       ON UPDATE CASCADE
       ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS transaction (
    id BIGSERIAL PRIMARY KEY,
    account_id BIGINT NOT NULL,
    amount DECIMAL(19, 2) NOT NULL
        CHECK (amount > 0),
    transaction_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_transaction_account
        FOREIGN KEY (account_id)
        REFERENCES account(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS data_source_error_log (
    id BIGSERIAL PRIMARY KEY,
    stack_trace TEXT NOT NULL,
    error_message TEXT NOT NULL,
    method_signature VARCHAR(500) NOT NULL
);
