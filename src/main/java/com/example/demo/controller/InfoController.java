package com.example.demo.controller;

import com.example.demo.model.Hello;
import com.example.demo.model.KnativeServingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/info")
public class InfoController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "", method = RequestMethod.GET)
    public KnativeServingInfo info() {
        LOG.info("Collecting info");

        String host = System.getenv("HOSTNAME");
        String service = System.getenv("K_SERVICE");
        String revision = System.getenv("K_REVISION");
        String configuration = System.getenv("K_CONFIGURATION");
        return new KnativeServingInfo(host, service, revision, configuration);
    }
}
