package restaurant.lib;

import org.osoa.sca.annotations.Init;
import org.osoa.sca.annotations.Service;
 
import restaurant.api.Menu;
import restaurant.api.MenuService;
 
@Service(MenuService.class)
public class MenuServiceImpl implements MenuService {
 
  private Menu[] menus;
  private double[] prices;
 
  @Init
  public void init() {
    this.menus = new Menu[] {
            new MenuImpl(0, "Grilled hamburger with French fries" ),
            new MenuImpl(1, "Roasted chicken with vegetables"),
            new MenuImpl(2, "Duck breast in an orange sauce"),
            new MenuImpl(3, "Duck foie gras & mango chutney") };
    this.prices = new double[] { 10, 15, 35, 50 };
  }
 
  public Menu[] getMenu() {
    return this.menus;
  }
 
  public double getPrice(Menu menu) {
    return this.prices[((MenuImpl) menu).getId()];
  }
}
