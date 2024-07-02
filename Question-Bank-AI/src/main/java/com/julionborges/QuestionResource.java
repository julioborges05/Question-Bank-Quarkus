package com.julionborges;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/ai/question")
@Produces(MediaType.APPLICATION_JSON)
public class QuestionResource {

    @Inject
    Assistant assistant;

    @Inject
    @RestClient
    QuestionService questionService;

    @GET
    @Path("/ok")
    public String test() {
        return assistant.chat("""
                I'm testing my API, just reply with an OK!
                """);
    }

    @GET
    @Path("/prompt")
    public String prompt(@QueryParam("text") String text) {
        return assistant.chat(text);
    }

    @GET
    public Question getGeneratedQuestion(@QueryParam("topic") String topic, @QueryParam("language") String language) {
        return assistant.createMathQuestion(topic, language);
    }

    @POST
    public Question createQuestion(@QueryParam("topic") String topic, @QueryParam("language") String language) {
        return questionService.addQuestion(assistant.createMathQuestion(topic, language));
    }

}
