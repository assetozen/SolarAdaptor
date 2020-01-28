package uc.exp.bremen.solaradaptor.controller;

import org.junit.jupiter.api.BeforeAll;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.runners.MockitoJUnitRunner;
import uc.exp.bremen.solaradaptor.service.InitSolarService;
import uc.exp.bremen.solaradaptor.service.SetUpConWithSolarAndReadContentService;

import java.io.BufferedReader;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class JobsControllerTest {
    @Mock
    private InitSolarService initSolarService;

    @Mock
    private SetUpConWithSolarAndReadContentService setUpConWithSolarAndReadContentService;

    @InjectMocks
    private JobsController jobsController;

    @BeforeAll
    public void initializeMockito(){
        MockitoAnnotations.initMocks(this);
    }

    public void getJobsFromSolarTest(){
        String sSearch = "java";
        String sSort = "1";
        String sFilter = "1";

        URL url = initSolarService.initSolarUrl(sSearch,sSort,sFilter);
        BufferedReader br = setUpConWithSolarAndReadContentService.doSetUpConnectionWithSolarAndReadData(url);



    }



}