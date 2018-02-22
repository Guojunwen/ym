package com.gary.ym.service;

import com.gary.ym.dataobject.Competition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompetitionService {
    Competition findOne(String id);

    Page<Competition> findAll(Pageable pageable);

    Page<Competition> findLikeName(String name, Pageable pageable);

    Competition save(Competition person);
}
