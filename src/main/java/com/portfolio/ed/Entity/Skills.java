
package com.portfolio.ed.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




@Entity
public class Skills {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotNull
    @Size(max=50, message= "No cumple con la longitud")
    private String name;
    
    @NotNull
    private long level;
    
    @Size(max=150, message= "No cumple con la longitud")
    private String logo;
    
  
    
    //Constructors
    
        public Skills() {
    }
        
        public Skills(String name, long level, String logo) {
        this.name = name;
        this.level = level;
        this.logo = logo;
    }
    
    //Getter and Setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }






 
    
    
    
}
