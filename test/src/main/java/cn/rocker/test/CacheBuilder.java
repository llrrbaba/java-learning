package cn.rocker.test;

import java.util.EnumMap;

public interface CacheBuilder {

    CacheSystem getCacheSystem();

    abstract class Loader {
        private static final EnumMap<CacheSystem, CacheBuilder> installed = new EnumMap<>(CacheSystem.class);

        public static CacheBuilder getCacheBuilder(CacheSystem system) {
            return system == null ? null : installed.get(system);
        }
    }
}
