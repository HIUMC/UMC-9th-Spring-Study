package hello2.core2.web;


import hello2.core2.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

        //private final ObjectProvider<MyLogger> myLogger;
        private final MyLogger myLogger;

        public void logic(String id) {
            //MyLogger logger = myLogger.getObject();
            myLogger.log("service id = " + id);
        }
}
