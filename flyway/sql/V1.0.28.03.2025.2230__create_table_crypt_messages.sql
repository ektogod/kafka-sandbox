CREATE TABLE crypt_messages (
    sequence BIGINT PRIMARY KEY,
    product_id VARCHAR(50) NOT NULL,
    price VARCHAR(20) NOT NULL,
    open_24h VARCHAR(20) NOT NULL,
    volume_24h VARCHAR(20) NOT NULL,
    low_24h VARCHAR(20) NOT NULL,
    high_24h VARCHAR(20) NOT NULL,
    volume_30d VARCHAR(20) NOT NULL,
    best_bid VARCHAR(20) NOT NULL,
    best_bid_size VARCHAR(20) NOT NULL,
    best_ask VARCHAR(20) NOT NULL,
    best_ask_size VARCHAR(20) NOT NULL,
    side VARCHAR(10) NOT NULL,
    time VARCHAR(30) NOT NULL,
    trade_id BIGINT NOT NULL,
    last_size VARCHAR(20) NOT NULL
);
