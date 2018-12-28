package com.muggle.poseidon.core.generater.service.impl.timer;

import com.robert.vesta.service.impl.bean.IdMeta;
import com.robert.vesta.service.impl.bean.IdType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class SimpleTimer implements Timer {
    protected static final Logger log = LoggerFactory.getLogger(com.robert.vesta.service.impl.timer.SimpleTimer.class);
    protected IdMeta idMeta;
    protected IdType idType;
    protected long maxTime;
    protected long epoch = EPOCH;

    public void init(IdMeta idMeta, IdType idType) {
        this.idMeta = idMeta;
        this.maxTime = (1L << idMeta.getTimeBits()) - 1;
        this.idType = idType;
        this.genTime();
        this.timerUsedLog();
    }

    public void timerUsedLog(){
        Date expirationDate = transTime(maxTime);
        long days = ((expirationDate.getTime() - System.currentTimeMillis())/(1000 * 60 * 60 * 24));
        log.info("The current time bit length is {}, the expiration date is {}, this can be used for {} days.",
                idMeta.getTimeBits(), expirationDate, days);
    }

    public void setEpoch(long epoch) {
        this.epoch = epoch;
    }

    public Date transTime(long time) {
        if (idType == IdType.MILLISECONDS) {
            return new Date(time + epoch);
        } else {
            return new Date(time * 1000 + epoch);
        }
    }

    public void validateTimestamp(long lastTimestamp, long timestamp) {
        if (timestamp < lastTimestamp) {
            if (log.isErrorEnabled())
                log.error(String
                        .format("Clock moved backwards.  Refusing to generate id for %d second/milisecond.",
                                lastTimestamp - timestamp));

            throw new IllegalStateException(
                    String.format(
                            "Clock moved backwards.  Refusing to generate id for %d second/milisecond.",
                            lastTimestamp - timestamp));
        }
    }

    public long tillNextTimeUnit(final long lastTimestamp) {
        if (log.isInfoEnabled())
            log.info(String
                    .format("Ids are used out during %d. Waiting till next second/milisencond.",
                            lastTimestamp));

        long timestamp = genTime();
        while (timestamp <= lastTimestamp) {
            timestamp = genTime();
        }

        if (log.isInfoEnabled())
            log.info(String.format("Next second/milisencond %d is up.",
                    timestamp));

        return timestamp;
    }

    public long genTime() {
        long time;
        if (idType == IdType.MILLISECONDS) {
            time = (System.currentTimeMillis() - epoch);
        } else {
            time = (System.currentTimeMillis() - epoch) / 1000;
        }
        validateTimestamp(time);
        return time;
    }

    protected void validateTimestamp(long timestamp){
        if (timestamp > maxTime) {
            String error = String.format(
                    "The current timestamp (%s >= %s) has overflowed, Vesta Service will be terminate.", timestamp, maxTime);
            log.error(error);
            throw new RuntimeException(error);
        }
    }

}
