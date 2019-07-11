package com.loyofo.spa.webapp.dao;

import com.loyofo.spa.webapp.entity.Spittle;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    Spittle findOne(long spittleId);
}
