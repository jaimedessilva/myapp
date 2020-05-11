package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Convidado;

/**gestaoFesta
 * ConvidadosRep.java
 * @author jaime
 * Em 06-05-2020 **/

@Repository
public interface ConvidadoRepository extends JpaRepository<Convidado, Long> {}
