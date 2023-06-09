package kodlama.io.rentacar.entities;

import jakarta.persistence.*;
import kodlama.io.rentacar.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int modelYear;
    private String plate;
    private  double dailyPrice;
    @Enumerated(EnumType.STRING)

    private State state;
    @ManyToOne
    //@JsonManagedReference
    private Model model;
    @OneToMany(mappedBy = "Car")
    List<Maintenance>maintenances;
    @OneToMany(mappedBy ="Car")
    List<Rental>rentals;

}
