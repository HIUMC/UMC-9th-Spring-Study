package hello2.core2.web;

import hello2.core2.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURI().toString();

        System.out.println("myLogger.getClass() = " + myLogger.getClass());
        //MyLogger logger = myLogger.getObject();
        myLogger.setRequestURL(requestURL);

        myLogger.log("Controller Test");
        logDemoService.logic("test ID");
        return "success";
    }

}
