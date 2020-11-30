package com.muggle.poseidon.tool;

import com.muggle.poseidon.base.OaExceptionEnum;
import com.muggle.poseidon.base.exception.BasePoseidonCheckException;
import com.muggle.poseidon.base.exception.SimplePoseidonCheckException;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.IntegerCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: muggle
 * @Date: 2020/11/23
 **/
@Component
public class SerialNumberTool {
    @Autowired
    RedissonClient redissonClient;

    private static final String[] ALPHABET= {"A","B","C","D","E","F","G",
            "H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    public String getCode(Integer size,String group,String perfix) throws BasePoseidonCheckException {
        RAtomicLong atomicLong = redissonClient.getAtomicLong(group);
        long number = atomicLong.addAndGet(1L);
        if (number>10*Math.pow(100,size)){
            throw new SimplePoseidonCheckException(OaExceptionEnum.OaCheckError.getMessage(),
                    OaExceptionEnum.OaCheckError.getCode());
        }
        String code = getCode(perfix, number, size);
        return code;
    }

    private static String getCode(String perfix,Long number,Integer size){
        String format = String.format("%0" + size + "d", number);
        return perfix.concat(format);
    }

    public String getSerialNumber(String group){
        RAtomicLong atomicLong = redissonClient.getAtomicLong(group);
        Long num = atomicLong.addAndGet(1L);
        StringBuffer result = new StringBuffer();

        if(num == 0) {
            result.append("0");
        }
        while(num > 0) {
            result.append(ALPHABET[num.intValue() % 26]);
            num = num / 26;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {

    }

}
