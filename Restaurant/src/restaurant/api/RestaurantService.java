package restaurant.api;

public interface RestaurantService { 
	  Menu[] getMenus();
	  double getBill(Menu menu);
}
