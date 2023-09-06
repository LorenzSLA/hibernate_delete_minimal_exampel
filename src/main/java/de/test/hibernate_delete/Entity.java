package de.test.hibernate_delete;
import jakarta.persistence.*;
@jakarta.persistence.Entity
@Table(name = "entity")
public class Entity {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id;
    @Version long version;
    @Column(name = "data") String data;
    public Entity(String data) {this.data = data;}
    public Entity() {}
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public long getVersion() {return version;}
    public void setVersion(long version) {this.version = version;}
    public String getData() {return data;}
    public void setData(String data) {this.data = data;}
}
