INSERT INTO bid(id, market_id)
VALUES ('bid_2', 'market_2');

INSERT INTO bid_block(id, bid_id, instant_interval_start, instant_interval_end, price)
VALUES ('bid_block_2', 'bid_2', '2021-12-21T00:00:00Z', '2021-12-22T00:00:00Z', 1);

INSERT INTO supply(id, bid_block_id, supplier_id, energy)
VALUES ('supply_2', 'bid_block_2', 'supplier_2', 1);
