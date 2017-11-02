package edu.sdust.iot.controller;


import edu.sdust.iot.model.Store;
import edu.sdust.iot.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by WSL on 2017/5/22.
 */
@Controller
public class StoreController {

    @Autowired
    private StoreService storeService;

    /**
     * 主页请求，返回主页
     *
     * @return
     */
    @RequestMapping("/storestatus")
    public String toStorePage() {
        return "view/storestatus";
    }

    /**
     * 主页请求，返回主页
     *
     * @return
     */
    @RequestMapping("/addstore")
    public String addStore() {
        return "view/addstore";
    }


    /**
     * @return
     */
    @RequestMapping("/storelist")
    public String toStoreList() {
        return "view/storelist";
    }

    /**
     * 获取指定商店信息
     *
     * @param storeNumber
     * @return
     * @throws IOException
     */
    @RequestMapping("/back/getstore")
    @ResponseBody
    public List<Store> getStore(@RequestParam("storenumber") String storeNumber) throws IOException {
        if (null == storeNumber || "" == storeNumber)
            return new LinkedList<Store>();
        return storeService.getStore(Integer.valueOf(storeNumber));
    }

    /**
     * 获取所有的商店信息
     *
     * @return
     */
    @RequestMapping("/back/getallstorejson")
    @ResponseBody
    public List<Store> getAllStoreJSON() {
        List<Store> list = storeService.getAllStore();
        for (Store store : list) {
            store.setAff("<a href=\"" + "/back/storedetail?storeid=" + store.getId() + "\">" + store.getAff() + "</a>");
            System.out.println(store.getAff());
        }
        return list;
    }

    /**
     * 根据id获得商店详细信息
     *
     * @param storeid
     * @param model
     * @return
     */
    @RequestMapping("/back/storedetail")
    public String getASource(int storeid, ModelMap model) {
        List<Store> list = storeService.getStore(Integer.valueOf(storeid));
        if (list.size() == 0) {
            System.out.println(0);
            return "view/storedetail";
        }
        model.addAttribute("Store", list.get(0));//商店
        model.addAttribute("TotalNum", storeService.getTotalNum(storeid));//销售总量
        model.addAttribute("TotalSales", storeService.getTotalSales(storeid));//销售总金额
        model.addAttribute("TotalCustomers", storeService.getTotalCustomers(storeid));//总客流量
        model.addAttribute("LeftNum", storeService.getLeftNum(storeid));//剩余商品总量
        System.out.println(1);
        return "view/storedetail";
    }

    /**
     * 获取所有的商店信息
     *
     * @return
     */
    @RequestMapping("/back/getallstore")
    public void getAllStore(HttpServletResponse response) {
        try {
            List<Store> list = storeService.getAllStore();
            if (list.size() == 0)
                response.getWriter().print("{\"result\": []}");
            String str = "{\"result\":[";
            str += list.get(0).toString();
            for (int i = 1; i < list.size(); i++) {
                str += "," + list.get(i).toString();
            }
            str += "]}";
            System.out.println(str);
            response.getWriter().print(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加新商店
     *
     * @param address
     * @param is_use
     * @param add
     * @param response
     */
    @RequestMapping("/addnewstore")
    public void addNewStore(String address, int is_use, String add, HttpServletResponse response) {
        try {
            if (storeService.addNewStore(address, is_use, add)) {
                response.getWriter().print("添加成功");
            } else {
                response.getWriter().print("添加失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
