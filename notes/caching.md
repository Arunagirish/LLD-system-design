# Caching — System Design Notes

## Why Cache?

- DB read (disk): ~30–50ms → Redis (memory): ~1ms → **50x improvement**
- Reduces DB load, cuts latency, enables scale

**When to bring it up** (don't jump straight to it — establish the bottleneck first):
- Read-heavy workload (high QPS hitting DB)
- Expensive queries (complex joins, aggregations)
- High DB CPU at peak
- Latency requirement (sub-10ms needed, DB is 30–50ms)

---

## Where to Cache (Layers)

| Layer | Examples | Best For |
|---|---|---|
| **Client-side** | Browser cache, localStorage, mobile storage | Avoid network calls; hard to invalidate |
| **CDN** | Cloudflare, Fastly, Akamai | Static media, public API responses; 20–40ms vs 250–300ms from origin |
| **External (distributed)** | Redis, Memcached | Shared across app servers — **DEFAULT answer** |
| **In-process** | App memory (HashMap) | Config, feature flags, hot keys; NOT shared across instances |

---

## Cache Architectures (Read/Write Patterns)

### Cache-Aside (Lazy Loading) — DEFAULT
1. Check cache → hit → return
2. Miss → query DB → store in cache → return
- Lean cache (only caches what's needed)
- Cache miss adds latency

### Write-Through
- App writes to cache → cache synchronously writes to DB
- Strong consistency, slower writes
- Still has dual-write risk (one side fails → inconsistent)

### Write-Behind (Write-Back)
- App writes to cache → cache flushes to DB **asynchronously**
- Fast writes, but **risk of data loss** if cache crashes before flush
- Good for analytics/metrics where eventual consistency is OK

### Read-Through
- Cache acts as proxy; app never hits DB directly
- On miss, **cache** fetches from DB and stores it
- CDNs work this way; less common for app-level caching vs cache-aside

---

## Eviction Policies

| Policy | How | Use When |
|---|---|---|
| **LRU** | Evict least recently used | Default; adapts to most workloads |
| **LFU** | Evict least frequently used | Stable popularity (e.g. trending videos) |
| **FIFO** | Evict oldest inserted | Rarely used; ignores access patterns |
| **TTL** | Expire after N seconds | Always combine with LRU/LFU for freshness |

---

## Common Problems (Know These for Interviews)

### Cache Stampede (Thundering Herd)
- Hot key expires → many requests miss at once → DB spike
- **Fix:** Request coalescing (single-flight — only one request rebuilds, others wait); cache warming (refresh before expiry)

### Cache Consistency
- Cache and DB out of sync after a write
- **Fix options:**
  - Invalidate on write (delete cache entry after DB update)
  - Short TTL (accept brief staleness)
  - Accept eventual consistency (feeds, analytics)

### Hot Keys
- One key gets huge traffic → overloads a single cache node
- **Fix:** Replicate key across nodes, local in-process fallback, rate limiting

### Cache Penetration
- Requests for non-existent keys always miss → hammer DB
- **Fix:** Cache the null result; use a Bloom filter

---

## Interview Framework (5 Steps)

1. **Identify the bottleneck** — use numbers: "DB CPU 80%, 200M reads/day, 30ms/query"
2. **Decide what to cache** — high-read, low-write, expensive to fetch; define cache keys
3. **Choose cache architecture** — layer (external Redis) + pattern (cache-aside)
4. **Set eviction policy** — LRU + TTL
5. **Address downsides** — pick 1–2 relevant: invalidation, stampede, hot keys, failure fallback

---

## Key Numbers

| Source | Latency |
|---|---|
| DB query (with index) | 30–50ms |
| Redis | < 2ms |
| CDN edge | 20–40ms |
| Origin server (cross-continent) | 250–300ms |

---

## Quick Reminders

- **Don't cache everything** — only when complexity is worth the trade-off
- **Cache-aside is the safe default** for app-level caching
- **CDN is the safe default** for static media at scale
- Mention in-process cache only as an optimization layer on top of Redis
- Redis hit rate is the headline KPI to monitor
