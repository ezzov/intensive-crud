package web.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private Long id;

    @Column(name = "customername")
    private String customerName;

    public Customer(String customerName) {
        this.customerName = customerName;
    }

}
