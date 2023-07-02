package com.example.demo;

import com.bft.springtarantoolapi.model.IisMessageRecived;
import com.bft.springtarantoolapi.model.SmevMessageRecived;
import com.bft.springtarantoolapi.service.IisMessageRecivedService;
import com.bft.springtarantoolapi.service.SmevMessageRecivedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/IisMessageRecivedService")
@RequiredArgsConstructor
public class IisMessageRecivedController {

    private final IisMessageRecivedService iisMessageRecivedService;

    @PostMapping( "/saveIISRequest")
    public void saveSMEVMessage(@RequestBody IisMessageRecived iisMessageRecived) {
        System.out.println(iisMessageRecived);
        ZonedDateTime dateTime = ZonedDateTime.now();
        iisMessageRecived.setStartProcessingDate(dateTime);
        iisMessageRecivedService.saveIISRequest(iisMessageRecived);
    }
}
