package jobs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * The main controller showing the index page
 *
* @author Denis Bell <http://denisdbell.com>
 */

@Controller
public class MainController {

  @RequestMapping("/")
  @ResponseBody
  public String index() {
    return "Proudly handcrafted by " + "<a href='http://denisdbell.com'>Denis Bell</a> :)";
  }

}
