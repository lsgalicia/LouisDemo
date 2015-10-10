package org.lsgalicia.dao.service;


import org.lsgalicia.common.JavaFramework;
import org.lsgalicia.dao.JavaFrameworkDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



@Component
@Transactional
public class JavaFrameworkService extends EntityService<JavaFramework> implements JavaFrameworkDao {

	
}

