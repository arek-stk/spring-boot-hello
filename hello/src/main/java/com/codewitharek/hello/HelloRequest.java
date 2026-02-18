package com.codewitharek.hello;
import jakarta.validation.constraints.NotBlank;
public class HelloRequest {
    @NotBlank(message="name darf nicht leer sein")
    private String name;

    public HelloRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
