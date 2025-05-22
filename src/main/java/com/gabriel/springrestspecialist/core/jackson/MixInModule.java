package com.gabriel.springrestspecialist.core.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.gabriel.springrestspecialist.api.mixin.RestaurantMixIn;
import com.gabriel.springrestspecialist.domain.model.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class MixInModule extends SimpleModule {
    public MixInModule() {
        setMixInAnnotation(Restaurant.class, RestaurantMixIn.class);
    }
}
