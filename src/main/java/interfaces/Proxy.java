package interfaces;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Proxy {
    // metody abstrakcyjne
    public abstract String getClassName();
    // pola i metody klasowe
    private String address;

}
