package org.design.tradewatch.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.design.tradewatch.Entity.EveryDayTrade;
import org.design.tradewatch.Entity.TradeTypeStatic;

import java.util.List;

@Mapper
public interface DataMapper {
    @Select("select tradedate ,sum(tradenum)as tradetotal from everydaynewtrade group by tradedate ")
    List<EveryDayTrade >getEveryDayTrade();
    @Select("select type,sum(tradenum) as total from everydaynewtrade group by type")
    List<TradeTypeStatic> getTypeStatic();
}
