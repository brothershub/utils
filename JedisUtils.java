import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author ishiningway
 * jedis  redis数据库连接池工具类
 *
 * */
public class JedisUtils {

    //定义连接池对象
    private static JedisPool JEDISPOOL;

    static{
        //初始化连接池对象设置
        JedisPoolConfig jpConfig = new JedisPoolConfig();
        //池中最大连接数
        jpConfig.setMaxTotal(100);
        //池中最大对象数
        jpConfig.setMaxIdle(10);
        //设置连接对象
        JedisPool pool = new JedisPool("127.0.0.1",6379);
    }

    /**
     * 从池中获取链接
     * */
    public static Jedis getJedis(){
        return JEDISPOOL.getResource();
    }
}
