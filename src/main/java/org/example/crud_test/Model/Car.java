//package org.example.crud_test.Model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "cars")
//public class Car {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long carId;
//
//    @Column(name = "brand", nullable = false, unique = true)
//    private String brand;
//
//    @ManyToOne
//    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "fk_car_owner"))
//    private User owner;
//}
