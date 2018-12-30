package com.muggle.poseidon.core.generater;

import com.muggle.poseidon.core.generater.IdWorker;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @program: poseidon
 * @description:
 * @author: muggle
 * @create: 2018-12-28 14:02
 **/

public class PoseidonIdGener implements IdentifierGenerator {
    public static final String TYPE="com.muggle.poseidon.core.generater.PoseidonIdGener";
    private static final IdWorker idWorker = new IdWorker();
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return idWorker.getId();
    }
    public static String generate() {
        return idWorker.getId();
    }
}
