package com.example.demo;

import com.bft.springtarantoolapi.model.SmevMessageRecived;
import org.springframework.web.bind.annotation.*;

import com.bft.springtarantoolapi.service.SmevMessageRecivedService;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/SmevMessageRecivedService")
public class SmevMessageRecivedController {
    private final SmevMessageRecivedService smevMessageRecivedService;

    public SmevMessageRecivedController(SmevMessageRecivedService smevMessageRecivedService) {
        this.smevMessageRecivedService = smevMessageRecivedService;
    }

    @PostMapping( "/saveSMEVMessage")
    public void saveSMEVMessage(@RequestBody SmevMessageRecived smevMessageRecived) {
        System.out.println(smevMessageRecived);
        ZonedDateTime dateTime = ZonedDateTime.now();
        smevMessageRecived.setDeliveryTimeStamp(dateTime);
        System.out.println(smevMessageRecived.getDeliveryTimeStamp().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        smevMessageRecivedService.saveSMEVMessage(smevMessageRecived);
    }

    @GetMapping( "/getAll")
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

    @PostMapping( "/saveAckRequest")
    public void saveAckRequest(@RequestBody SmevMessageRecived smevMessageRecived) {
        smevMessageRecivedService.saveAckRequest(smevMessageRecived);
    }

    @PostMapping( "/faultErrorAckSending")
    public void faultErrorAckSending(@RequestBody SmevMessageRecived smevMessageRecived) {
        smevMessageRecivedService.faultErrorAckSending(smevMessageRecived);
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
