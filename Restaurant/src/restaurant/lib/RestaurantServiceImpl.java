package restaurant.lib;

import org.osoa.sca.annotations.Reference;
import org.osoa.sca.annotations.Service;
 
import restaurant.api.BillService;
import restaurant.api.Menu;
import restaurant.api.MenuService;
import restaurant.api.RestaurantService;
 
@Service(RestaurantService.class)
public class RestaurantServiceImpl implements RestaurantService {
 
  private MenuService menuService;
  private BillService billService;
 
  @Reference
  public void setMenuService(MenuService menuService) {
    this.menuService = menuService;
  }
 
  @Reference
  public void setBillService(BillService billService) {
    this.billService = billService;
  }
 
  public double getBill(Menu menu) {
    double menuPrice = this.menuService.getPrice(menu);
    return this.billService.getBill(menuPrice);
  }
 
  public Menu[] getMenus() {
    return this.menuService.getMenu();
  }  
}
