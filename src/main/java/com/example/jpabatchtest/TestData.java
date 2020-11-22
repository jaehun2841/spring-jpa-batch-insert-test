package com.example.jpabatchtest;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

@Entity
public class TestData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "test-sequence-generator")
    @GenericGenerator(
            name = "test-sequence-generator",
            strategy = "sequence",
            parameters = {
                    @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM, value = SequenceStyleGenerator.DEF_SEQUENCE_NAME),
                    @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM, value = "1"),
                    @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "20000"),
                    @Parameter(name = AvailableSettings.PREFERRED_POOLED_OPTIMIZER, value = "pooled-lo")
            }
    )
    private final Long id;
    @Column(name = "uuid")
    private final String uuid;
    @Column(name = "created_at")
    private final LocalDateTime createdAt;

    private TestData() {
        this.id = 0L;
        this.uuid = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

    public static TestData create() {
        return new TestData();
    }
}
