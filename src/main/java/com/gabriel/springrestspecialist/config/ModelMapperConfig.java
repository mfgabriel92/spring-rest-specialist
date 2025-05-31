package com.gabriel.springrestspecialist.config;

import com.gabriel.springrestspecialist.api.response.AddressResponse;
import com.gabriel.springrestspecialist.domain.model.Address;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        var mapper = new ModelMapper();

        mapper.getConfiguration().setAmbiguityIgnored(true);
        mapper.typeMap(Address.class, AddressResponse.class).addMappings(m -> {
            m.map(src -> src.getCity().getName(), AddressResponse::setCityName);
            m.map(src -> src.getCity().getState().getName(), AddressResponse::setCityStateName);
        });

        return mapper;
    }
}
