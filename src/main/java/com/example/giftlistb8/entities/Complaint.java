package com.example.giftlistb8.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "complaints")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "complaint_seq")
    @SequenceGenerator(name = "complaint_seq",allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    private String complaint;
    private Boolean seen;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn()
    private User user;

    public Complaint(String complaint, Boolean seen) {
        this.complaint = complaint;
        this.seen = seen;
    }

}