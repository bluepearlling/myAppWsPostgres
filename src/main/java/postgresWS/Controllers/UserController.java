package postgresWS.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import postgresWS.Models.User;
import postgresWS.Repositories.UserRepo;

import java.util.List;

@RestController
public class UserController
{
    @Autowired
    UserRepo userRepo;


    //how does actual execution of it work actually?
    // public String create(String firstname, String lastname)
    @PostMapping("/user/create")
    public String create(@RequestBody User newUser)
    {
        String userId = "";
        try
        {
            userRepo.save(newUser);
            //userId = String.valueOf(newUser.getId());
        }
        catch (Exception ex)
        {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created with id = " + userId;
    }


    //so my url will be sth like localhost/8080/user/all
    @GetMapping(name="/user/all")
    public List<User> getAllUsers()
    {
        return userRepo.findAll();
    }


    // takes the id and the User(java type) as input then find it by id then save the updated user
    @PutMapping(name="/user/update")
    public User updateUserById(@RequestParam("id") Long id, @RequestBody User updatedUser) throws Exception
    {
        User user = userRepo.findById(id).orElseThrow(()->new Exception("Cannot find user of ID: " + id));
        User updated_User = userRepo.save(updatedUser);
        return updated_User;
    }

    //typed this out myself to try
    // what is the ResponseEntity<?> in his version
    @DeleteMapping(name="/user/delete")
    public String deleteUser(@RequestParam("id")Long id) throws Exception
    {
        User user = userRepo.findById(id).orElseThrow(()->new Exception("Cannot find the user of ID: " + id));
        userRepo.delete(user);
        return("User of id " + id + "has been deleted");
    }
}

