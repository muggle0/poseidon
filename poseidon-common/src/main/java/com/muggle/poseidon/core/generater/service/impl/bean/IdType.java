package com.muggle.poseidon.core.generater.service.impl.bean;

public enum IdType {
    SECONDS("seconds"), MILLISECONDS("milliseconds"), SHORTID("short_id");

    private String name;

    private IdType(String name) {
        this.name = name;
    }

    public long value() {
        switch (this) {
            case SECONDS:
                return 0;
            case MILLISECONDS:
                return 1;
            case SHORTID:
                return 2;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static com.robert.vesta.service.impl.bean.IdType parse(String name) {
        if ("seconds".equals(name)) {
            return SECONDS;
        } else if ("milliseconds".equals(name)) {
            return MILLISECONDS;
        } else if ("short_id".equals(name)) {
            return SHORTID;
        }
        throw new IllegalArgumentException("Illegal IdType name <[" + name
                + "]>, available names are seconds and milliseconds");
    }

    public static com.robert.vesta.service.impl.bean.IdType parse(long type) {
        if (type == 1) {
            return MILLISECONDS;
        } else if (type == 0) {
            return SECONDS;
        }
        else if(type==2){
            return SHORTID;
        }

        throw new IllegalArgumentException("Illegal IdType value <[" + type
                + "]>, available values are 0 (for seconds) and 1 (for milliseconds)");
    }
}
