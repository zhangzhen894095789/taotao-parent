package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.ItemMapper;
import com.taotao.common.pojo.EasyUIResult;
import com.taotao.pojo.Item;
import com.taotao.pojo.ItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemMapper itemMapper;
    @Override
    public EasyUIResult getItemList(Integer page, Integer rows)  {
        ItemExample example = new ItemExample();
        //设置分页
        PageHelper.startPage(page, rows);
        List<Item> list = itemMapper.selectByExample(example);
        //取分页信息
        PageInfo<Item> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        EasyUIResult result = new EasyUIResult(total, list);

        return result;
    }

}
