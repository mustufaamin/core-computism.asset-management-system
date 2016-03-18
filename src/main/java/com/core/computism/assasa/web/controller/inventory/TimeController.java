package com.core.computism.assasa.web.controller.inventory;

import com.core.computism.assasa.ar.Response;
import com.core.computism.assasa.web.controller.BaseController;
import org.joda.time.DateTimeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by VD on 02/20/2016.
 */
@Controller
@RequestMapping({"api/", "system/"})
public class TimeController extends BaseController {

    @RequestMapping(value = "time", method = {RequestMethod.GET})
    public
    @ResponseBody
    Map<String, Object> getHeatMap() {

        return createTimeModelMap(DateTimeUtils.currentTimeMillis());
    }

    @RequestMapping(value = "heartbeat", method = {RequestMethod.GET})
    public
    @ResponseBody
    Response<String> getHeartBeat() {
        return new Response<String>("Joey: How you doin! <br/> System: Get lost!");
    }
}
