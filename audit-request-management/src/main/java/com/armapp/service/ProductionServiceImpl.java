package com.armapp.service;

import com.armapp.exception.InvalidIdException;
import com.armapp.model.Production;
import com.armapp.modelDTOs.ProductionVO;
import com.armapp.repository.ProductionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author - Akash Kanaparthi
 * @date - 08-07-2022
 * @project - Acheron-Training-AUDIT-REQUEST-MANAGEMENT-BACKEND
 */
@Service
public class ProductionServiceImpl implements IProductionService{

    private ProductionRepo productionRepo;
    @Autowired
    public void setProductionRepo(ProductionRepo productionRepo) {
        this.productionRepo = productionRepo;
    }

    /**
     * @author - Akash Kanaparthi
     * @param productions
     *
     */
    @Override
    public void addProduction(Set<Production> productions) {
        productionRepo.saveAll(productions);
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param production
     */
    @Override
    public void updateProduction(Production production) {
        Production production1 = productionRepo.findById(production.getProductionId()).get();
        production1.setUpdatedAt(LocalDateTime.now());
        productionRepo.save(production1);
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param productionId
     * @throws InvalidIdException
     */
    @Override
    public void deleteProduction(int productionId) throws InvalidIdException {
        Production production = productionRepo.findById(productionId).get();
        production.setDeleted(true);
        productionRepo.save(production);
    }

    /**
     *
     * @author - AkashKanaparthi
     * @param productionId
     * @return Production Object
     * @throws InvalidIdException
     */
    @Override
    public Production getById(int productionId) throws InvalidIdException{
        return productionRepo.findById(productionId).get();
    }

    /**
     *
     * @author - AkashKanaparthi
     * @return List of all Production Companies
     */
    @Override
    public List<Production> getAll() {
        return productionRepo.findAll()
                .stream()
                .filter(production -> !production.isDeleted())
                .sorted(Comparator.comparing(Production::getProductionCompanyName))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductionVO> getByProductionCompanyNameLike(String companyName) {
        return allProductionCompanies().stream()
                .filter(production -> production.getProductionCompanyName().contains(companyName))
                .collect(Collectors.toList());
    }

    private List<ProductionVO> allProductionCompanies(){
        return Arrays.asList(
                new ProductionVO(1,"Marvel Studios"),
                new ProductionVO(2,"Columbia Pictures"),
                new ProductionVO(3,"Legendary Entertainment"),
                new ProductionVO(4,"Sony Pictures"),
                new ProductionVO(5,"HBO Studios"),
                new ProductionVO(6,"RKO Pictures"),
                new ProductionVO(7,"TriStar Pictures"),
                new ProductionVO(8,"Filmways"),
                new ProductionVO(9,"PVR Pictures"),
                new ProductionVO(10,"Fox Film")
                );
    }
}
