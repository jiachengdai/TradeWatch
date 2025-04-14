package org.design.tradewatch.Service.Impl;

import org.springframework.ai.client.AiClient;
import org.springframework.ai.prompt.Prompt;
import org.springframework.ai.prompt.messages.AssistantMessage;
import org.springframework.ai.prompt.messages.Message;
import org.springframework.ai.prompt.messages.SystemMessage;
import org.springframework.ai.prompt.messages.UserMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Completion {
    private final AiClient aiClient;
    private final static Integer MAX_SIZE = 5;
    private String completion;
    private List<Message> messages = new ArrayList<>();
    private final static Message system = new SystemMessage(
            "我设计了一个算法，他能够通过提供的数据交易表，检测出其中异常的交易行为，如：非法汇兑、非法集资、诈骗传销等等，他的输出是交易表中的异常用户、异常行为路径。你需要根据要求生成内容。生成的内容应该是纯文字，不应该使用markdown"
    );

    public Completion(AiClient aiClient) {
        this.aiClient = aiClient;
        messages.add(system);
    }

    private Completion addUserMessage(String message) {
        Message userMessage = new UserMessage(message);
        messages.add(userMessage);
        return this;
    }
    private Completion addAssistantMessage(String message){
        Message assistantMessage = new AssistantMessage(message);
        messages.add(assistantMessage);
        return this;
    }

    public String chat(String message){
        addUserMessage(message);
        String result = aiClient.generate(new Prompt(messages)).getGeneration().getText();
        addAssistantMessage(result);
        update();
        return result;
    }

    private void update(){
        if(messages.size() > MAX_SIZE){
            messages = messages.subList(messages.size() - MAX_SIZE, messages.size());
            messages.add(0,system);
        }
    }
}
