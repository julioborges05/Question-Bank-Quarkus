package com.julionborges;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.awt.*;
import java.util.List;

@RegisterRestClient(baseUri = "http://question-bank-app:8080/questions")
@Produces(MediaType.APPLICATION_JSON)
public interface QuestionService {

    @GET
    public List<Question> getQuestions();

    @GET
    @Path("/findById")
    public Question findQuestionById(@QueryParam("id") Long id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Question addQuestion(Question question);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Question updateQuestion(Question question);

    @DELETE
    public void deleteQuestion(@QueryParam("id") Long id);

}
