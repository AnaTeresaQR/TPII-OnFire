package enums;

/**
 * Enum class containing the final variables to construct parts of a sale
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public enum EnumSale {

    MIN_YEAR(1900), // min year of the car sale
    MAX_YEAR(2016), // max year of the car sale
    MAX_SALE_DAYS(7), // max days of the sale
    MIN_SALE_OFFER(100000); //  in offer of the sale

    private final int nums;

    private EnumSale(int nums) {
        this.nums = nums;
    }

    public int getNums() {
        return nums;
    }

}
