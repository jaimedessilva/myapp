package com.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.model.Convidado;

/**gestaoFesta
 * PagRepository.java
 * @author jaime
 * Em 09-05-2020 **/

@Repository
public interface PagRepository extends PagingAndSortingRepository<Convidado, Long>{
	@Query("SELECT e from Convidado e")
	List<Convidado> getListOrder(Sort sort);
	Page<Convidado> findAll(Pageable pg);
}
