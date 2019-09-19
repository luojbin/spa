package com.loyofo.spa.webapp.common.aspect;

import com.loyofo.spa.webapp.common.annotation.EntityField;
import com.loyofo.spa.webapp.common.annotation.EntityId;
import com.loyofo.spa.webapp.dao.StudentDao;
import com.loyofo.spa.webapp.entity.Student;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * 更新日志切面
 */
@Aspect
@Component
public class UpdateLogAspect {

    @Autowired
    private StudentDao studentDao;

    private static Logger logger = LoggerFactory.getLogger(UpdateLogAspect.class);

    @Pointcut(value = "execution(* com.loyofo.spa.webapp.dao.StudentDao.update*(..))  && args(newEntity)", argNames = "newEntity")
    public <T> void saveMethod(T newEntity) {
    }

    @Before(value = "saveMethod(newEntity)")
    public <T> void updateLog(T newEntity) throws IllegalAccessException {
        Class c = newEntity.getClass();
        // 获取 id 字段
        Field[] fields = c.getDeclaredFields();
        Field idField = null;
        for (Field f : fields) {
            if (f.getAnnotationsByType(EntityId.class).length != 0) {
                idField = f;
                break;
            }
        }
        if (idField == null) {
            throw new RuntimeException("没有找到 id 域");
        }
        // 通过id 查询数据库已有对象
        idField.setAccessible(true);
        String id = idField.get(newEntity).toString();
        Student oldEntity = studentDao.getStudentById(id);
        // 遍历所有字段, 对比新旧对象数据
        for (Field f : fields) {
            if (f.getAnnotationsByType(EntityField.class).length != 0) {
                String tag = f.getAnnotationsByType(EntityField.class)[0].value();
                f.setAccessible(true);
                Object oldVal = f.get(oldEntity);
                Object newVal = f.get(newEntity);
                if (!Objects.equals(oldVal, newVal)) {
                    logger.warn("field:{}, tag:{}, {} -> {}", f.getName(), tag, oldVal, newVal);
                }
            }
        }
    }
}
