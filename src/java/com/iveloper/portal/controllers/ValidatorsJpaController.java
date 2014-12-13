/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.portal.controllers;

import com.iveloper.comprobantes.utils.ArchivoUtils;
import com.iveloper.comprobantes.utils.ValidadorEstructuraDocumento;
import com.iveloper.portal.controllers.exceptions.NonexistentEntityException;
import com.iveloper.portal.controllers.exceptions.PreexistingEntityException;
import com.iveloper.portal.controllers.exceptions.RollbackFailureException;
import com.iveloper.portal.entities.Validators;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
public class ValidatorsJpaController implements Serializable {

    public ValidatorsJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public String validateAgainstSchema(String tipoComprobante, InputStream xmlis) {
        String respuestaValidacion = null;
        String nombreXsd = ArchivoUtils.seleccionaXsd(tipoComprobante);
        Validators validator = findValidators(nombreXsd);

        InputStream xsdis = new ByteArrayInputStream(validator.getContent());
        ValidadorEstructuraDocumento validador = new ValidadorEstructuraDocumento(xsdis, xmlis);
        if (xmlis != null) {
            respuestaValidacion = validador.validacion();
        }
        return respuestaValidacion;
    }

    public void create(Validators validators) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(validators);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findValidators(validators.getDocname()) != null) {
                throw new PreexistingEntityException("Validators " + validators + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Validators validators) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            validators = em.merge(validators);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = validators.getDocname();
                if (findValidators(id) == null) {
                    throw new NonexistentEntityException("The validators with id " + id + " no longer exists.");
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
            Validators validators;
            try {
                validators = em.getReference(Validators.class, id);
                validators.getDocname();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The validators with id " + id + " no longer exists.", enfe);
            }
            em.remove(validators);
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

    public List<Validators> findValidatorsEntities() {
        return findValidatorsEntities(true, -1, -1);
    }

    public List<Validators> findValidatorsEntities(int maxResults, int firstResult) {
        return findValidatorsEntities(false, maxResults, firstResult);
    }

    private List<Validators> findValidatorsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Validators.class));
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

    public Validators findValidators(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Validators.class, id);
        } finally {
            em.close();
        }
    }

    public int getValidatorsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Validators> rt = cq.from(Validators.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
