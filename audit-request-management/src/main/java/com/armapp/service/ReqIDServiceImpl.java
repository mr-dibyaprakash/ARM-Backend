package com.armapp.service;

import com.armapp.model.ReqID;
import com.armapp.repository.ReqIDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author - Abuthair Sheika
 * @date - 20-07-2022
 * @project - audit-request-management
 */
@Service
public class ReqIDServiceImpl implements IReqIDService {

    @Autowired
    private ReqIDRepository reqIDRepository;

    /**
     * To generate a request id for a new request
     * @param reqID
     * @return
     */
    @Override
    public ReqID createReqID(ReqID reqID) {
        return reqIDRepository.save(reqID);
    }
}
