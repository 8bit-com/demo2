package com.example.demo;

import com.bft.springtarantoolapi.model.IisMessageRecived;
import com.bft.springtarantoolapi.model.SmevMessageRecived;
import com.bft.springtarantoolapi.model.SmevMessageToIis;
import com.bft.springtarantoolapi.service.IisMessageRecivedService;
import com.bft.springtarantoolapi.service.SmevMessageToIisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("/SmevMessageToIisService")
@RequiredArgsConstructor
public class SmevMessageToIisController {
    private final SmevMessageToIisService smevMessageToIisService;

    @PostMapping( "/getMessage")
    public SmevMessageToIis getMessage(@RequestBody Dto dto) {
        return smevMessageToIisService.getMessage(dto.getId());
    }

    @PostMapping( "/endSMEVMessageProcessing")
    public void endSMEVMessageProcessing(@RequestBody SmevMessageToIis smevMessageToIis) {
        smevMessageToIisService.endSMEVMessageProcessing(smevMessageToIis);
    }

    @PostMapping( "/faultErrorIISSmev")
    public void faultErrorIISSmev(@RequestBody SmevMessageToIis smevMessageToIis) {
        smevMessageToIisService.faultErrorIISSmev(smevMessageToIis);
    }
}