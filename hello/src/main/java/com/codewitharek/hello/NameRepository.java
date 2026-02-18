package com.codewitharek.hello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
public interface NameRepository extends JpaRepository<NameEntity, Long> {
    Page<NameEntity> findByNameContainingIgnoreCase(String name, Pageable pageable );
}
