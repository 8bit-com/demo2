package com.example.demo;

import com.bft.springtarantoolapi.service.SharedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SharedService")
@RequiredArgsConstructor
public class SharedController {
    private final SharedService sharedService;

    @PostMapping( "/getField")
    public String getField(@RequestBody Dto dto) {
        System.out.println(dto.getSpace() + dto.getId() + dto.getField());
        String str = sharedService.getField(dto.getSpace(), dto.getId(), dto.getField());
        System.out.println(str);
        return str;
    }

    @PostMapping( "/deleteMessage")
    public void deleteMessage(@RequestBody Dto dto) {
        sharedService.deleteMessage(dto.getSpace(), dto.getId());
    }

    @PostMapping( "/getCount")
    public Integer getCount(@RequestBody Dto dto) {
        return sharedService.getCount(dto.getSpace());
    }

    @PostMapping( "/selectMsg")
    public String selectMsg(@RequestBody Dto dto) {
        return sharedService.selectMsg(dto.getSpace(), dto.getField(), dto.getId());
    }
}
