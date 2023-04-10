package br.com.fink.vendedorapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

@Configuration
public class MongoConfig {
	
	/* Retirar _class no documento */
	@Bean
	@Primary
	public MongoTemplate mongoTemplate(MongoDatabaseFactory mongoDatabaseFactory, MappingMongoConverter mappingMongoConverter) {
		mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));		
		return new MongoTemplate(mongoDatabaseFactory, mappingMongoConverter);		
	}
}
