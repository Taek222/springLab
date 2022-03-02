package kr.co.soojintaek.mvc.controller;

import kr.co.soojintaek.mvc.domain.Tanent;
import kr.co.soojintaek.mvc.service.TanentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/emp")
@RestController
public class TanentController {

    @Autowired
    private TanentService tanentService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/{domain}")
    @ResponseBody
    public void getTanentDetail(@PathVariable String domain, @ModelAttribute Tanent user, Model model){
        logger.info("*****user: {}", user.toString());
        model.addAttribute(user);
    }
}
