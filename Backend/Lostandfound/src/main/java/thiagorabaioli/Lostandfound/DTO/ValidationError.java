package thiagorabaioli.Lostandfound.DTO;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends  CustomError{

    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError(Instant instant, Integer status, String error, String path) {
        super(instant, status, error, path);
    }

    public void setFieldMessages(List<FieldMessage> erros) {
        this.erros = erros;
    }

    public void addErros(String fieldName, String message ){
        erros.add(new FieldMessage(fieldName, message));

    }
}
