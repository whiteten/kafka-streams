package com.example.kafkastreams.service;


import java.util.function.Consumer;

import org.apache.kafka.streams.kstream.KStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;



import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class KafkaService {

	private Jackson2JsonObjectMapper mapper = new Jackson2JsonObjectMapper();

	@Bean
	public Consumer<KStream<String, String>> process() {

		return input -> input.foreach((key, value) -> {
			log.info("받은 =>" + value.toString());

			// CdrData get = mapper.fromJson(value.toString(), CdrData.class);

		});
	}

}
