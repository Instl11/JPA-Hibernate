import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MyStudents")
@IdClass(Address.class)
@Data
@NoArgsConstructor
public class Student {

    private String name;

    @EmbeddedId
    private Address address;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return "Mr. " + name;
    }
}
