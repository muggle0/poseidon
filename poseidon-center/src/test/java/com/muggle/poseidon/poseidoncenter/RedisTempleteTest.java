package com.muggle.poseidon.poseidoncenter;

import com.muggle.poseidon.entity.EmailBean;
import io.lettuce.core.api.async.RedisAsyncCommands;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

public class RedisTempleteTest extends PoseidonCenterApplicationTests {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void test1() {
       /* DefaultRedisScript<List> script = new DefaultRedisScript<>();
        script.setResultType(List.class);
        script.setScriptSource(new ResourceScriptSource(new ClassPathResource("luascript/LimitLoadTimes.lua"))););
        redisTemplate.*/
    }

    @Test
    public void sendSimpleMail() {
        EmailBean mailBean = new EmailBean();
        StringBuffer context = new StringBuffer();
        context.append("<h3> 我觉得你是个铁憨憨，还处对象，回家种田吧兄弟</h3><br>");
        context.append(mailBean.getSubject());
        mailBean.setRecipient("1977339740@qq.com");
        mailBean.setSubject(context.toString());
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //邮件发送人
        simpleMailMessage.setFrom("1977339740@qq.com(poseidon)");
        //邮件接收人
        simpleMailMessage.setTo(mailBean.getRecipient());
        //邮件主题
        simpleMailMessage.setSubject(mailBean.getSubject());
        //邮件内容
        simpleMailMessage.setText(mailBean.getContent());
        javaMailSender.send(simpleMailMessage);
    }

    @Test
    public void test() throws InterruptedException {
        Thread thread = new Thread() {
            public void run() {
                System.out.println("thread start");
                System.out.println(isInterrupted());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("-------" + isInterrupted());
                }
                System.out.println("校验打断---" + isInterrupted());
                System.out.println("thread end");
            }
        };
        thread.start();
        System.out.println("main start");
//        Thread.sleep(200);
        System.out.println("begin interrupt");
        thread.interrupt();
        System.out.println("mian 中查看" + thread.isInterrupted());
    }

    @Test
    public void test2() {
        Thread thread = new Thread() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("跑 thread");
                }
            }
        };
        thread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("跑 main");
        }
        System.out.println("hhhhhh");
    }


   /* private boolean setNx(String key, String value, long expiredTime) {
        Boolean resultBoolean = null;
        try {
            resultBoolean = stringRedisTemplate.execute((RedisCallback<Boolean>) connection -> {
                Object nativeConnection = connection.getNativeConnection();
                Boolean redisResult = null;
                RedisSerializer<String> stringRedisSerializer = (RedisSerializer<String>) stringRedisTemplate.getKeySerializer();
                //lettuce连接包下序列化键值，否知无法用默认的ByteArrayCodec解析
                byte[] keyByte = stringRedisSerializer.serialize(key);
                byte[] valueByte = stringRedisSerializer.serialize(value);
                // lettuce连接包下 redis 单机模式setnx
                if (nativeConnection instanceof RedisAsyncCommands) {
                    RedisAsyncCommands commands = (RedisAsyncCommands)nativeConnection;
//                    commands.setTimeout(expiredTime, TimeUnit.MILLISECONDS);
                    //同步方法执行、setnx禁止异步 000000000000000000000
                    redisResult = commands
                            .getStatefulConnection()
                            .sync()
                            .setnx(keyByte, valueByte);
//                    commands.getStatefulConnection().sync().psetex()
                }
                // lettuce连接包下 redis 集群模式setnx
                if (nativeConnection instanceof RedisAdvancedClusterAsyncCommands) {
                    RedisAdvancedClusterAsyncCommands clusterAsyncCommands = (RedisAdvancedClusterAsyncCommands) nativeConnection;
//                    clusterAsyncCommands.setTimeout(expiredTime, TimeUnit.MILLISECONDS);
                    redisResult = clusterAsyncCommands
                            .getStatefulConnection()
                            .sync()
                            .setnx(keyByte, keyByte);
                }
                //返回加锁结果
                return "OK".equalsIgnoreCase(redisResult);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultBoolean != null && resultBoolean;
    }*/

  /*  @Test
    public void test3(){
        stringRedisTemplate.opsForValue().
        boolean b = setNx("ss", "b", 100000000L);
        System.out.println(b+">>>>>>>>>>>>>>");
//        Boolean ss = redisTemplate.delete("ss");
//        System.out.println(ss+">>>>>>>>>>>>>>");

    }*/

    /* public boolean lock(final String lockKey, final String value) throws InterruptedException {
         boolean result = false;
         String script = "local key = KEYS[1]; local value = ARGV[1]; if redis.call('set', key, value, 'NX' ,'EX', ARGV[2]) then return 1 else return 0 end";
         DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
         Long execute = (Long) redisTemplate.execute(redisScript, Collections.singletonList(lockKey), value,
                 commonConfig.getRedisLockTimeout());
         if (execute != null && execute > 0) {
             result = true;
         }
         return result;
     }*/
    @Test
    public void test4() {
        String key = "aa";
        String value = "bb";
        Boolean execute = stringRedisTemplate.execute((RedisCallback<Boolean>) connection -> {
            Object nativeConnection = connection.getNativeConnection();
            RedisSerializer<String> stringRedisSerializer = (RedisSerializer<String>) stringRedisTemplate.getKeySerializer();
            byte[] keyByte = stringRedisSerializer.serialize(key);
            byte[] valueByte = stringRedisSerializer.serialize(value);
            if (nativeConnection instanceof RedisAsyncCommands) {
                RedisAsyncCommands commands = (RedisAsyncCommands) nativeConnection;
                commands.setTimeout(1, TimeUnit.MILLISECONDS);
                Boolean setnx = commands.getStatefulConnection().sync().setnx(keyByte, valueByte);
                return setnx;
            }
            return false;
        });
        System.out.println(execute);
    }

    @Test
    public void test5() {
        String key = "wws";
        Long expire = stringRedisTemplate.getExpire(key);
        System.out.println(expire);
        System.out.println(stringRedisTemplate.opsForValue().get(key));
        String value = "bb";
        Long expiredTime = 1110L;
        Boolean execute = stringRedisTemplate.execute((RedisCallback<Boolean>) connection -> {
            RedisSerializer<String> stringRedisSerializer = (RedisSerializer<String>) stringRedisTemplate.getKeySerializer();
            byte[] keyByte = stringRedisSerializer.serialize(key);
            byte[] valueByte = stringRedisSerializer.serialize(value);
            Boolean aBoolean = connection.setNX(keyByte, valueByte);
            return aBoolean;
        });
//        如果key 不存在 发生场景 setnx 的时候 值存在 setnx失败，然后瞬间key过期消失
        if (expire != null && expire == -2) {

        }
        if (expire != null && (expire == -1 || expire > expiredTime)) {
            stringRedisTemplate.expire(key, expiredTime, TimeUnit.MILLISECONDS);
        }
        if (execute) {
            stringRedisTemplate.expire(key, expiredTime, TimeUnit.MILLISECONDS);
        } else {
            if (expire != null && (expire == -1 || expire > expiredTime)) {
                stringRedisTemplate.expire(key, expiredTime, TimeUnit.MILLISECONDS);
            }
        }

        expire = stringRedisTemplate.getExpire(key);
        System.out.println(expire);
        if (execute) {
//            stringRedisTemplate.expire()
        }

        System.out.println(execute);
    }

    /**
     * @Description: 应该使用setnx上锁
     * 原因：虽然redis是单线程，但是对lettuce而言代码不是单线程执行的，如果不使用setnx 无法保证其原子性；
     * 如果先get 再set 会有这样的情况发生：（进程）线程一get 没有值，（进场）线程二 get 也没有值，同时set 都上锁成功，导致锁失效；
     * setnx就不会存在这一问题，setnx为一个命令，redis是单线程的，只会有一个线程或者进程在执行这个命令
     * 也可使用lua脚本实现，未成功原因是序列化器的问题 附上 lettuce 资料后期研究lua脚本方式
     * <p>
     * https://lettuce.io/core/release/reference/index.html#command-interfaces.synchronous
     * @Param:
     * @return:
     */
    public boolean lockBysetNx(String key, String value, long expiredTime) {
        Boolean execute = stringRedisTemplate.execute((RedisCallback<Boolean>) connection -> {
            RedisSerializer<String> stringRedisSerializer = (RedisSerializer<String>) stringRedisTemplate.getKeySerializer();
            byte[] keyByte = stringRedisSerializer.serialize(key);
            byte[] valueByte = stringRedisSerializer.serialize(value);
            Boolean aBoolean = connection.setNX(keyByte, valueByte);
            return aBoolean;
        });
        Long expire = stringRedisTemplate.getExpire(key);
        if (execute) {
            stringRedisTemplate.expire(key, expiredTime, TimeUnit.MILLISECONDS);
        } else {
            if (expire != null && (expire == -1 || expire > expiredTime)) {
                stringRedisTemplate.expire(key, expiredTime, TimeUnit.MILLISECONDS);
            }
        }
        return execute;
    }

    @Test
    public void test6() {
        boolean b = lockBysetNx("a1", "a1", 100);
        System.out.println(b);
        Boolean a1 = stringRedisTemplate.delete("a1");
        System.out.println(a1);
        boolean c = lockBysetNx("a1", "a1", 100);
        System.out.println(c);
        String a11 = stringRedisTemplate.opsForValue().get("a1");
        System.out.println(a11);
        boolean bb = lockBysetNx("a1", "a1", 100);
        System.out.println(bb);
    }

    @Test
    public void lua() {
        String key = "ss";
        String value = "ssssdasda";
        StringBuilder sb = new StringBuilder();
        sb.append("if redis.call(\"get\",KEYS[1]) == ARGV[1] ");
        sb.append("then ");
        sb.append("    return redis.call(\"del\",KEYS[1]) ");
        sb.append("else ");
        sb.append("    return 0 ");
        sb.append("end ");
        String UNLOCK_LUA = sb.toString();
        RedisCallback<Boolean> callback = (connection) -> {
            return connection.eval(UNLOCK_LUA.getBytes(), ReturnType.BOOLEAN, 1, key.getBytes(Charset.forName("UTF-8")), value.getBytes(Charset.forName("UTF-8")));
        };
        Boolean execute = stringRedisTemplate.execute(callback);
        System.out.println(execute);
    }

    @Test
    public void lua2() {
        String key = "sas";
        String value = "sssss";
        String test = "10000";
        StringBuilder sb = new StringBuilder();
        sb.append("if redis.call(\"setnx\",KEYS[1],ARGV[1])==1 ");
        sb.append("then ");
        sb.append("    redis.call(\"pexpire\",KEYS[1],KEYS[2]) ");
//        sb.append("    return redis.call(\"del\",KEYS[1]) ");
        sb.append("    return 1 ");
        sb.append("else ");
        sb.append("    return 0 ");
        sb.append("end ");
        String UNLOCK_LUA = sb.toString();
        RedisCallback<Boolean> callback = (connection) -> {
            return connection.eval(UNLOCK_LUA.getBytes(), ReturnType.BOOLEAN, 2, key.getBytes(Charset.forName("UTF-8")), test.getBytes(Charset.forName("UTF-8")), value.getBytes(Charset.forName("UTF-8")));
        };
        Boolean execute = stringRedisTemplate.execute(callback);
        System.out.println(execute);
    }

    @Test
    public void lua3() {
        String key = "ss";
        String value = "ssss";
        StringBuilder sb = new StringBuilder();
        sb.append("redis.call(\"set\",KEYS[1],KEYS[2])");
        sb.append("return true");

        String UNLOCK_LUA = sb.toString();
        RedisCallback<Boolean> callback = (connection) -> {
            return connection.eval(UNLOCK_LUA.getBytes(), ReturnType.BOOLEAN, 2, key.getBytes(Charset.forName("UTF-8")), value.getBytes(Charset.forName("UTF-8")));
        };
        Boolean execute = stringRedisTemplate.execute(callback);
        System.out.println(execute);
    }

    @Test
    public void lua4() {
        String key="test";
        String value="test";
        StringBuilder sb = new StringBuilder();
        sb.append("if redis.call(\"get\",KEYS[1])==ARGV[1] ");
        sb.append("then ");
        sb.append("    return redis.call(\"del\",KEYS[1]) ");
        sb.append("else ");
        sb.append("    return 1 ");
        sb.append("end ");
        String script = sb.toString();
        RedisCallback<Boolean> callback = (connection) -> {
            return connection.eval(script.getBytes(), ReturnType.BOOLEAN, 1, key.getBytes(Charset.forName("UTF-8")), value.getBytes(Charset.forName("UTF-8")));
        };
        Boolean execute = stringRedisTemplate.execute(callback);
        System.out.println(execute);
    }

    @Test
    public void  testBigDecimal(){
        BigDecimal bigDecimal = new BigDecimal(0);
        bigDecimal.add(null);
    }
}
