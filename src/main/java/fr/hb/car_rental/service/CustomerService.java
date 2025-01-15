package fr.hb.car_rental.service;

import fr.hb.car_rental.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private static final List<Customer> customerList = new ArrayList<>();

    public List<Customer> findAllCustomers() {
        return customerList;
    }

    public Customer findCustomerById(Long id) {
        for (Customer customer : customerList) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    public void saveCustomer(Customer customer) {
        Customer existingCustomer = findCustomerById(customer.getId());
        if (existingCustomer != null) {
            existingCustomer.setFirstName(customer.getFirstName());
            existingCustomer.setLastName(customer.getLastName());
            existingCustomer.setEmail(customer.getEmail());
            // ... autres propriétés
        } else {
            customerList.add(customer);
        }
    }

    public void deleteCustomerById(Long id) {
        customerList.removeIf(customer -> customer.getId().equals(id));
    }
}
