package salesBuilder;

import factorySale.CloseSale;

/**
 *
 * @author Ana Teresa
 */
public class ConceteBuilderCloseSale extends ConcreteBuilderCreateSale {
    
    @Override
    public void createSpecificSale() {
        setSale(new CloseSale());
    }
    
}
