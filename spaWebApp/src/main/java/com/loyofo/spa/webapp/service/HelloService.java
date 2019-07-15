package com.loyofo.spa.webapp.service;

import com.loyofo.spa.webapp.dao.ClazzDao;
import com.loyofo.spa.webapp.dao.StudentDao;
import com.loyofo.spa.webapp.entity.Clazz;
import com.loyofo.spa.webapp.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class HelloService {

    {
        log.info("HelloService bean 已创建");
    }

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private ClazzDao clazzDao;

    private static Logger log = LoggerFactory.getLogger(HelloService.class);

    public void logIt(String msg) {
        log.info("controller 让我记录: {}", msg);
    }

    public String getAllStackTrace() throws InterruptedException {
        try {
            Thread.sleep(100);
            throw new RuntimeException("这里是异常, 追踪栈轨迹");
        } catch (Exception ex) {
            ex.printStackTrace();
            Thread.sleep(100);
            return "ok";
        }
    }

    public Student getStudentById(String id) {
        return studentDao.getStudentById(id);
    }

    public List<Clazz> getAll() {
        return studentDao.getAll();
    }

    public List<Clazz> getAllClazz() {
        return clazzDao.getAllClazz();
    }

    public Clazz getClazz(String id) {
        return clazzDao.getClazzById(id);
    }
}
