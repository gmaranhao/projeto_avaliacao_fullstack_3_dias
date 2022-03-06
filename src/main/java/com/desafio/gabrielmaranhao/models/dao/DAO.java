package com.desafio.gabrielmaranhao.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.desafio.gabrielmaranhao.models.entities.Contato;

public class DAO<E> {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private Class<E> classe;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("projeto-desafio");
        } catch (Exception e) {
            e.printStackTrace();
            // log4j
        }
    }

    public DAO() {
        this(null);
    }

    public DAO(Class<E> classe) {
        this.classe = classe;
        em = emf.createEntityManager();
    }

    public DAO<E> abrirT() {
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> fecharT() {
        em.getTransaction().commit();
        return this;
    }

    public DAO<E> incluir(E e) {
        em.persist(e);
        return this;
    }

    public DAO<E> incluirAtomico(E e) {
        return this.abrirT().incluir(e).fecharT();
    }

    public List<E> obterTodos() {
        if (classe == null) {
            throw new IllegalArgumentException("Classe nao informada");
        }

        String jpql = "select e from " + classe.getName() + " e ORDER BY nome ASC";
        TypedQuery<E> query = em.createQuery(jpql, classe);
        return query.getResultList();
    }

    public List<E> obterRange(int deslocamento, int qtde) {
        if (classe == null) {
            throw new IllegalArgumentException("Classe nao informada");
        }

        String jpql = "select e from " + classe.getName() + " e ORDER BY nome ASC";
        TypedQuery<E> query = em.createQuery(jpql, classe);
        query.setMaxResults(qtde);
        query.setFirstResult(deslocamento);
        return query.getResultList();
    }

    public E obterContatoById(long id) {
        return em.find(classe, id);
    }

    public void excluir(E e) {
        em.remove(e);
    }

    public void alterarContato(long id, E contatoAtualizado) {

        this.abrirT();
        E contato = em.find(classe, id);
        ((Contato) contato).mergeObj(contatoAtualizado);
        em.merge(contato);
        this.fecharT();
    }


    public void excluirContato(long id) {
        E contato = em.find(classe, id);
        if (contato != null) {
            this.abrirT();
            em.remove(contato);
            this.fecharT();
        }
    }


    public void fechar() {
        em.close();
    }

    public DAO<E> alterar(E e) {
        em.merge(e);
        return this;
    }
}
