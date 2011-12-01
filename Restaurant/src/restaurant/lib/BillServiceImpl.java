package restaurant.lib;

import org.osoa.sca.annotations.Reference;
import org.osoa.sca.annotations.Service;
 
import restaurant.api.BillService;
import restaurant.api.TipService;
import restaurant.api.VatService;
 
@Service(BillService.class)
public class BillServiceImpl implements BillService {
 
  private VatService vatService;
  private TipService tipService;
 
  @Reference
  public void setVatService(VatService vatService) {
    this.vatService = vatService;
  }
 
  @Reference
  public void setTipService(TipService tipService) {
    this.tipService = tipService;
  }
 
  public double getBill(double menuPrice) {
    double pricewithTaxRate = 
                   this.vatService.getPriceWithVat(menuPrice);
    double priceWithTipRate = 
                   this.tipService.getPriceWithTip(pricewithTaxRate);
    return priceWithTipRate;
  }
}
