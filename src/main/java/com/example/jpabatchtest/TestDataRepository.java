package com.example.jpabatchtest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDataRepository extends JpaRepository<TestData, Long> {
}
