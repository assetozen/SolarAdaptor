package uc.exp.bremen.solaradaptor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import uc.exp.bremen.solaradaptor.service.InitSolarService;
import uc.exp.bremen.solaradaptor.service.SetUpConWithSolarAndReadContentService;
import uc.exp.bremen.solaradaptor.utility.Constants;
import uc.exp.bremen.solaradaptor.utility.SortAndFilterJobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Controller
public class JobsController extends BaseController {

    @Autowired
    InitSolarService initSolarService;

    @Autowired
    SetUpConWithSolarAndReadContentService setUpConWithSolarAndReadContentService;


    @GetMapping(value = "/jobs", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getJobsFromSolar(@RequestParam("sSearch") String sSearch,
                                   @RequestParam("sSort") String sSort,
                                   @RequestParam("sFilter") String sFilter) {
        String output = "";
        String readLine;
        try {
            URL solarUrl = initSolarService.initSolarUrl(sSearch, sSort, sFilter);
            BufferedReader bufferedReader = setUpConWithSolarAndReadContentService.doSetUpConnectionWithSolarAndReadData(solarUrl);
            while ((readLine = bufferedReader.readLine()) != null) {
                output = output.concat(readLine);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }


}
