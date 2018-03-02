package com.dagu.ssm.service;

import java.util.List;

import com.dagu.ssm.pojo.Items;

public interface ItemsService {
	
	//添加商品
	public void saveItems (Items items);
	
	//查询商品
	public List<Items> selectItemsList();

	public Items selectItemsByID(Integer id);

	public void deleteItemsByID(Integer id);

	public void updateItemsByID(Items items);
	
	public List<Items> selectItemsBySQL(Items items);
	
}
