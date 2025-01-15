package fr.hb.car_rental.controller;

import fr.hb.car_rental.model.Contract;
import fr.hb.car_rental.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @GetMapping
    public String getAllContracts(Model model) {
        List<Contract> contracts = contractService.findAllContracts();
        model.addAttribute("contracts", contracts);
        return "contract/list";
    }

    @GetMapping("/{id}")
    public String getContractById(@PathVariable Long id, Model model) {
        Contract contract = contractService.findContractById(id);
        model.addAttribute("contract", contract);
        return "contract/details";
    }

    @GetMapping("/add")
    public String addContractForm(Model model) {
        model.addAttribute("contract", new Contract());
        return "contract/add";
    }

    @PostMapping("/add")
    public String addContract(@ModelAttribute Contract contract) {
        contractService.saveContract(contract);
        return "redirect:/contracts";
    }

    @GetMapping("/edit/{id}")
    public String editContractForm(@PathVariable Long id, Model model) {
        Contract contract = contractService.findContractById(id);
        model.addAttribute("contract", contract);
        return "contract/edit";
    }

    @PostMapping("/edit/{id}")
    public String editContract(@PathVariable Long id, @ModelAttribute Contract contract) {
        contract.setId(id);
        contractService.saveContract(contract);
        return "redirect:/contracts";
    }

    @GetMapping("/delete/{id}")
    public String deleteContract(@PathVariable Long id) {
        contractService.deleteContractById(id);
        return "redirect:/contracts";
    }
}
