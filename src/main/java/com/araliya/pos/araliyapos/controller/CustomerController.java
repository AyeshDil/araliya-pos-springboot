package com.araliya.pos.araliyapos.controller;

import com.araliya.pos.araliyapos.dto.CustomerDTO;
import com.araliya.pos.araliyapos.dto.request.CustomerSaveRequestDTO;
import com.araliya.pos.araliyapos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerSaveRequestDTO customerSaveRequestDTO){
        String id = customerService.addCustomer(customerSaveRequestDTO);
        return id;
    }
}
