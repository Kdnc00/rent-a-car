package kodlama.io.rentacar.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//lombak

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy="brand")
    //@JsonBackReference
    private List<Model>models;

}

