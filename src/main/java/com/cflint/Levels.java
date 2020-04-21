package com.cflint;

public enum Levels {
    FATAL("FATAL", 1),
    CRITICAL("CRITICAL", 2),
    ERROR("ERROR", 3),
    WARNING("WARNING", 4),
    CAUTION("CAUTION", 5),
    INFO("INFO", 6),
    COSMETIC("COSMETIC", 7),
    UNKNOWN("UNKNOWN", 99);

    private final String name;
    private final int order;

    private Levels(final String name, final int order) {
        this.name = name;
        this.order = order;
    }
    
    public int getOrder() {
    	return order;
    }

    @Override
    public String toString() {
        if (name == null || this == UNKNOWN) {
            return "";
        }

        return name;
    }

    public static Levels fromString(final String severity) {
        for (Levels level : Levels.values()) {
            if (level.toString().equals(severity)) {
                return level;
            }
        }

        return UNKNOWN;
    }
}
