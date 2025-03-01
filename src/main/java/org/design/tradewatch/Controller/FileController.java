package org.design.tradewatch.Controller;

import org.design.tradewatch.Entity.File;
import org.design.tradewatch.Entity.Result;
import org.design.tradewatch.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;
    @PostMapping("/new")
    public Result addFile(@RequestParam String filename,String fileurl){
        fileService.addFile(filename,fileurl);
        return Result.success();

    }
}
