package br.com.mvc.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mvc.mudi.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    
}
