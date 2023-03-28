//package com.mortarai;
//
//import com.openai.api.models.Completion;
//import com.openai.api.models.CompletionRequest;
//import com.openai.api.models.Engine;
//import com.openai.api.models.enums.CompletionContentType;
//import com.openai.api.models.enums.EngineId;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ChatGPTIntegration {
//    private static final String API_KEY = "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";
//    private OpenAI api;
//    private Engine engine;
//
//    public ChatGPTIntegration() throws OpenAIException {
//        api = new OpenAI(API_KEY);
//        engine = api.engines().getById(EngineId.CURIE.getEngineId());
//    }
//
//    public String generateEmail() throws OpenAIException {
//        CompletionRequest request = CompletionRequest.builder()
//                .engine(engine.getId())
//                .prompt("Generate a realistic email address")
//                .maxTokens(10)
//                .temperature(0.7)
//                .n(1)
//                .stop(null)
//                .contentType(CompletionContentType.TEXT)
//                .build();
//        Completion response = api.completions().create(request);
//        return response.getChoices().get(0).getText().trim();
//    }
//
//    public List<String> generateEmails(int count) throws OpenAIException {
//        List<String> emails = new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            String email = generateEmail();
//            emails.add(email);
//        }
//        return emails;
//    }
//}
