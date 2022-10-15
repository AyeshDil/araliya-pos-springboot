package com.araliya.pos.araliyapos.service.impl;

import com.araliya.pos.araliyapos.dto.CustomerDTO;
import com.araliya.pos.araliyapos.dto.request.CustomerSaveRequestDTO;
import com.araliya.pos.araliyapos.dto.request.CustomerUpdateRequestDTO;
import com.araliya.pos.araliyapos.entity.Customer;
import com.araliya.pos.araliyapos.repository.CustomerRepo;
import com.araliya.pos.araliyapos.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

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

        return customer.getCustomerName() + " saved";
    }

    @Override
    public String updateCustomerDetails(CustomerUpdateRequestDTO customerUpdateRequestDTO) {
        if (customerRepo.existsById(customerUpdateRequestDTO.getCustomerId())) {
            Customer customer = customerRepo.getById(customerUpdateRequestDTO.getCustomerId());
            customer.setCustomerName(customerUpdateRequestDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateRequestDTO.getCustomerAddress());
            customer.setSalary(customerUpdateRequestDTO.getSalary());
            customer.setContactNumbers(customerUpdateRequestDTO.getContactNumbers());
            customer.setActiveState(customerUpdateRequestDTO.isActiveState());

            customerRepo.save(customer);
            return customer.getCustomerName() + " updated";
        } else {
            return "This customer not in the database";
        }

    }

    @Override
    public CustomerDTO getCustomerById(int customerID) {
        Optional<Customer> customer = customerRepo.findById(customerID);
        if (customer.isPresent()) {
            /*CustomerDTO customerDTO = new CustomerDTO(
                    customer.get().getCustomerId(),
                    customer.get().getCustomerName(),
                    customer.get().getCustomerAddress(),
                    customer.get().getSalary(),
                    customer.get().getContactNumbers(),
                    customer.get().isActiveState()
            );*/

            CustomerDTO customerDTO = modelMapper.map(customer.get(), CustomerDTO.class);

            return customerDTO;
        } else {
            return null;
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerRepo.findAll();
        /*List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer c: customerList){
            CustomerDTO customerDTO= new CustomerDTO(
                    c.getCustomerId(),
                    c.getCustomerName(),
                    c.getCustomerAddress(),
                    c.getSalary(),
                    c.getContactNumbers(),
                    c.isActiveState()
            );
            customerDTOList.add(customerDTO);
        }*/

        // Use model mapper to get all customers
        List<CustomerDTO> customerDTOList = modelMapper
                .map(customerList, new TypeToken<List<CustomerDTO>>(){}.getType());

        return customerDTOList;
    }
}
