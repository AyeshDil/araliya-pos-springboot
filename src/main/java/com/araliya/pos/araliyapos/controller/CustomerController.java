package com.araliya.pos.araliyapos.controller;

import com.araliya.pos.araliyapos.dto.CustomerDTO;
import com.araliya.pos.araliyapos.dto.request.CustomerSaveRequestDTO;
import com.araliya.pos.araliyapos.dto.request.CustomerUpdateRequestDTO;
import com.araliya.pos.araliyapos.service.CustomerService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

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

    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerUpdateRequestDTO customerUpdateRequestDTO){
        String updated= customerService.updateCustomerDetails(customerUpdateRequestDTO);
        return updated;
    }

    @GetMapping(
            path = {"/get-by-id"},
            params = {"id"}
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerID){
        CustomerDTO customerDTO = customerService.getCustomerById(customerID);
        return customerDTO;
    }

    @GetMapping(path = {"/get-all-customer"})
    public List<CustomerDTO> getAllCustomer(){
        List<CustomerDTO> customerDTOList = customerService.getAllCustomers();
        return customerDTOList;
    }

    @DeleteMapping(
            path = {"/delete-by-id"},
            params = "id"
    )
    public String deleteCustomerById(@RequestParam(value = "id") int customerId) throws NotFoundException {
        boolean isDeleted = customerService.deleteCustomerById(customerId);
        return null;
    }
}
