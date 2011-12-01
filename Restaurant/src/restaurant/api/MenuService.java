package restaurant.api;

public interface MenuService {
	  Menu[] getMenu();
	  double getPrice(Menu menu);
}
