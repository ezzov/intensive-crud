package web.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "projects")
public class Project {

    @Id
    private Long id;

    @Column(name = "projectname")
    private String projectName;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Transient
    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees;

    public Project(Long id, String projectName, Customer customer, Set<Employee> employees) {
        this.id = id;
        this.projectName = projectName;
        this.customer = customer;
        this.employees = employees;
    }

}
