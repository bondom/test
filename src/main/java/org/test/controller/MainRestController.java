package org.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.test.response.AverageTemperature;
import org.test.service.TemperatureService;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yuriy Phediv on 28.03.2017.
 */
@RestController
public class MainRestController {

    @Autowired
    private TemperatureService tempService;

    @GetMapping("/average")
    public AverageTemperature getAverageTemp(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin","*");
        return new AverageTemperature(tempService.getAverageTemp());
    }
}
