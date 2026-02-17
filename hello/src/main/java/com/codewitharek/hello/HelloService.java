package com.codewitharek.hello;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloService {

    private final NameRepository nameRepository;

    public HelloService(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    public HelloResponse addName(String name) {
        nameRepository.save(new NameEntity(name));
        long count = nameRepository.count();
        return new HelloResponse("Hallo " + name + "!", (int) count);
    }

    public HelloListResponse getNames() {
        List<String> names = nameRepository.findAll()
                .stream()
                .map(NameEntity::getName)
                .toList();

        return new HelloListResponse(names, names.size());
    }
}
