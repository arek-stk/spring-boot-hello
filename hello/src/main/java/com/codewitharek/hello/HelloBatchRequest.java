package com.codewitharek.hello;

import java.util.List;

public class HelloBatchRequest {
    private List<String> names;

    public HelloBatchRequest() {}
    public List<String> getNames() {
        return names;
    }
    public void setNames(List<String> names) {
        this.names = names;
    }
}
