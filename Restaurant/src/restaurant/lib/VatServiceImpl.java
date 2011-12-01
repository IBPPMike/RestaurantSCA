package restaurant.lib;

import org.osoa.sca.annotations.Service;

import restaurant.api.VatService;
 
@Service(VatService.class)
public class VatServiceImpl implements VatService {
 
  public double vatRate;
 
  public VatServiceImpl(){
    this.vatRate=19.6;
  }
 
  public double getPriceWithVat(double price) {
    return price * this.vatRate/100 + price;
  }  
}
