package cn.rocker.test;

public enum CacheSystem {

    NOP,    // no op cache
    JVM,    // in jvm
    MMC,    // memcached
    RDS,    // redis
    CBS,    // couchbase
    EHC,    // ehcache
    ASK,    // aerospike
    HZL;    // hazelcast

}
