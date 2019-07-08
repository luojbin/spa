package com.loyofo.spa.java.dao.impl;

import com.loyofo.spa.java.dao.SpittleRepository;
import com.loyofo.spa.java.entity.Spittle;
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
