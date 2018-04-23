package controller;

import model.Shop;
import mvc.view.View;

/**
 * Created by Denis on 14.03.2018.
 */
public class Controller {
    private Shop shop;
    private View view;

    public Controller(Shop shop){
        this.shop = shop;
        view = new View(this);
        view.menu();
    }

    public String handleRequest(String menuItem){
        switch (menuItem){
            case "1":
                String department = view.askDepartment();
                shop.createDepartment(department);
                return shop.getAllDepartments();
            case "2":
                String goods = view.askGoodsNumber();
                shop.supplyGoods(goods);
                return shop.getAllDepartments();
            case "3":
                String delDepartment = view.askDelDepartment();
                shop.deleteDepartment(delDepartment);
                return shop.getAllDepartments();
            default:{
                return "Ошибка ввода.";
            }
        }
    }
}
