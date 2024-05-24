package com.memesapp.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString(exclude = {"createdBy"})
@Table(name = "memes")
public class Memes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(columnDefinition="bytea")
    private byte[] image;
    private String category;
    private String labels;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
    private String createdBy;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="userId", referencedColumnName="id", nullable = false)
    })
    @JsonIgnore
    private Users users;
}
