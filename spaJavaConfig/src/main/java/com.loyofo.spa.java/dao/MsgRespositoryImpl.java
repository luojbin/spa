package com.loyofo.spa.java.dao;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsgRespositoryImpl implements MsgRepository{
    @Override
    public List<String> getMessage(long max, int count) {
        return null;
    }
}
