/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.portal.controllers;

import com.iveloper.portal.controllers.exceptions.NonexistentEntityException;
import com.iveloper.portal.controllers.exceptions.PreexistingEntityException;
import com.iveloper.portal.controllers.exceptions.RollbackFailureException;
import com.iveloper.portal.entities.Lots;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author alexbonilla
 */
public class LotsJpaController implements Serializable {

    public LotsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Lots lots) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
//            utx.begin();
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(lots);
            em.getTransaction().commit();
//            utx.commit();
        } catch (SecurityException | IllegalStateException ex) {
            try {
//                utx.rollback();
                em.getTransaction().rollback();
            } catch (IllegalStateException | SecurityException re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findLots(lots.getLotid()) != null) {
                throw new PreexistingEntityException("Lots " + lots + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Lots lots) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
//            utx.begin();
            em = getEntityManager();
            em.getTransaction().begin();
            lots = em.merge(lots);
            em.getTransaction().commit();
//            utx.commit();
        } catch (Exception ex) {
            try {
//                utx.rollback();
                em.getTransaction().rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = lots.getLotid();
                if (findLots(id) == null) {
                    throw new NonexistentEntityException("The lots with id " + id + " no longer exists.");
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
            Lots lots;
            try {
                lots = em.getReference(Lots.class, id);
                lots.getLotid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The lots with id " + id + " no longer exists.", enfe);
            }
            em.remove(lots);
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

    public List<Lots> findLotsEntities() {
        return findLotsEntities(true, -1, -1);
    }

    public List<Lots> findLotsEntities(int maxResults, int firstResult) {
        return findLotsEntities(false, maxResults, firstResult);
    }

    private List<Lots> findLotsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Lots.class));
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

    public Lots findLots(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Lots.class, id);
        } finally {
            em.close();
        }
    }

    public int getLotsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Lots> rt = cq.from(Lots.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
