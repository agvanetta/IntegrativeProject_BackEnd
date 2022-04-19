package IntegrativeProject.DentalClinic.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "addresses")

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private Integer number;
    private String city;



}
