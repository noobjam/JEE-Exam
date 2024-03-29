package Model;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Employe implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private List<String> skills;
    private String email;

    @ManyToMany(mappedBy = "employees")
    private Set<Project> projects = new HashSet<>();

    public Employe() {
    }

    public Employe(String nom, List<String> skills, String email) {
        this.nom = nom;
        this.skills = skills;
        this.email = email;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<String> getSkills() {
        return skills;
    }

}
