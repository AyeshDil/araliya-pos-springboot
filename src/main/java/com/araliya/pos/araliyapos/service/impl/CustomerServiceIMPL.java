package com.araliya.pos.araliyapos.service.impl;

import com.araliya.pos.araliyapos.dto.CustomerDTO;
import com.araliya.pos.araliyapos.entity.Customer;
import com.araliya.pos.araliyapos.repository.CustomerRepo;
import com.araliya.pos.araliyapos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String addCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getSalary(),
                customerDTO.getContactNumbers(),
                customerDTO.isActiveState()
        );

        customerRepo.save(customer);

        return customer.getCustomerName()+ " saved";
    }
}
