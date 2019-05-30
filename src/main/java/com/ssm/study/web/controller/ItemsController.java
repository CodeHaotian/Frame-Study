package com.ssm.study.web.controller;

import com.ssm.study.model.Items;
import com.ssm.study.service.IItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author：Haotian
 * @Date：2019/5/30 22:39
 */
@Controller
@RequestMapping("items")
public class ItemsController {
    @Autowired
    private IItemsService itemsService;

    public String list(Model model) {
        //1.查数据
        List<Items> itemsList = itemsService.findAllItems();
        //2.存数据
        model.addAttribute( "itemsList", itemsList );
        return "items/list";
    }

}
