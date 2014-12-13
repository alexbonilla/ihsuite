/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.portal.controllers;

import com.iveloper.portal.controllers.exceptions.NonexistentEntityException;
import com.iveloper.portal.controllers.exceptions.PreexistingEntityException;
import com.iveloper.portal.controllers.exceptions.RollbackFailureException;
import com.iveloper.portal.entities.ResumenesFacturas;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author alexbonilla
 */
public class ResumenesFacturasJpaController implements Serializable {

    public ResumenesFacturasJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ResumenesFacturas resumenesFacturas) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(resumenesFacturas);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findResumenesFacturas(resumenesFacturas.getClaveacceso()) != null) {
                throw new PreexistingEntityException("ResumenesFacturas " + resumenesFacturas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ResumenesFacturas resumenesFacturas) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            resumenesFacturas = em.merge(resumenesFacturas);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = resumenesFacturas.getClaveacceso();
                if (findResumenesFacturas(id) == null) {
                    throw new NonexistentEntityException("The resumenesFacturas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            ResumenesFacturas resumenesFacturas;
            try {
                resumenesFacturas = em.getReference(ResumenesFacturas.class, id);
                resumenesFacturas.getClaveacceso();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The resumenesFacturas with id " + id + " no longer exists.", enfe);
            }
            em.remove(resumenesFacturas);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ResumenesFacturas> findResumenesFacturasEntities() {
        return findResumenesFacturasEntities(true, -1, -1);
    }

    public List<ResumenesFacturas> findResumenesFacturasEntities(int maxResults, int firstResult) {
        return findResumenesFacturasEntities(false, maxResults, firstResult);
    }

    private List<ResumenesFacturas> findResumenesFacturasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ResumenesFacturas.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ResumenesFacturas findResumenesFacturas(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ResumenesFacturas.class, id);
        } finally {
            em.close();
        }
    }

    public int getResumenesFacturasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ResumenesFacturas> rt = cq.from(ResumenesFacturas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
