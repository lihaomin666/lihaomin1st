package com.dagu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dagu.ssm.mapper.ItemsMapper;
import com.dagu.ssm.pojo.Items;
import com.dagu.ssm.service.ItemsService;

@Service
@Transactional
public class ItemsServiceImpl implements ItemsService{
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public void saveItems(Items items) {
		//调用mapper代理接口实现类方法
		this.itemsMapper.addItems(items);
	}

	@Override
	public List<Items> selectItemsList() {
		return this.itemsMapper.selectItemsList();
	}

	@Override
	public Items selectItemsByID(Integer id) {
		return this.itemsMapper.selectItemsByID(id);
	}

	@Override
	public void deleteItemsByID(Integer id) {
		this.itemsMapper.deleteItemsByID(id);
	}

	@Override
	public void updateItemsByID(Items items) {
		this.itemsMapper.updateItemsByID(items);
	}

	@Override
	public List<Items> selectItemsBySQL(Items items) {
		return this.itemsMapper.selectItemsBySQL(items);
	}

}
