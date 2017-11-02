package edu.sdust.iot.controller;

import edu.sdust.iot.model.Commodity;
import edu.sdust.iot.model.History_T;
import edu.sdust.iot.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * 商品服务
 * Created by WSL on 2017/5/23.
 */
@Controller
public class CommodityContorller {

    @Autowired
    private CommodityService commoService;

    /**
     * 返回商品列表界面
     *
     * @return
     */
    @RequestMapping("/commolist")
    public String toCommoListPage() {
        return "view/commolist";
    }

    /**
     * 获取所有的商店信息
     *
     * @return
     */
    @RequestMapping("/back/getallcommojson")
    @ResponseBody
    public List<Commodity> getAllStoreJSON() {
        return commoService.getAllCommo();
    }

    /**
     * 返回添加商品页面
     *
     * @return
     */
    @RequestMapping("/addcommo")
    public String toAddCommoPage() {
        return "view/addcommo";
    }

    /**
     * 根据商品的rfid号获得商品的信息
     *
     * @param commo
     * @param resp
     * @return
     * @throws IOException
     */
    @RequestMapping("/back/getcommosinfo")
    @ResponseBody
    public void getCommoInfo(@RequestParam("commo") String commo, HttpServletResponse resp) throws IOException {
        try {
            if (null == commo || "" == commo)
                resp.getWriter().print("{\"result\": []}");
            String[] commos = commo.split(";");
            if (commos.length <= 0)
                resp.getWriter().print("{\"result\": []}");
            List<Commodity> list = commoService.getCommoListByRfid(commos);
            if (list.size() == 0)
                resp.getWriter().print("{\"result\": []}");
            String str = "{\"result\":[";
            str += list.get(0).toString();
            for (int i = 1; i < list.size(); i++) {
                str += "," + list.get(i).toString();
            }
            str += "]}";
            System.out.println(str);
            resp.getWriter().print(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    /**
//     * 根据商品的rfid号获得商品的信息
//     *
//     * @param commo
//     * @param resp
//     * @return
//     * @throws IOException
//     */
//    @RequestMapping("/back/getcommosinfo")
//    @ResponseBody
//    public List<Commodity> getCommoInfo(@RequestParam("commo") String commo, HttpServletResponse resp) throws IOException {
//        if (null == commo || "" == commo)
//            return new LinkedList<Commodity>();
//        String[] commos = commo.split(";");
//        if (commos.length <= 0)
//            return new LinkedList<Commodity>();
//        return commoService.getCommoListByRfid(commos);
//    }

    /**
     * 处理购买成功
     * 存入历史记录
     *
     * @param rfids
     * @param ids
     * @param uid
     * @param storeid
     * @param response
     */
    @RequestMapping(value = "/back/buysuccess")
    public void buySuccess(@RequestParam("rfids") String rfids,
                           @RequestParam("ids") String ids,
                           @RequestParam("uid") int uid,
                           @RequestParam("storeid") int storeid,
                           HttpServletResponse response) {
        try {
            String[] rfidss = rfids.split(";");
            if (rfidss.length <= 0)
                return;
            String[] idss = ids.split(";");
            if (commoService.dealBuyHistory(rfidss, idss, uid, storeid)) {
                response.getWriter().print("true");
            } else {
                response.getWriter().print("false");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回历史纪录页面
     *
     * @return
     */
    @RequestMapping("/history")
    public String toHistoryListPage() {
        return "view/buyhistory";
    }

    /**
     * 返回历史纪录页面
     *
     * @return
     */
    @RequestMapping("/historyformobile")
    public String toHistoryListPageForMobile() {
        return "view/buyhistoryformobile";
    }

    /**
     * 返回购买历史记录数据
     *
     * @return
     * @throws IOException
     */
    @RequestMapping("/back/getbuyhistory")
    @ResponseBody
    public List<History_T> getBuyHistory() throws IOException {
        List<History_T> res = new LinkedList<History_T>();
        res.add(new History_T(1, "怡宝矿泉水", "山东科技大学A区", "2017-07-21 13:37:11", 2.0));
        res.add(new History_T(2, "黑人牙膏", "山东科技大学B区", "2017-07-21 13:37:12", 9.99));
        return res;
    }

    /**
     * 添加新商品
     *
     * @param commo_name
     * @param price
     * @param rfid_number
     * @param store_id
     * @param aff
     * @param response
     */
    @RequestMapping("/addnewcommo")
    public void addNewStore(String commo_name, double price, String rfid_number, int store_id, String aff, HttpServletResponse response) {
        try {
            if (commoService.addNewCommo(commo_name, price, rfid_number, store_id, aff)) {
                response.getWriter().print("添加成功");
            } else {
                response.getWriter().print("添加失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    /**
//     * 根据顾客id返回购买历史记录
//     *
//     * @param uid
//     * @param resp
//     * @return
//     * @throws IOException
//     */
//    @RequestMapping("/back/getbuyhistory")
//    @ResponseBody
//    public List<BuyHistory> getBuyHistory(@RequestParam("uid") int uid, HttpServletResponse resp) throws IOException {
//        return commoService.getHistoryByUser(uid);
//    }
}
