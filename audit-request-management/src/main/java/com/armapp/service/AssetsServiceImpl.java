package com.armapp.service;

import com.armapp.model.Assets;
import com.armapp.repository.AssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    /**
     * to upload a file
     * @param assets
     */
    @Override
    @Transactional
    public void addAssets(Assets assets) {
        assetsRepository.save(assets);
    }

    /**
     * to get all the files available
     * @return
     */
    @Override
    public List<Assets> getAllAssets() {
        return assetsRepository.findAll();
    }

    /**
     * to get the files for a particular task
     * @param taskId
     * @return
     */
    @Override
    public List<Assets> getByTaskId(Integer taskId) {
        return assetsRepository.findByTaskId(taskId);
    }

    /**
     * to get the files for a particular request
     * @param taskId
     * @return
     */
    @Override
    public List<Assets> getByRequestId(Integer taskId) {
        return assetsRepository.findByRequestId(taskId);
    }

    /**
     * to delete a file
     * @param assetId
     */
    @Override
    public void deleteAsset(Integer assetId){
        Assets asset = assetsRepository.findById(assetId).get();
        asset.setDeleted(true);
        assetsRepository.save(asset);
    }
}
