package com.armapp.controller;



import com.armapp.model.Production;
import com.armapp.modelDTOs.ProductionVO;
import com.armapp.service.IProductionService;
import org.dozer.DozerBeanMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ProductionController {

    private IProductionService iProductionService;

    public ProductionController(IProductionService iProductionService) {
        this.iProductionService = iProductionService;
    }

    @GetMapping("/choice/{companyName}")
    @RolesAllowed({"user", "admin"})
    ResponseEntity<List<ProductionVO>> getByProductionCompanyNameLike(@PathVariable("companyName") String companyName) {

        List<Production> names = iProductionService.getByProductionCompanyNameLike(companyName);
        List<ProductionVO> productionVOList = new ArrayList<ProductionVO>();
        DozerBeanMapper mapper = new DozerBeanMapper();
        List<String> myMappingFiles = new ArrayList<>();
        myMappingFiles.add("dozerBeanMapping.xml");
        mapper.setMappingFiles(myMappingFiles);
        for (Production production : names) {
            ProductionVO productionVO = mapper.map(production, ProductionVO.class);
            productionVOList.add(productionVO);
        }
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders
                        .add("desc", "get production company names like"))
                .body(productionVOList);
    }


}
