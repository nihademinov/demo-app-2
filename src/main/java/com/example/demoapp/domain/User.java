package com.example.demoapp.domain;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "UserAccount")
public class User {

    @Id
    @Column(name = "UserId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Email")
    private String email;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinTable(name = "UserRole",
            joinColumns = {@JoinColumn(name = "UserId", referencedColumnName = "UserId")},
            inverseJoinColumns = {@JoinColumn(name = "RoleId", referencedColumnName = "RoleId")})
    private List<Role> roles = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    private UserContact contact;

    @Column(name = "Active")
    private boolean active;

    @Column(name = "CreatedAt", updatable = false)
    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "UpdatedAt")
    @UpdateTimestamp
    private Instant updatedAt;


    public void setContact(UserContact contact) {
        this.contact = contact;
        if (contact != null) {
            contact.setUser(this);
        }
    }


}
