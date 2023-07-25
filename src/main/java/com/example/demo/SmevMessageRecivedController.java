package com.example.demo;

import com.bft.springtarantoolapi.model.IisMessageRecived;
import com.bft.springtarantoolapi.model.IisMessageToSmev;
import com.bft.springtarantoolapi.model.SmevMessageRecived;
import com.bft.springtarantoolapi.model.SmevMessageToIis;
import com.bft.springtarantoolapi.service.IisMessageRecivedService;
import com.bft.springtarantoolapi.service.IisMessageToSmevService;
import com.bft.springtarantoolapi.service.SmevMessageToIisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.bft.springtarantoolapi.service.SmevMessageRecivedService;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/SmevMessageRecivedService")
@RequiredArgsConstructor
public class SmevMessageRecivedController {

    private final SmevMessageRecivedService smevMessageRecivedService;

    @PostMapping( "/getMessage")
    public SmevMessageRecived getMessage(@RequestBody Dto dto) {
        return smevMessageRecivedService.getMessage(dto.getId());
    }

    @GetMapping( "/get_all_smev_message_recived")
    public List<SmevMessageRecived> getAll() {
        return smevMessageRecivedService.get_all_smev_message_recived();
    }

    @PostMapping( "/checkExistSMEVMessage")
    public Boolean checkExistSMEVMessage(@RequestBody SmevMessageRecived smevMessageRecived) {
        return smevMessageRecivedService.checkExistSMEVMessage(smevMessageRecived);
    }

    @PostMapping( "/get_smev_message_recived")
    public SmevMessageRecived get_smev_message_recived(@RequestBody SmevMessageRecived smevMessageRecived) {
        return smevMessageRecivedService.get_smev_message_recived(smevMessageRecived);
    }

    @PostMapping( "/saveSMEVMessage")
    public void saveSMEVMessage(@RequestBody SmevMessageRecived smevMessageRecived) {
        ZonedDateTime dateTime = ZonedDateTime.now();
        smevMessageRecived.setDeliveryTimeStamp(dateTime);
        smevMessageRecivedService.saveSMEVMessage(smevMessageRecived);
    }

    @PostMapping( "/saveAckRequest")
    public void saveAckRequest(@RequestBody SmevMessageRecived smevMessageRecived) {
        smevMessageRecivedService.saveAckRequest(smevMessageRecived);
    }

    @PostMapping( "/faultErrorAckSending")
    public void faultErrorAckSending(@RequestBody SmevMessageRecived smevMessageRecived) {
        smevMessageRecivedService.faultErrorAckSending(smevMessageRecived);
    }

    @PostMapping( "/faultErrorProcessingSmev")
    public void faultErrorProcessingSmev(@RequestBody SmevMessageRecived smevMessageRecived) {
        smevMessageRecivedService.faultErrorProcessingSmev(smevMessageRecived);
    }

    @PostMapping( "/httpErrorAckSending")
    public void httpErrorAckSending(@RequestBody SmevMessageRecived smevMessageRecived) {
        smevMessageRecivedService.httpErrorAckSending(smevMessageRecived);
    }

    @PostMapping( "/endAckSending")
    public void endAckSending(@RequestBody SmevMessageRecived smevMessageRecived) {
        smevMessageRecivedService.endAckSending(smevMessageRecived);
    }
}
