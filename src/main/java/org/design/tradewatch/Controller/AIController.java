package org.design.tradewatch.Controller;

import org.design.tradewatch.Entity.Result;
import org.design.tradewatch.Service.Impl.Completion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AIController {

    private final Completion completion;

    public AIController(Completion completion) {
        this.completion = completion;
    }

    @GetMapping("/chat")
    public Result<String> chat(
            @RequestParam(value = "message",defaultValue = "Hi") String message
    ){
        String response= completion.chat(message);
        return Result.success(response);
    }
}

