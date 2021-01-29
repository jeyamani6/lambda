package com.template.employee;
import Response.EmpResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.EmpDetails;
import template.TemplateService;
public class lambdaEmployee implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent>
{
    TemplateService service=new TemplateService();
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, Context context) {
        String request=apiGatewayProxyRequestEvent.getBody();
        String res;
        APIGatewayProxyResponseEvent apiGatewayProxyResponseEvent=new APIGatewayProxyResponseEvent();
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            System.out.println("before try");
            EmpDetails empDetails=objectMapper.readValue(request, EmpDetails.class);
            System.out.println("After try");
            EmpResponse response=service.createUser(empDetails);
            res=objectMapper.writeValueAsString(response);
            apiGatewayProxyResponseEvent.setBody(res);
            return apiGatewayProxyResponseEvent;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return apiGatewayProxyResponseEvent;
    }
}