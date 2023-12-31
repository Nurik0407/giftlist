package com.example.giftlistb8.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "complaints")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "complaint_id_gen")
    @SequenceGenerator(name = "complaint_id_gen",
            sequenceName = "complaint_id_seq",allocationSize = 1,initialValue = 10)
    private Long id;
    private String complaint;
    private Boolean seen;

    @ManyToOne(cascade = {PERSIST, MERGE, REFRESH, DETACH})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
}