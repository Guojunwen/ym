package com.gary.ym.repository;


import com.gary.ym.dataobject.Competition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository extends JpaRepository<Competition,String> {
    Page<Competition> findByTitleContains(String name, Pageable pageable);
}
