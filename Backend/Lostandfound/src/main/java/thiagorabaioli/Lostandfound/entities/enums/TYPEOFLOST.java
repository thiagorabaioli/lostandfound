package thiagorabaioli.Lostandfound.entities.enums;

public enum TYPEOFLOST {

    WITH_VALUE(1, "With Value"),
    WITHOUT_VALUE(2, "WITHOUT Value"),
    OTHER(3, "Other");
    private int cod;
    private String description;

    private TYPEOFLOST(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }
    public int getCod() {
        return cod;
    }
    public String getDescription() {
        return description;
    }

    public static TYPEOFLOST toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (TYPEOFLOST x : TYPEOFLOST.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id invalid: " + cod);
    }
    
    
}
