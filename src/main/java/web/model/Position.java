package web.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "positions")
public class Position {

    @Id
    private Long id;

    private String position;

    public Position(Long id, String position) {
        this.id = id;
        this.position = position;
    }

}
