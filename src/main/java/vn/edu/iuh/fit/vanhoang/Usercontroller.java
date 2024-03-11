package vn.edu.iuh.fit.vanhoang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class Usercontroller {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/User")
    public User getUser() {
        User user = new User(1, "Hoang");
        return user;
    }

    @GetMapping("/Department")
    public Department getDepartment() {
        Department department = new Department(1, "CNTT");
        return department;
    }

    @GetMapping(value = "/template/User")
    public User getUserRestTemplate() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<User> entity = new HttpEntity<User>(headers);

        return restTemplate.exchange(" http://localhost:8080/User", HttpMethod.GET, entity, User.class).getBody();
    }
}
