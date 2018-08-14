package postgresWS.Models;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "Userss")
public @Data class User
{
    // why this @Id is the persistence one and not the annotation one?
    @Id
    Long id;
    String username,
            password,
            first_name,
            last_name;


}
