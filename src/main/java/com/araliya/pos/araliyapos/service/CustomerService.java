package com.araliya.pos.araliyapos.service;

import com.araliya.pos.araliyapos.dto.CustomerDTO;
import com.araliya.pos.araliyapos.dto.request.CustomerSaveRequestDTO;

public interface CustomerService {
    String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO);

}
