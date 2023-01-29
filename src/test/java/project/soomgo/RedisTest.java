package project.soomgo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import project.soomgo.redis.RedisProperties;

@SpringBootTest
@Slf4j
public class RedisTest {

    @Autowired
    private RedisProperties redisProperties;

    @Test
    public void redisTest() {

        String host = redisProperties.getHost();
        int port = redisProperties.getPort();

        Assertions.assertThat(host).isEqualTo("127.0.0.1");
        Assertions.assertThat(port).isEqualTo(6379);
    }
}
