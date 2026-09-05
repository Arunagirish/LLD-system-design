-- Run this manually after Cassandra starts if schema-action doesn't create it automatically:
-- docker exec -it cassandra cqlsh

CREATE KEYSPACE IF NOT EXISTS order_tracking
  WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

USE order_tracking;

CREATE TABLE IF NOT EXISTS orders (
  order_id    uuid,
  event_time  timeuuid,
  status      text,
  customer_name text,
  PRIMARY KEY (order_id, event_time)
) WITH CLUSTERING ORDER BY (event_time ASC);
