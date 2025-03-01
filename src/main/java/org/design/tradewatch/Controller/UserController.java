package org.design.tradewatch.Controller;

import org.design.tradewatch.Entity.Result;
import org.design.tradewatch.Entity.User;
import org.design.tradewatch.Service.UserService;
import org.design.tradewatch.Util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/info")
    public Result getInfo(){
       User user= userService.getInfo();
        return Result.success(user) ;
    }
    @PutMapping("/update")
    public Result update(User user){
        userService.update(user);
        return Result.success();
    }
}
