package relationShips;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor @RequiredArgsConstructor
public class Hobbies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

//    @Version
//    private int version;

    @NonNull
    private String hobbyName;
}
