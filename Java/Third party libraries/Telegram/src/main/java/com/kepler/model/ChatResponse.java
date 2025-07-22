package com.kepler.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ChatResponse {
    private String id;
    private String object;
    private long created;
    private String provider;
    private String model;
    private List<Choice> choices;
    private Usage usage;

    @JsonProperty("prompt_logprobs")
    private Object promptLogprobs;

    @Data
    public static class Choice {
        private int index;
        private Message message;

        @JsonProperty("finish_reason")
        private String finishReason;

        private Object logprobs;
    }

    @Data
    public static class Message {
        private String role;
        private String content;

        @JsonProperty("tool_calls")
        private List<Object> toolCalls;

        @JsonProperty("reasoning_content")
        private Object reasoningContent;
    }

    @Data
    public static class Usage {
        @JsonProperty("prompt_tokens")
        private int promptTokens;

        @JsonProperty("completion_tokens")
        private int completionTokens;

        @JsonProperty("total_tokens")
        private int totalTokens;
    }
}
