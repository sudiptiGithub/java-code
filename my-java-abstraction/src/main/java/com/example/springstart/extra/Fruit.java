package com.example.springstart.extra;

import com.sun.istack.internal.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
public class Fruit {

    @NotNull
    String name;

    @NotNull
    String taste;

}
