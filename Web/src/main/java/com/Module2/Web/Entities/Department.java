package com.Module2.Web.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String title;
    private Boolean isActive;
    private LocalDateTime createdAt;
    @PrePersist
    public void onCreate()
    {
        this.createdAt = LocalDateTime.now();
        if(this.isActive == null)
        {
            this.isActive = true;
        }
    }
}
