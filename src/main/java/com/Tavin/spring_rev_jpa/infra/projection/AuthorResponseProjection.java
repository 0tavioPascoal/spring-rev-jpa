package com.Tavin.spring_rev_jpa.infra.projection;

import org.springframework.beans.factory.annotation.Value;

public interface AuthorResponseProjection{

    @Value("#{targer.name + '' + target.lastName}")
    String getCompletedName = "";

    @Value("#{target.cargo}")
    String getCargo = "";

    @Value("#{target.bio}")
    String getBio = "";
}
