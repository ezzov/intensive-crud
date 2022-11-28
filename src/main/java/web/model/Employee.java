package web.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "emploees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastname;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @Fetch(FetchMode.JOIN)
    @JoinTable(name = "emploees_projects",
            joinColumns = @JoinColumn(name = "emploee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private Set<Project> projects;

    public Employee(Long id, String name, String lastname, Position position, Set<Project> projects) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.position = position;
        this.projects = projects;
    }
}
