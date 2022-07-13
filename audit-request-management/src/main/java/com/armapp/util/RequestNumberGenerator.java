package com.armapp.util;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.lang.module.Configuration;
import java.util.Properties;

/**
 * @author - Akash Kanaparthi
 * @date - 12-07-2022
 * @project - audit-request-management
 */
public class RequestNumberGenerator extends SequenceStyleGenerator {

    private String valuePrefix;
    private String numberFormat;
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return valuePrefix+String.format(numberFormat,super.generate(session, object));
    }

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        super.configure(type, params, serviceRegistry);
//        valuePrefix = ConfigurationHelper.getString()
    }
}
