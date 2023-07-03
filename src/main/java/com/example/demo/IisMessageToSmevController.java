package com.example.demo;

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

    @PostMapping( "/endIISMessageProcessing")
    public void endIISMessageProcessing(@RequestBody IisMessageToSmev iisMessageToSmev) {
        iisMessageToSmevService.endIISMessageProcessing(iisMessageToSmev);
    }
}
