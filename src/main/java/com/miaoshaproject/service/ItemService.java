package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.model.ItemModel;

import java.util.List;

public interface ItemService {

    // 创建商品
    ItemModel createItem(ItemModel itemModel) throws BusinessException;

    // 查询商品列表
    List<ItemModel> listItem();

    // 商品详情浏览
    ItemModel getItemById(Integer id);

}
