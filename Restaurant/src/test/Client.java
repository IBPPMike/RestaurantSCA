package test;

import org.apache.tuscany.sca.host.embedded.SCADomain;

import restaurant.api.Menu;
import restaurant.api.RestaurantService;
 
public class Client {
 
  public static void main(String[] args) throws Exception {
    SCADomain scaDomain = SCADomain.newInstance("restaurant.composite");
    RestaurantService restaurantService = scaDomain.getService(RestaurantService.class, "RestaurantServiceComponent");
    Menu[] menus = restaurantService.getMenus();
    System.out.println("--- Menu ---");
    for (Menu m : menus) {
      System.out.println("- " + m.printMenu());
    }
    System.out.println();   
    Menu menu = menus[3];
    System.out.println("My choice: " + menu.printMenu());
    System.out.println();
    double price = restaurantService.getBill(menu);
    System.out.println("Price (" + menu.printMenu() + "): " + price);
    scaDomain.close();
  }
}
