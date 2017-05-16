/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.jhonataribeiro.data;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import br.com.jhonataribeiro.model.Especialidade;
import br.com.jhonataribeiro.model.Medico;


@ApplicationScoped
public class MedicoRepository {
	
	@Inject Logger log;

    @Inject
    private EntityManager em;

    public Medico findById(Long id) {
        return em.find(Medico.class, id);
    }
    
    public Medico findByEmail(String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Medico> criteria = cb.createQuery(Medico.class);
        Root<Medico> medico = criteria.from(Medico.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).where(cb.equal(member.get(Member_.name), email));
        criteria.select(medico).where(cb.equal(medico.get("email"), email));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<Medico> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Medico> criteria = cb.createQuery(Medico.class);
        Root<Medico> medico = criteria.from(Medico.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
        criteria.select(medico).orderBy(cb.asc(medico.get("primeiroNome")));
         Set<Medico> hashset = new LinkedHashSet(em.createQuery(criteria.distinct(true)).getResultList());
         List<Medico> list = new ArrayList<Medico>(hashset);
         log.info("info:" + list);
         return list;
    }
}
