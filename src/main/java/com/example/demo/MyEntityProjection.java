package com.example.demo;

import org.springframework.beans.factory.annotation.Value;

public interface MyEntityProjection {

    @Value("static value")
    //@Value("#{@myBean.getName()}")
    public String getName();
}
