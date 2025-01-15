package fr.hb.car_rental.controller;

import fr.hb.car_rental.service.CarService;
import fr.hb.car_rental.service.ContractService;
import fr.hb.car_rental.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final ContractService contractService;
    private final CustomerService customerService;

    public HomeController(ContractService contractService, CustomerService customerService) {
        this.contractService = contractService;
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("endingSoonContracts", contractService.findContractsEndingSoon());

        long nbCustomers = customerService.findAllCustomers().size();
        model.addAttribute("nbCustomers", nbCustomers);

        return "home";
    }
}