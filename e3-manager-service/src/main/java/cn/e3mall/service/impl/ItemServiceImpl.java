package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.pojo.TbItemExample.Criteria;
import cn.e3mall.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	@Override
	public TbItem getItemById(long itemId) {
		//第一种查询方式:根据主键查询
		/*TbItem tbItem=itemMapper.selectByPrimaryKey(itemId);*/
		//根据条件查询
		TbItemExample example=new TbItemExample();
		Criteria criteria=example.createCriteria();
		//设置查询条件
		criteria.andIdEqualTo(itemId); 
		//执行查询
		List<TbItem> list=itemMapper.selectByExample(example);
		if(list !=null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}

}
