package thiagorabaioli.Lostandfound.entities.enums;

public enum TYPEOFINTERATION {

    INSERT(1, "iNSERT"),
    DELIVERY(2, "WITHOUT Value"),
    WAITING(3, "Other");
    private int cod;
    private String description;

    private TYPEOFINTERATION(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }
    public int getCod() {
        return cod;
    }
    public String getDescription() {
        return description;
    }

    public static TYPEOFINTERATION toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (TYPEOFINTERATION x : TYPEOFINTERATION.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id invalid: " + cod);
    }
    
    
}
