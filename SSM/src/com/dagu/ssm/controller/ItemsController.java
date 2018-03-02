package com.dagu.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dagu.ssm.pojo.Items;
import com.dagu.ssm.service.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;
	
	//跳转到商品页面
	@RequestMapping("toItems")
	public String toItems() {
		return "items";
	}
	
	//添加用户方法
	@RequestMapping("addItems")
	public String addItems(Items items) {
		System.out.println(items);
		this.itemsService.saveItems(items);
		return "redirect:itemsList.do";
	}
	
	//查询商品列表
	@RequestMapping("itemsList")
	public String itemsList( Model model) {
		List<Items> items = this.itemsService.selectItemsList();
		model.addAttribute("items", items);
		return "itemsList";
	}

	//删除商品
	@RequestMapping("deleteItemsByID")
	public String deleteItemsByID( Integer id ) {
		this.itemsService.deleteItemsByID(id);
		return "redirect:itemsList.do";
	}
	
	//批量删除商品
	@RequestMapping("deleteItemsByids")
	public String deleteItemsByids( Integer [] ids ) {
		System.out.println(ids);
		for (Integer id : ids) {
			this.deleteItemsByID(id);
		}
		return "redirect:itemsList.do";
	}
	
	//修改商品第一步
	@RequestMapping("updateItemsByID")
	public String updateItemsByID( Integer id , Model model ) {
		Items items = this.itemsService.selectItemsByID(id);
		model.addAttribute("items", items);
		return "updateItems";
	}
	
	//修改商品第二步
	@RequestMapping("updateItems")
	public String updateItems( Items items ) {
		this.itemsService.updateItemsByID(items);
		return "redirect:itemsList.do";
	}
	//进入多条件查询
	@RequestMapping("toselectItemsBySQL")
	public String toselectItemsBySQL() {
		return "listItemsBySQL";
	}
	//多条件查询
	@RequestMapping("selectItemsBySQL")
	public String selectItemsBySQL( Items items , Model model ) {
		List<Items> listItems = this.itemsService.selectItemsBySQL(items);
		model.addAttribute("listItems", listItems);
		return "listItemsBySQL";
	}
	
}
