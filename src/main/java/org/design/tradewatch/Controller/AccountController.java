package org.design.tradewatch.Controller;

import org.design.tradewatch.Entity.Account;
import org.design.tradewatch.Entity.Result;
import org.design.tradewatch.Service.AccountService;
import org.design.tradewatch.Util.JwtUtil;
import org.design.tradewatch.Util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/account")
@Validated
public class AccountController {
    @Autowired
    private AccountService accountService;
     @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/register")
    public Result register(@RequestParam String username, String password, Integer type) {
        Account account = accountService.findByUsername(username);
        if (account == null) {
            String MD5password =Md5Util.getMD5String(password);
            accountService.register(username, MD5password,type);
            return Result.success();
        } else {
            return Result.error("用户名被占用");
        }
    }

    @PostMapping("/login")
    public Result login(@RequestParam String username, String password) {
        Account account = accountService.findByUsername(username);
        if (account == null) {
            return Result.error("用户不存在!");
        }
        String MD5password = account.getPassword();
        if (MD5password.equals(Md5Util.getMD5String(password))) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("username", account.getUsername());
            claims.put("password", account.getPassword());
            String token = JwtUtil.genToken(claims);
            //将JWT存储至Redis
            ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
            stringStringValueOperations.set(token, token, 24000, TimeUnit.HOURS);
            return Result.success(token);
        } else {
            return Result.error("密码错误！");
        }

    }
    @GetMapping("/info")
    public Result getInfo (@RequestParam String username){
        Account account=accountService.findByUsername(username);
        return Result.success(account);
    }




}
