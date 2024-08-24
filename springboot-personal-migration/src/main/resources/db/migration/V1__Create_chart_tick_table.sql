CREATE TABLE chart_tick (
    id UUID PRIMARY KEY,
    symbol VARCHAR(255) NOT NULL,
    date_time TIMESTAMP NOT NULL,
    open NUMERIC(19, 4),
    high NUMERIC(19, 4),
    low NUMERIC(19, 4),
    close NUMERIC(19, 4),
    tick_volume BIGINT,
    spread INT,
    volume BIGINT
);

CREATE INDEX idx_symbol ON chart_tick(symbol);
CREATE INDEX idx_dateTime ON chart_tick(date_time);