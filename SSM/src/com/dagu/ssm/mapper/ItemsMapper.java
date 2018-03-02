package com.dagu.ssm.mapper;

import java.util.List;

import com.dagu.ssm.pojo.Items;

public interface ItemsMapper {
    
	public void addItems (Items items);

	public List<Items> selectItemsList();

	public Items selectItemsByID(Integer id);

	public void deleteItemsByID(Integer id);

	public void updateItemsByID(Items items);
	
	public List<Items> selectItemsBySQL(Items items);
	
}