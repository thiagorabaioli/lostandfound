package thiagorabaioli.Lostandfound.entities.enums;

public enum UserAPPTYPE {

    USER(1, "User"),
    ADMIN(2, "Admin"),
    OTHER(3, "Other");
    private int cod;
    private String description;

    private UserAPPTYPE(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }
    public int getCod() {
        return cod;
    }
    public String getDescription() {
        return description;
    }

    public static UserAPPTYPE toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (UserAPPTYPE x : UserAPPTYPE.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id invalid: " + cod);
    }
    
    
}
