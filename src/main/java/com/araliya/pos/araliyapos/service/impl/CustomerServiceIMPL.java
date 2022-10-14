package com.araliya.pos.araliyapos.service.impl;

import com.araliya.pos.araliyapos.dto.CustomerDTO;
import com.araliya.pos.araliyapos.dto.request.CustomerSaveRequestDTO;
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
    public String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO) {
        Customer customer = new Customer(
                customerSaveRequestDTO.getCustomerName(),
                customerSaveRequestDTO.getCustomerAddress(),
                customerSaveRequestDTO.getSalary(),
                customerSaveRequestDTO.getContactNumbers(),
                true
        );

        customerRepo.save(customer);

        return customer.getCustomerName()+ " saved";
    }
}
