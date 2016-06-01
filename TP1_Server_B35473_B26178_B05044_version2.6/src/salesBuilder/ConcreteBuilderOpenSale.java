package salesBuilder;

import factorySale.OpenSale;

/**
 *
 * @author Ana Teresa
 */
public class ConcreteBuilderOpenSale extends ConcreteBuilderCreateSale {

    @Override
    public void createSpecificSale() {
        setSale(new OpenSale());
    }

}
