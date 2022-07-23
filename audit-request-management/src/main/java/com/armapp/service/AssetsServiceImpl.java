package com.armapp.service;

import com.armapp.model.Assets;
import com.armapp.repository.AssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Dibya Prakash Ojha
 * @date : 23-Jul-22
 * @project : audit-request-management
 */
@Service
public class AssetsServiceImpl implements IAssetsService {
    private AssetsRepository assetsRepository;

    @Autowired
    public void setAssetsRepository(AssetsRepository assetsRepository) {
        this.assetsRepository = assetsRepository;
    }

    @Override
    @Transactional
    public void addAssets(Assets assets) {
        assetsRepository.save(assets);
    }
}
