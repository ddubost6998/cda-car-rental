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

    public List<Contract> findContractsEndingSoon() {
        LocalDate threeMonthsFromNow = LocalDate.now().plusMonths(3);

        return contractList.stream()
                .filter(contract -> contract.getEndDate().isBefore(threeMonthsFromNow))
                .collect(Collectors.toList());
    }
}
