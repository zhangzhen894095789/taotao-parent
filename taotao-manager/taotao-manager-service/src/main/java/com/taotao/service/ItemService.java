package com.taotao.service;

import com.taotao.common.pojo.EasyUIResult;

public interface ItemService {
    /**获取商品信息列表
     *
     * @param page
     * @param rows
     * @return
     */
    public EasyUIResult getItemList(Integer page, Integer rows);
}
