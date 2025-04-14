package org.design.tradewatch.Service.Impl;

import org.design.tradewatch.Entity.Report;
import org.design.tradewatch.Entity.ReportContent;
import org.design.tradewatch.Mapper.ReportMapper;
import org.design.tradewatch.Service.GraphService;
import org.design.tradewatch.Service.ReportService;
import org.design.tradewatch.Util.AliOssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;

    @Autowired
    private GraphService graphService;
    @Autowired
    private Completion completion;

    @Override
    public void makeReport(MultipartFile file, String algorithm, String datawrite, String multialgo) throws Exception {
        //这里是生成报告的分析逻辑


        //生成报告列表项加入数据库
        Integer grade=0;
        Integer dangernum=0;
        String updatetime = LocalDateTime.now().toString().substring(0,19);
        String reportUrl="";
       String reportName=file.getOriginalFilename().substring(0,file.getOriginalFilename().length()-4);
        reportMapper.newReport(reportName,updatetime,grade,dangernum,reportUrl,algorithm);

        Integer reportId=reportMapper.getLatestReportId();
//        Integer graphId=graphService.makeNewReportGraph();

        makeReportContent(reportId);

    }

    private void makeReportContent(Integer reportId) throws Exception {
        String reportName=getReportName(reportId);
        Integer typeACount=graphService.getTradeTypeNum(reportName,"A");
        Integer typeBCount=graphService.getTradeTypeNum(reportName,"B");
        Integer typeCCount=graphService.getTradeTypeNum(reportName,"C");
        Integer sum=typeACount+typeBCount+typeCCount;

        Double itema=typeACount*1.0/sum*100;
        Double itemb=typeBCount*1.0/sum*100;
        Double itemc=typeCCount*1.0/sum*100;

    String reportText=generateReportContent(reportId,typeACount,typeBCount,typeCCount);



    reportMapper.newReportContent(reportId,itema,itemb,itemc,reportText);

    }

    private String generateReportContent(Integer reportId,Integer typeACount,Integer typeBCount ,Integer typeCCount) throws Exception {
        String text1=
                "    <h3>一、项目背景与研究目的</h3>" +
                "    <p>随着金融活动日益频繁，非法资金交易行为呈现智能化、隐蔽化趋势，严重扰乱市场秩序，威胁国家金融安全。传统依靠人工排查的方式效率低下、漏报率高。</p>" +
                "    <p>本项目旨在设计并实现一个基于数据交易表的异常交易检测算法，识别非法汇兑、非法集资、诈骗传销等典型行为，自动输出异常用户与其行为路径，为金融监管提供技术支持。    </p>" +
                "    <h3>二、数据说明</h3>" +
                "    <table border=\"1\" cellspacing=\"0\" cellpadding=\"8\" style=\"width: 100%; border-collapse: collapse;\">" +
                "        <thead>" +
                "            <tr>" +
                "                <th>字段名</th>" +
                "                <th>描述</th>" +
                "            </tr>" +
                "        </thead>" +
                "        <tbody>" +
                "            <tr>" +
                "                <td>step</td>\t\t\t\t\t\t\t\t " +
                "" +
                "                <td>交易时间步</td>" +
                "            </tr>" +
                "            <tr>" +
                "                <td>type</td>" +
                "                <td>交易类型</td>" +
                "            </tr>" +
                "            <tr>" +
                "                <td>amount</td>" +
                "                <td>金额</td>" +
                "            </tr>" +
                "            <tr>" +
                "                <td>nameOrig</td>" +
                "                <td>发起账户</td>" +
                "            </tr>" +
                "            <tr>" +
                "                <td>oldbalanceOrg</td>" +
                "                <td>原金额</td>" +
                "            </tr>" +
                "            <tr>" +
                "                <td>newbalanceOrig</td>" +
                "                <td>变动后金额</td>" +
                "            </tr>" +
                "            <tr>" +
                "                <td>nameDest</td>" +
                "                <td>目标账号</td>" +
                "            </tr>" +
                "            <tr>" +
                "                <td>oldbalanceDest</td>" +
                "                <td>原金额</td>" +
                "            </tr>" +
                "            <tr>" +
                "                <td>newbalanceDest</td>" +
                "                <td>变动后金额</td>" +
                "            </tr>" +
                "   " +
                "        </tbody>" +
                "    </table>" +
                "    <h3>三、算法设计</h3>" +
                "<h4> 3.1 总体架构</h4>" +
                " <p>   采用图结构表示交易网络：" +
                "        " +
                "        节点表示用户；" +
                "        " +
                "        有向边表示交易记录（从发送方指向接收方）。" +
                "        " +
                "        通过交易路径挖掘与行为模式识别，检测异常。</p>" +
                "<h4>3.2 异常交易行为概述</h4>" +
                "<h5>3.2.1 非法汇兑</h5>" +
                "<p>非法汇兑通常具有交易数量多，交易金额大等特点，对应到匹配规则上通常为：<br/>" +
                "    ·两个用户结点之间的边数目 ；<br/>" +
                "    ·单次交易的金额 超过了设定的风险阈值（通常为20000左右）； <br/>" +
                "    ·结点交易后的余额通常较少，交易边中交易发起结点和交易接收结点所在的银行不同；<br/></p>" +
                " <h5>3.2.2 非法集资</h5> " +
                " <p>" +
                "    非法集资的情况通常包含多数用户向少数账户中汇款的情况，这种集资可能是同一银行内部也可以是跨银行的操作，汇款集资的对象很可能是具有高风险的账户，一旦识别出该用户必须快速对其账户进行冻结操作以防止后续损失扩大。针对该类型的特征匹配规则如下：<br/>" +
                "·交易图结点总如度数 D>20；<br/>" +
                "·交易完成后用户的账户余额较大，用户交易完成后的账户余额和交易之前的平均账户余额的比值 超过5； <br/>" +
                "·交易的金额具有一定的规律性，如每笔交易的金额近似相同或交易金额按照一定的规律波动；<br/>" +

                " </p>  " +
                "<h5>3.2.3 腐败受贿</h5>" +
                "<p>" +
                "    腐败受贿类型的交易通常存在多种情况，包括周期性的存取操作，短期内资金只出不进等。针对该类型的特征匹配规则如下：<br>" +
                "·交易图结点在某时间段内入度 和出度 的差值超过10；<br>" +
                "·图结点在余额处于较少的水平后就不存在后续的交易记录；<br>" +

                "</p>";
        String text2="<h3>四、异常行为统计</h3>" +
                "<h4>4.1 异常交易行为</h4>" +
                "<table border=\"1\" cellspacing=\"0\" cellpadding=\"8\" style=\"width: 100%; border-collapse: collapse;\">" +
                "    <thead>" +
                "        <tr>" +
                "            <th>异常类型</th>" +
                "            <th>涉及交易路径数" +
                "            </th>" +
                "        </tr>" +
                "    </thead>" +
                "    <tbody>" +
                "        <tr>" +
                "            <td>非法汇兑</td>\t\t\t\t\t\t\t\t " +
                "" +
                "            <td>"+ typeACount +"</td>" +
                "        </tr>" +
                "        <tr>" +
                "            <td>非法集资</td>" +
                "            <td>"+ typeBCount +"</td>" +
                "        </tr>" +
                "        <tr>" +
                "            <td>诈骗传销</td>" +
                "            <td>"+ typeCCount +"</td>" +
                "        </tr>" +
                "        " +
                "    " +
                "" +
                "    </tbody>" +
                "</table>" +
                "<h4>4.2 异常用户</h4>" +
                "<p>共检测到异常用户30人，其中高风险10人，中风险5人，低风险9人</p>" +
                "<table border=\"1\" cellspacing=\"0\" cellpadding=\"8\" style=\"width: 100%; border-collapse: collapse;\">" +
                "    <thead>" +
                "        <tr>" +
                "            <th>用户ID</th>" +
                "            <th>涉及风险交易数</th>" +
                "        </tr>" +
                "    </thead>" +
                "    <tbody>" +
                "        <tr>" +
                "            <td>1234</td>\t\t\t\t\t\t\t\t " +
                "" +
                "            <td>10</td>" +
                "        </tr>" +
                "        <tr>" +
                "            <td>1234</td>" +
                "            <td>5</td>" +
                "        </tr>" +
                "        <tr>" +
                "            <td>1234</td>" +
                "            <td>9</td>" +
                "        </tr>" +
                "        " +
                "    " +
                "" +
                "    </tbody>"+
                "<h3>五、总结</h3>";
        String summary=completion.chat("现在我希望输出一个分析报告，下面是大概的分析结果总结，请根据他们生成一段总结分析,除了对结果的总结还需要提供对应每种风险类型的解决措施，只需要输出纯文本即可,不要输出任何多余的内容。"+text2);
        String text4="<p>"+summary+"</p>";
        String reportText = text1 + text2 + text4;
        InputStream inputStream = new ByteArrayInputStream(reportText.getBytes(StandardCharsets.UTF_8));

        // 生成唯一的文件名
            String originalFilename = "document.html"; // 你可以根据需要更改这个名称
            String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));

            // 上传到阿里云OSS
            String url = AliOssUtil.uploadFile(fileName, inputStream);
        inputStream.close();
        Integer dangerNum=typeACount+typeBCount+typeCCount;
        Integer grade=0;
        if(dangerNum>500){
            grade=5;
        }
        else if (dangerNum>300){
            grade=4;
        }
        else if (dangerNum>100){
            grade=3;
        }
        else if (dangerNum>50){
            grade=2;
        }
        else  {
            grade = 1;
        }
        reportMapper.setReport(reportId,url,dangerNum,grade);
        return text1+text2+text4;
    }


@Override
    public List<Report> getAllReports() {
       return   reportMapper.getAllReports();
    }

    @Override
    public ReportContent getReportContent(Integer reportId) {


        return reportMapper.getReportContent(reportId);
    }

    @Override
    public String getReportName(Integer reportId) {
        return reportMapper.getReportName(reportId);
    }
}
