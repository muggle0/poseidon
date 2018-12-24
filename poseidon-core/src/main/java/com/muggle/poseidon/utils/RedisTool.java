package com.muggle.poseidon.utils;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @program: hiram_erp
 * @description: redis锁
 * @author: muggle
 * @create: 2018-12-06 14:32
 **/
public class RedisTool {
    private RedisTemplate<String,String> redisTemplate;
   /* private static RedisTemplate redisTemplate;

    private static DefaultRedisScript<String> redisScript;

    private static RedisSerializer<String> argsSerializer;

    private static RedisSerializer resultSerializer;

    private static final Long EXEC_RESULT = 1L;




    public boolean lock(String lockKey, String requestId, int expireTime) {
        redisScript.setScriptText("if redis.call('setNx',KEYS[1],ARGV[1]) then\n" +
                "    if redis.call('get',KEYS[1])==ARGV[1] then\n" +
                "        return OK\n" +
                "    else\n" +
                "        return NO\n" +
                "    end\n" +
                "end\n");
        Object result = redisTemplate.execute(redisScript,argsSerializer,resultSerializer,Collections.singletonList(lockKey),requestId,expireTime);
        if(EXEC_RESULT.equals(result)) {
            return true;
        }
        return false;

    }


    //释放锁
    public boolean unlock(String lockKey, String requestId) {
        redisScript.setScriptText(
                "if redis.call('get',KEYS[1]) == ARGV[1] then\n" +
                " redis.call('del',KEYS[1]) return YES\n" +
                "else\n" +
                "    return NO\n" +
                "end");
        Object result = redisTemplate.execute(redisScript,argsSerializer,resultSerializer,Collections.singletonList(lockKey),requestId);
        if(EXEC_RESULT.equals(result)) {
            return true;
        }
        return false;

    }

    public RedisTool(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        redisScript = new DefaultRedisScript<String>();
        redisScript.setResultType(String.class);
        argsSerializer = new StringRedisSerializer();
        resultSerializer = new StringRedisSerializer();
        this.redisTemplate = redisTemplate;
    }*/
   public RedisTool(RedisTemplate redisTemplate) {
       this.redisTemplate=redisTemplate;
   }
    public boolean lock(String lockKey, String requestId, int expireTime) {
       try{
           String request = redisTemplate.opsForValue().get(lockKey);
           if(request==null){
               redisTemplate.opsForValue().set(lockKey,requestId);
               redisTemplate.expire(lockKey,expireTime, TimeUnit.MILLISECONDS);
               return true;
           }
           Long expire = redisTemplate.getExpire(lockKey);
           if (!(expire>0&&expire<20)){
               redisTemplate.expire(lockKey,3,TimeUnit.MILLISECONDS);
           }
           return false;
       }catch (Exception e){
           redisTemplate.delete(lockKey);
           return false;
       }

    }
    public boolean unlock(String lockKey, String requestId) {
       try {
           String request = redisTemplate.opsForValue().get(lockKey);
           if (request==null){
               return true;
           }
           redisTemplate.delete(lockKey);
           return true;
       }catch (Exception e){
           redisTemplate.delete(lockKey);
           return true;
       }
    }
}







