package com.muggle.poseidon.core.generater.service.impl.populater;

import com.robert.vesta.service.bean.Id;
import com.robert.vesta.service.impl.bean.IdMeta;
import com.robert.vesta.service.impl.timer.Timer;

public interface IdPopulator {

    void populateId(Timer timer, Id id, IdMeta idMeta);

}
