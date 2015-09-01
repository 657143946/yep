package me.chrislee.yep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by chrislee on 15-5-24 17:40:30.
 * 模板Controller
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    /**
     * 返回页面的模板controller
     *
     * @param value
     * @return
     */
    @RequestMapping("demo.page")
    public ModelAndView page(
            @RequestParam(defaultValue = "null") String value
    ) {
        ModelAndView mv = new ModelAndView("demo.html");
        mv.addObject("value", value);
        return mv;
    }

    /**
     * 返回json的模板controller
     *
     * @param value
     * @return
     */
    @RequestMapping("demo.json")
    @ResponseBody
    public ControllerModel json(
            @RequestParam(defaultValue = "null") String value
    ) {
        ControllerModel model = new ControllerModel();
        model.put("value", value);
        return model;
    }

    /**
     * 页面报错接口
     *
     * @return
     */
    @RequestMapping("error.page")
    public ModelAndView errorPage() {
        throw new RuntimeException();
    }

    /**
     * json报错接口
     *
     * @return
     */
    @RequestMapping("error.json")
    @ResponseBody
    public ModelAndView errorJson() {
        throw new RuntimeException();
    }
}
