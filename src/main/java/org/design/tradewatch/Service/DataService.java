package org.design.tradewatch.Service;


import org.design.tradewatch.Entity.EveryDayTrade;
import org.design.tradewatch.Entity.TradeTypeStatic;

import java.util.List;

public interface DataService {
   List< EveryDayTrade> getEveryDayTrade();

    List<TradeTypeStatic> getTypeStatic();
}
