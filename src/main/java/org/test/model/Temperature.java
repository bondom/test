package org.test.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by Yuriy Phediv on 28.03.2017.
 */
@Entity
@Table(name = "temperature")
public class Temperature {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @NotNull
    @Column
    private Double temperature;

    @NotNull
    @Column
    private LocalDateTime timestamp;

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
