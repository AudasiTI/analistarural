package br.com.analistarural.restapi.config;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import br.com.analistarural.restapi.helper.ApiAuthorization;
import br.com.analistarural.restapi.helper.OptionalJsonRedisSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

@Configuration
@EnableCaching
@ComponentScan(basePackages = "br.com.analistarural.restapi")
@Import(br.com.analistarural.domain.config.ApplicationConfig.class)
public class ApplicationConfig {

//	@Bean
//	@Override
//	public KeyGenerator keyGenerator() {
//		return (target, method, params) -> {
//			StringBuilder sb = new StringBuilder();
//			sb.append(target.getClass().getName());
//			sb.append(method.getName());
//			for (Object obj : params) {
//				sb.append(obj.toString());
//			}
//			return sb.toString();
//		};
//	}

    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }
    
	@Bean
	@Primary
	public RedisTemplate<String, Object> redisTemplate(
			RedisConnectionFactory factory) {

		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(factory);
		//template.setValueSerializer(new OptionalJsonRedisSerializer());
		//template.setKeySerializer(new StringRedisSerializer());
		return template;
	}

	@Bean
	@Autowired
	public CacheManager cacheManager(RedisTemplate<String, Object> redisTemplate) {
		return new RedisCacheManager(redisTemplate);
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper().registerModule(new JSR310Module())
				.registerModule(new Jdk8Module());
	}

	@Bean
	public ApiAuthorization apiAuthorization() throws IOException {
		byte[] bytes = IOUtils.toByteArray(getClass().getResourceAsStream(
				"/AuthorizationServerConfiguration.json"));
		return objectMapper().readValue(bytes, ApiAuthorization.class);
	}

}