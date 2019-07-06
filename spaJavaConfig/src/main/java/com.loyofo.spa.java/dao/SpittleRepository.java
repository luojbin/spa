package com.loyofo.spa.java.dao;

import com.loyofo.spa.java.entity.Spittle;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
