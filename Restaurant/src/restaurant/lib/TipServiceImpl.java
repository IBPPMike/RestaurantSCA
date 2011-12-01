package restaurant.lib;

import org.osoa.sca.annotations.Property;
import org.osoa.sca.annotations.Service;
 
import restaurant.api.TipService;
 
@Service(TipService.class)
public class TipServiceImpl implements TipService {
 
  @Property
  public double tipRate;
 
  public TipServiceImpl(){
    this.tipRate=10;
  }
 
  public double getPriceWithTip(double price) {
    return price * this.tipRate/100 + price;
  }
}
