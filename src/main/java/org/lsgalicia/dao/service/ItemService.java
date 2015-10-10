package org.lsgalicia.dao.service;


import org.lsgalicia.common.Item;
import org.lsgalicia.dao.ItemsDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class ItemService extends EntityService<Item> implements ItemsDao {

	
}

