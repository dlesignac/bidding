--liquibase formatted sql

--changeset dlesignac:create_bid_structure
CREATE TABLE IF NOT EXISTS bid
(
    id        TEXT PRIMARY KEY,
    market_id TEXT NOT NULL
);

CREATE INDEX IF NOT EXISTS idx_bid_market_id ON bid (market_id);

CREATE TABLE IF NOT EXISTS bid_block
(
    id                     TEXT PRIMARY KEY,
    bid_id                 TEXT        NOT NULL REFERENCES bid (id),
    instant_interval_start timestamptz NOT NULL,
    instant_interval_end   timestamptz NOT NULL,
    price                  NUMERIC     NOT NULL
);

CREATE TABLE IF NOT EXISTS supply
(
    id           TEXT PRIMARY KEY,
    bid_block_id TEXT    NOT NULL REFERENCES bid_block (id),
    supplier_id  TEXT    NOT NULL,
    energy       NUMERIC NOT NULL
);

CREATE INDEX IF NOT EXISTS idx_supply_supplier_id ON bid (market_id);
