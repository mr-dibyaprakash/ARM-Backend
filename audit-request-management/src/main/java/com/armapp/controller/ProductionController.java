package com.armapp.controller;



import com.armapp.modelDTOs.ProductionVO;
import com.armapp.service.IProductionService;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.IDToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ProductionController {

    private IProductionService iProductionService;

    public ProductionController(IProductionService iProductionService) {
        this.iProductionService = iProductionService;
    }

    @GetMapping("/choice/{companyName}")
    @RolesAllowed({"user","admin"})
    ResponseEntity<List<ProductionVO>> getByProductionCompanyNameLike(@PathVariable("companyName") String companyName)  {

        List<ProductionVO> names = iProductionService.getByProductionCompanyNameLike(companyName);
        return ResponseEntity.status(HttpStatus.OK)
                .headers(httpHeaders -> httpHeaders
                        .add("desc", "get production company names like"))
                .body(names);
    }


}
