package enums;

/**
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public enum EnumStateSaleList {

    APPROVE("approve"),
    WAITING("waiting"),
    ACTIVE("active"),
    NEXT("next");

    private final String value;

    EnumStateSaleList(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
