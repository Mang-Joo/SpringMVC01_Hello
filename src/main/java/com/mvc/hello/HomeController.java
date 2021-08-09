package com.mvc.hello;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import com.mvc.hello.dto.AdressDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/home.do", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate );

        return "home";
    }

    @RequestMapping(value = "/command.do", method = RequestMethod.GET)
    public String getCommand(Model model, String name, @RequestParam("addr") String address, String phone) {
        System.out.println(name + ", " + address + ", " + phone);

        model.addAttribute("dto", new AdressDto(name, address, phone));

        return "getcommand";
    }

    @RequestMapping(value = "/command.do", method = RequestMethod.POST)
    public String postCommand(Model model, @ModelAttribute AdressDto dto) {
        model.addAttribute("dto", dto);

        return "postcommand";
    }


}
