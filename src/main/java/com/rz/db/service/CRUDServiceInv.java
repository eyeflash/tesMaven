/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rz.db.service;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Programer-2
 */
public interface CRUDServiceInv {

    <T> List<T> getAll(Class<T> klass);

    <T> void Save(T klass);

    <T> T findByPrimaryKey(Class<T> klass, Serializable id);

    <T> void delete(T klass);
    <T>void Update(T klass);
      <T> void Merge(T klass);
     <T> void Persist(T klass);

    public <T> T GetUniqueEntityByNamedQuery(String query, Object... params);

    <T> List<T> GetListByNamedQuery(String query, Object... params);
    <T> T GetUniqueObjectByNamedQuery(String query, Object... params);

    <T> Long getQueryCount(String query, Object... params);
}
