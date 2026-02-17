package com.codewitharek.hello;

import java.util.List;

public class HelloListResponse {

    private List<String> names;
    private int count;

    public HelloListResponse(List<String> names, int count) {
        this.names = names;
        this.count = count;
    }

    public List<String> getNames() {
        return names;
    }

    public int getCount() {
        return count;
    }
}
