package com.loyofo.spa.java.dao;

import java.util.List;

public interface MsgRepository {
        List<String> getMessage(long max,int count);
        }
