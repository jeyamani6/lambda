package template;
import Response.EmpResponse;
import entity.EmpDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;



public class TemplateService {
    RestTemplate restTemplate=new RestTemplate();
    public EmpResponse createUser(EmpDetails template)
    {
        System.out.println("Entering servce class");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<EmpDetails> entity = new HttpEntity<EmpDetails>(template, headers);
        ResponseEntity<EmpResponse> responseEntity =  restTemplate
                .exchange("https://reqres.in/api/users", HttpMethod.POST, entity, EmpResponse.class);
        System.out.println("Response entity-"+responseEntity.getBody());
        return responseEntity.getBody();
    }
}
