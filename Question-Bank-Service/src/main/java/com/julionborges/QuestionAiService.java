package com.julionborges;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://question-bank-ai:8081/ai/question")
@Produces(MediaType.APPLICATION_JSON)
public interface QuestionAiService {

    @POST
    public Question createQuestion(@QueryParam("topic") String topic, @QueryParam("language") String language);

}
