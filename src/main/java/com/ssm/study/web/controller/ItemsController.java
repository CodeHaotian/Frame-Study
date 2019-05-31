package com.ssm.study.web.controller;

import com.ssm.study.model.Items;
import com.ssm.study.service.IItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
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

    /**
     * 查询所有商品信息
     */
    @RequestMapping("list")
    public String list(Model model) {
        //1.查数据
        List<Items> itemsList = itemsService.findAllItems();
        //2.存数据
        model.addAttribute( "itemsList", itemsList );
        return "items/list";
    }

    /**
     * 添加商品
     */
    @RequestMapping("save")
    public String save() {
        //创建商品
        Items items = new Items();
        items.setName( "iphoneX" );
        items.setPrice( 8400.00F );
        items.setCreatetime( new Date() );
        items.setDetail( "666好用" );
        //保存数据
        itemsService.saveOrUpdate( items );
        return "redirect:list.do";
    }

    /**
     * 根据id删除商品
     */
    @RequestMapping("delete")
    public String delete(Integer id, Model model) {
        //保存数据
        itemsService.deleteById( id );
        return "forward:list.do";
    }

    /**
     * 根据id更新商品信息
     */
    @RequestMapping("update")
    public String update(Items items, Model model) {
        System.out.println( items );
        //设置时间
        items.setCreatetime( new Date() );
        itemsService.saveOrUpdate( items );
        return "redirect:list.do";
    }

    /**
     * 根据id修改商品信息
     */
    @RequestMapping("edit")
    public String edit(Integer id, Model model) {
        System.out.println( "id:" + id );
        //通过id找到商品
        Items items = itemsService.findById( id );
        if (items != null) {
            model.addAttribute( "items", items );
        }
        return "items/edit";
    }
}
