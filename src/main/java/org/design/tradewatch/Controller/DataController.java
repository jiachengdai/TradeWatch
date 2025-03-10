package org.design.tradewatch.Controller;

import org.design.tradewatch.Entity.EveryDayTrade;
import org.design.tradewatch.Entity.Result;
import org.design.tradewatch.Entity.TradeTypeStatic;
import org.design.tradewatch.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;
    @GetMapping("/getEveryDayTrade")
    public Result getEveryDayTrade(){
    List<EveryDayTrade> everyDayTradeList  = dataService.getEveryDayTrade();
    return Result.success(everyDayTradeList);
    }
    @GetMapping("/getTypeStatic")
    public Result getTypeStatic(){
        List<TradeTypeStatic>tradeTypeStatics=dataService.getTypeStatic();
        return Result.success(tradeTypeStatics);
    }

}

