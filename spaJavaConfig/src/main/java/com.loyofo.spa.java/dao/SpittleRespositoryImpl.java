package com.loyofo.spa.java.dao;


import com.loyofo.spa.java.entity.Spittle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpittleRespositoryImpl implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }
}
