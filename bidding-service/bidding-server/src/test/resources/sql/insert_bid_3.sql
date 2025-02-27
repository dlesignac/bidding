INSERT INTO bid(id, market_id)
VALUES ('bid_3', 'market_1');

INSERT INTO bid_block(id, bid_id, instant_interval_start, instant_interval_end, price)
VALUES ('bid_block_3', 'bid_3', '2021-12-21T00:00:00Z', '2021-12-22T00:00:00Z', 1);

INSERT INTO supply(id, bid_block_id, supplier_id, energy)
VALUES ('supply_3', 'bid_block_3', 'supplier_1', 1);
