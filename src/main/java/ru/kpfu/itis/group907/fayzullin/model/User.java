package ru.kpfu.itis.group907.fayzullin.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;


@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;

    @NotBlank(message = "Name shouldn't be blank!")
    @Size(max = 64, message = "Max name size: 64")
    @Column(length = 64, nullable = false)
    private String name;

    @NotBlank(message = "Lastname shouldn't be  blank")
    @Size(max = 64, message = "Max lastname size: 64")
    @Column(length = 64)
    private String lastname;

    @NotBlank(message = "Email shouldn't be blank!")
    @Size(min = 5, max = 100, message = "")
    @Column(nullable = false, length = 100)
    private String email;

    @Size(min = 8, max = 64, message = "Password should contains from 8 to 64 symbols")
    @Column(nullable = false, length = 64)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoles(Set<Role> role) {
        this.roles = role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return true;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
