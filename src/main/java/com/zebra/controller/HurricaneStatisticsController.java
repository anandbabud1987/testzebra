package com.zebra.controller;

import java.io.InputStream;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zebra.component.UtilityComponent;
import com.zebra.controller.constant.ImportDataConstants;
import com.zebra.model.MustardStatResponse;
import com.zebra.service.DataService;

/**
 * This is a Rest Controller to import csv data of mustard production
 * @author anand
 *
 */
@RestController
public class HurricaneStatisticsController implements ImportDataConstants {
	Logger logger=LoggerFactory.getLogger(HurricaneStatisticsController.class);

	@Autowired
	DataService dataService;
	/**
	 * To import mustard statistics csv
	 * @return
	 */
	@RequestMapping(value = "/hurricanestatistics", method = RequestMethod.POST,produces="application/json")
	public ResponseEntity<Object> importData(@RequestPart(value = "file") MultipartFile multiPartFile) {
		try {
			dataService.importData(multiPartFile);
			return UtilityComponent.buildResponse(new MustardStatResponse(SUCCESS,new Date(),null));
		} catch (Exception e) {
			logger.error("Something went wrong in importData:",e);
			return UtilityComponent.buildErrorResponse(new MustardStatResponse(FAILED,new Date(),null));
		}
		
		
	}
	
	/**
	 * To fetch current mustard production statistics
	 * @return
	 */
	@RequestMapping(value = "/hurricanestatistics", method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Object> fetchLatestHurricaneData() {
		logger.info("Started fetchLatestHurricaneData");
		try {
			dataService.getHurricaneStatistics();
			logger.info("completed fetchLatestHurricaneData");
			return UtilityComponent.buildResponse(dataService.translateToResponse(dataService.getMustardStatistics()));
		} catch (Exception e) {
			logger.error("Something went wrong in fetchLatestHurricaneData:",e);
			return UtilityComponent.buildErrorResponse(new MustardStatResponse(FAILED,new Date(),null));

		}

	}


}
