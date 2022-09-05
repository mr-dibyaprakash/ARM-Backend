package com.armapp.service;

import com.armapp.model.Message;
import com.armapp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author - Baba Sri Harsha
 * @date - 15-07-2022
 * @project - audit-request-management
 */
@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private MessageRepository messageRepository;

    /**
     * to get all the messages.
     * @return
     */
    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    /**
     * to send a new message
     * @param message
     * @return
     */
    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    /**
     * to get all the messages in chat for a particular task of a request
     * @param taskId
     * @return
     */
    @Override
    public List<Message> findAllByTaskId(Integer taskId) {
        return messageRepository.findAllByTaskId(taskId);
    }
}
