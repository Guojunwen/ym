package com.gary.ym.service.impl;

import com.gary.ym.dataobject.Competition;
import com.gary.ym.dataobject.Person;
import com.gary.ym.repository.CompetitionRepository;
import com.gary.ym.repository.PersonRepository;
import com.gary.ym.service.CompetitionService;
import com.gary.ym.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    private CompetitionRepository repository;


    @Override
    public Competition findOne(String id) {
        return repository.findOne(id);
    }

    @Override
    public Page<Competition> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Competition> findLikeTitle(String name, Pageable pageable) {
        return repository.findByTitleContains(name,pageable);
    }

    @Override
    public Competition save(Competition competition) {
        return repository.save(competition);
    }
}
