import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor @RequiredArgsConstructor
public class Address implements Serializable {

    @NonNull @Basic(optional = false)
    private String street;

    @NonNull
    private int number;
}
