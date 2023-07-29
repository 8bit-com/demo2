package com.example.demo;

import com.bft.springtarantoolapi.model.IisMessageRecived;
import com.bft.springtarantoolapi.model.IisMessageToSmev;
import com.bft.springtarantoolapi.service.IisMessageToSmevService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/IisMessageToSmevService")
@RequiredArgsConstructor
public class IisMessageToSmevController {
    private final IisMessageToSmevService iisMessageToSmevService;

    @PostMapping( "/getMessage")
    public IisMessageToSmev getMessage(@RequestBody Dto dto) {
        return iisMessageToSmevService.getMessage(dto.getValue());
    }

    @PostMapping( "/endIISMessageProcessing")
    public void endIISMessageProcessing(@RequestBody IisMessageToSmev iisMessageToSmev) {
        iisMessageToSmevService.endIISMessageProcessing(iisMessageToSmev);
    }

    @PostMapping( "/faultErrorSMEVSending")
    public void faultErrorSMEVSending(@RequestBody IisMessageToSmev iisMessageToSmev) {
        iisMessageToSmevService.faultErrorSMEVSending(iisMessageToSmev);
    }

    @PostMapping( "/httpErrorSMEVSending")
    public void httpErrorSMEVSending(@RequestBody IisMessageToSmev iisMessageToSmev) {
        iisMessageToSmevService.httpErrorSMEVSending(iisMessageToSmev);
    }

    @PostMapping( "/endSMEVSending")
    public void endSMEVSending(@RequestBody IisMessageToSmev iisMessageToSmev) {
        iisMessageToSmevService.endSMEVSending(iisMessageToSmev);
    }
}
