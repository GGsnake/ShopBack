package io.sbed.modules.api.controller;

import io.sbed.modules.sys.util.SmsUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * Created by liujupeng on 2018/11/5.
 */
@RestController
@RequestMapping(value ="/app")
public class UserController {

    @GetMapping("/val")
    public void sysoo(){
        System.out.println("sssssssssssssss");
    }

}
