package com.araliya.pos.araliyapos.controller;

import com.araliya.pos.araliyapos.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {

    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){

        return null;
    }
}
