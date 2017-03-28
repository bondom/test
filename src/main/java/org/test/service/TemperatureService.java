package org.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.test.model.Temperature;
import org.test.repository.TemperatureRepo;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;

/**
 * Created by Yuriy Phediv on 28.03.2017.
 */

@Service
@Transactional
public class TemperatureService {

    @Autowired
    private TemperatureRepo tempRepo;

    public Double getAverageTemp(){
        OptionalDouble optDouble =
                tempRepo.findByTimestampAfter(LocalDateTime.now().minusHours(1))
                        .stream().mapToDouble(tempObj -> tempObj.getTemperature()).average();
        return optDouble.isPresent() ? optDouble.getAsDouble() : 0.0;
    }


    @Scheduled(fixedDelay = 10000)
    public void generateAndStoreNewTemperature(){
        Temperature temperature = new Temperature();
        temperature.setTimestamp(LocalDateTime.now());
        temperature.setTemperature((new Random().nextDouble())*100);
        tempRepo.save(temperature);
    }
}
