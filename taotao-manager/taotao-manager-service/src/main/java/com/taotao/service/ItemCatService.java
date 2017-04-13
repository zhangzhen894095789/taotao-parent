package com.taotao.service;

import com.taotao.pojo.ItemCat;

import java.util.List;

public interface ItemCatService {
    /**
     * 根据 parentId 查询子节点
     * @param parentId
     * @return
     * @throws Exception
     */
    public List<ItemCat> getItemCatList(Long parentId) throws Exception;
}
