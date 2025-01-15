package fr.hb.car_rental.service;

import fr.hb.car_rental.model.Contract;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContractService {

    private static final List<Contract> contractList = new ArrayList<>();

    public List<Contract> findAllContracts() {
        return contractList;
    }

    public Contract findContractById(Long id) {
        for (Contract contract : contractList) {
            if (contract.getId().equals(id)) {
                return contract;
            }
        }
        return null;
    }

    public void saveContract(Contract contract) {
        Contract existingContract = findContractById(contract.getId());
        if (existingContract != null) {
            existingContract.setCar(contract.getCar());
            existingContract.setCustomer(contract.getCustomer());
            existingContract.setStartDate(contract.getStartDate());
            existingContract.setEndDate(contract.getEndDate());
            existingContract.setTotalPrice(contract.getTotalPrice());
            existingContract.setStatus(contract.getStatus());
        } else {
            contractList.add(contract);
        }
    }

    public void deleteContractById(Long id) {
        contractList.removeIf(contract -> contract.getId().equals(id));
    }

    public List<Contract> findContractsEndingSoon() {
        LocalDate threeMonthsFromNow = LocalDate.now().plusMonths(3);
        return contractList.stream()
                .filter(contract -> contract.getEndDate().isBefore(threeMonthsFromNow))
                .collect(Collectors.toList());
    }
}
