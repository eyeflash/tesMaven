/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rz.db.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Programer-2
 */
@Repository
public class CRUDDaoInvImpl implements CRUDDaoInv {

    @Autowired
    @Qualifier("sessionFactory")
    SessionFactory sessionFactoryInv;

    protected final Session getCurrentSession() {
        return sessionFactoryInv.getCurrentSession();
    }

    @Override
    public <T> List<T> getAll(Class<T> klass) {
       // System.out.println("*** cruddaoimplInv getall execute 1st line ***");
        return getCurrentSession().createQuery("from " + klass.getName()).list();
    }

    public <T> void Save(T klass) {
        getCurrentSession().save(klass);
    }

    public <T> T findByPrimaryKey(Class<T> klass, Serializable id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Mengembalikan 1 row saja.
     *
     * @param <T>
     * @param query
     * @param params
     * @return
     */
    public <T> T GetUniqueEntityByNamedQuery(String query, Object... params) {
        //System.out.println("*** execute GetUniqueEntityByNamedQuery (DAO Impl)***");
        Query q = getCurrentSession().getNamedQuery(query);


        int i = 1;
        String arg = "arg";
        if (params != null) {
            for (Object o : params) {
                if (o != null) {
                    if (o instanceof List) {
                        q.setParameterList(arg + i, (List) o);
                    } else {
                        q.setParameter(arg + i, o);
                    }
                    i++;
                }
            }
        }

//        int i = 0;
//        for (Object o : params) {
//            q.setParameter(i, o);
//        }
        List<T> results = q.list();

        T foundentity = null;
        if (!results.isEmpty()) {
            //ignore multiple result
            foundentity = results.get(0);
        }
        return foundentity;

    }

    public <T> List<T> GetListByNamedQuery(String query, Object... params) {
        Query q = getCurrentSession().getNamedQuery(query);

        int i = 1;
        String arg = "arg";
        if (params != null) {
            for (Object o : params) {
                if (o != null) {
                    if (o instanceof List) {
                        q.setParameterList(arg + i, (List) o);
                    } else {
                        q.setParameter(arg + i, o);
                    }

                    i++;
                }
            }
        }

        List<T> list = (List<T>) q.list();
        return list;

    }

    /**
     * Mengembalikan fungsi scalar. satu object saja. misal int, short
     * create 170203
     * @param query
     * @param params
     * @return 
     */
    @Override
    public <T> T GetUniqueObjectByNamedQuery(String query, Object... params) {
        Query q = getCurrentSession().getNamedQuery(query);

        int i = 1;
        String arg = "arg";
        if (params != null) {
            for (Object o : params) {
                if (o != null) {
                    if (o instanceof List) {
                        q.setParameterList(arg + i, (List) o);
                    } else {
                        q.setParameter(arg + i, o);
                    }

                    i++;
                }
            }
        }
        return (T)q.uniqueResult();
    }

    public <T> void delete(T klass) {
        getCurrentSession().delete(klass);
    }

    public <T> Long getQueryCount(String query, Object... params) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> void Update(T klass) {
         getCurrentSession().update(klass);
    }
    @Override
    public <T> void Merge(T klass) {
         getCurrentSession().merge(klass);
    }
    @Override
    public <T> void Persist(T klass) {
         getCurrentSession().persist(klass);
    }
}
