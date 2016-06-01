package enums;

/**
 * Enum class containing the final variables to access binary file names
 *
 * @author Robert Sánchez, Edgardo Quirós, Ana Teresa Quesada.
 */
public enum EnumFiles {

    USER_FILE_NAME("usersFile.bin"), // users binary file
    SALE_FILE_NAME("saleFile.bin"); // sale binary file
    private final String value;

    EnumFiles(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
