
package com.portfolio.ed.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class dtoSkills {
    
  
    @NotBlank
    @Size(max=50, message= "No cumple con la longitud")
    private String name;
    

    private long level;
    
    @Size( max=150, message= "No cumple con la longitud")
    private String logo;
    
    //Constructors

    public dtoSkills() {
    }

        
    public dtoSkills(String name, long level, String logo) {
        this.name = name;
        this.level = level;
        this.logo = logo;
    }
    
    //Getter and Setter

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
