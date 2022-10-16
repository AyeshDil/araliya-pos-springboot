package com.araliya.pos.araliyapos.service;

import com.araliya.pos.araliyapos.dto.CustomerDTO;
import com.araliya.pos.araliyapos.dto.request.CustomerSaveRequestDTO;
import com.araliya.pos.araliyapos.dto.request.CustomerUpdateRequestDTO;
import javassist.NotFoundException;

import java.util.List;

public interface CustomerService {
    String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO);

    String updateCustomerDetails(CustomerUpdateRequestDTO customerUpdateRequestDTO);

    CustomerDTO getCustomerById(int customerID);

    List<CustomerDTO> getAllCustomers();

    boolean deleteCustomerById(int customerId) throws NotFoundException;
}
