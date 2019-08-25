package relationShips;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @RequiredArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String name;

//    @OneToMany(fetch = FetchType.LAZY)
//    @NonNull
//    private List<Hobbies> hobbies;
}
