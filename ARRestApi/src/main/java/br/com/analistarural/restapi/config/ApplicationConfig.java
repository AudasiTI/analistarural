package br.com.analistarural.restapi.config;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

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

	  @Bean
	    @Primary
	    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {

	        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
	        template.setConnectionFactory(factory);
	        template.setValueSerializer(new OptionalJsonRedisSerializer());
	        template.setKeySerializer(new StringRedisSerializer());
	        return template;
	    }

	    @Bean
	    @Autowired
	    public CacheManager cacheManager(RedisTemplate<String, Object> redisTemplate) {
	        return new RedisCacheManager(redisTemplate);
	    }

	    @Bean
	    public ObjectMapper objectMapper() {
	        return new ObjectMapper()
	                .registerModule(new JSR310Module())
	                .registerModule(new Jdk8Module());
	    }

	    @Bean
	    public ApiAuthorization apiAuthorization() throws IOException {
	        byte[] bytes = IOUtils.toByteArray(getClass().getResourceAsStream("/AuthorizationServerConfiguration.json"));
	        return objectMapper().readValue(bytes, ApiAuthorization.class);
	    }
}
