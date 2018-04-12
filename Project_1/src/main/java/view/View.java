package view;

import utils.viewHelper.Menu;

/**
 * Created by Denis on 01.04.2018.
 */
public class View {

    public View(){
        System.out.println(Menu.HELLO);
    }

    public void showMenu(){
        System.out.println("");
        System.out.println(Menu.OPTION_1);
        System.out.println(Menu.OPTION_2);
        System.out.println(Menu.OPTION_3);
        System.out.println(Menu.OPTION_4);
    }

    public void reply(String reply){
        System.out.println(reply);
    }
}
