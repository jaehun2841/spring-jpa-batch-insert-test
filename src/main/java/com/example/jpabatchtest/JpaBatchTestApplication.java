package com.example.jpabatchtest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.util.StopWatch;

@EntityScan
@EnableJpaRepositories
@SpringBootApplication
public class JpaBatchTestApplication implements CommandLineRunner {
    @Autowired
    TestDataRepository testDataRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaBatchTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<TestData> testDataList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            testDataList.add(TestData.create());
        }
        testDataRepository.saveAll(testDataList);
        stopWatch.stop();
        long totalTimeMillis = stopWatch.getTotalTimeMillis();
        System.out.println("total time : " + totalTimeMillis);
    }
}
