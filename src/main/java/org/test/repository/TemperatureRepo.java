package org.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.test.model.Temperature;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Yuriy Phediv on 28.03.2017.
 */
public interface TemperatureRepo extends CrudRepository<Temperature,Long> {
    List<Temperature> findByTimestampAfter(LocalDateTime localDateTime);
}
