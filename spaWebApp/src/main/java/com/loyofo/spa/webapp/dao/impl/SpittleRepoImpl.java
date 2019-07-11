package com.loyofo.spa.webapp.dao.impl;

import com.loyofo.spa.webapp.dao.SpittleRepository;
import com.loyofo.spa.webapp.entity.Spittle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpittleRepoImpl implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }

    @Override
    public Spittle findOne(long spittleId) {
        return null;
    }
}
