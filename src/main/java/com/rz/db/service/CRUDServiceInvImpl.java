/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rz.db.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rz.db.dao.CRUDDaoInv;


/**
 *
 * @author Programer-2
 */
@Service
public class CRUDServiceInvImpl implements CRUDServiceInv {

    @Autowired
    CRUDDaoInv CRUDaoInv;

    @Override
    @Transactional(value = "Inv", readOnly = true)
    public <T> List<T> getAll(Class<T> klass) {
        return CRUDaoInv.getAll(klass);
    }

    @Transactional(value = "Inv")
    public <T> void Save(T klass) {
        CRUDaoInv.Save(klass);
    }

    public <T> T findByPrimaryKey(Class<T> klass, Serializable id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Transactional(value = "Inv")
    public <T> void delete(T klass) {
        CRUDaoInv.delete(klass);
    }

    @Transactional(value = "Inv", readOnly = true)
    public <T> T GetUniqueEntityByNamedQuery(String query, Object... params) {
        //System.out.println("*** execute GetUniqueEntityByNamedQuery p:***");
        return CRUDaoInv.GetUniqueEntityByNamedQuery(query, params);
    }

    @Transactional(value = "Inv", readOnly = true)
    public <T> List<T> GetListByNamedQuery(String query, Object... params) {
        return CRUDaoInv.GetListByNamedQuery(query, params);
    }

    /**
     * mengembalikan nilai object dari hasil query. bisa digunakan untuk fungsi count/max
     * @param <T>
     * @param query
     * @param params
     * @return 
     */
    @Transactional(value = "Inv", readOnly = true)
    public <T> T GetUniqueObjectByNamedQuery(String query, Object... params) {
        return CRUDaoInv.GetUniqueObjectByNamedQuery(query, params);
    }

    public <T> Long getQueryCount(String query, Object... params) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
     @Transactional(value = "Inv")
    public <T> void Update(T klass) {
        CRUDaoInv.Update(klass);
    }
    

    @Override
    public <T> void Merge(T klass) {
        CRUDaoInv.Merge(klass);
    }

    @Override
    public <T> void Persist(T klass) {
       CRUDaoInv.Persist(klass);
    }
}
