package model;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Denis on 14.03.2018.
 */
public class Shop {
    public static final String SHOP_NAME = "Ashan";
    private static ArrayList<Department> departments;
    private int shopNumber = 0;

    public Shop(){
        if(shopNumber != 0){
            return;
        }else {
            departments = new ArrayList<Department>();
            shopNumber++;
        }
    }

    public void createDepartment(String name, int goods, int floor){
        departments.add(new Department(name, goods, floor));
    }

    public void createDepartment(String department){
        String[] dep = department.split(",");
        String name = dep[0];
        int goods = Integer.parseInt(dep[1]);
        int floor = Integer.parseInt(dep[2]);
        departments.add(new Department(name, goods, floor));
    }

    public void deleteDepartment(String name){
        for(Department d : departments){
            if(d.getName().equals(name)){
                departments.remove(d);
                return;
            }
        }
    }

    public void sortDepartments(Comparator comparator){
    }

    public void supplyGoods(String goods){
        String[] suppliedGoods = goods.split("-");
        String departmentName = suppliedGoods[0];
        int quantity = Integer.parseInt(suppliedGoods[11]);
        for(Department d : departments){
            if(d.getName().equals(departmentName)){
                d.receive(quantity);
                return;
            }
        }
    }

    public String getAllDepartments(){
        return departments.toString();
    }

    private class Department{
        private String name;
        private int goods;
        private int floor;

        public Department(String name, int goods, int floor) {
            this.name = name;
            this.goods = goods;
            this.floor = floor;
        }

        void sell(int number){
            goods -= number;
        }

        void receive(int number){
            goods +=number;
        }

        String getName(){
            return name;
        }

        @Override
        public String toString() {
            return "Department{" +
                    "name='" + name + '\'' +
                    ", goods=" + goods +
                    ", floor=" + floor +
                    '}';
        }
    }
}
