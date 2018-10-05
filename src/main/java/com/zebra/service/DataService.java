/**
 * 
 */
package com.zebra.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zebra.dao.HurricaneStatisticsRepository;
import com.zebra.dao.MustardStatisticsRepository;
import com.zebra.entity.HurricaneStatistics;
import com.zebra.entity.MustardStatistics;
import com.zebra.model.MustardProduction;
import com.zebra.model.MustardStatResponse;

/**
 * This is a service class for data service , like import and fetch mustard statistics 
 * @author agl
 *
 */
@Service
public class DataService {
	
	@Autowired
	MustardStatisticsRepository mMustardStatisticsRepository;
	
	@Autowired
	HurricaneStatisticsRepository sHurricaneStatisticsRepository;
	Logger logger=LoggerFactory.getLogger(DataService.class);
	
	String[] strMusturdCsvHeader= {"Program","Year","Period","Week Ending","Geo Level","State","State ANSI","Ag District","Ag District Code","County","County ANSI","Zip Code","Region","watershed_code","Watershed","Commodity","Domain","Domain Category","MUSTARD - PRODUCTION, MEASURED IN $  -  <b>VALUE</b>","MUSTARD - PRODUCTION, MEASURED IN $  -  <b>CV (%)</b>"};

	/**
	 * To persist data into h2 in-memory db
	 * @author anand
	 * @param multiPartFile 
	 * @return
	 * @throws Exception
	 */
	public void importData(MultipartFile multiPartFile) throws Exception {
		try {
			File file=convertMultiPartToFile(multiPartFile);
			int yearIndex=0;
			int dollorIndex=0;
			if(strMusturdCsvHeader!=null && strMusturdCsvHeader.length>0) {
				for(int i=0;i<strMusturdCsvHeader.length;i++) {
					if("Year".equalsIgnoreCase(strMusturdCsvHeader[i])) {
						yearIndex=i;
					}
					else if("MUSTARD - PRODUCTION, MEASURED IN $  -  <b>VALUE</b>".equalsIgnoreCase(strMusturdCsvHeader[i])) {
						dollorIndex=i;
					}
				}
			}
			try (Reader reader = new FileReader(file);) {
				Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(reader);
				int count=0;
				for (CSVRecord record : records) {
					if(count>0) {
					    String year = record.get(yearIndex);
					    String dollor = record.get(dollorIndex);
						MustardStatistics objMustardStatistics=new MustardStatistics();
						objMustardStatistics.setYear(year);
						objMustardStatistics.setDollar(new BigInteger(dollor.replaceAll(",", "")));
						mMustardStatisticsRepository.save(objMustardStatistics);
					}
					count++;
				
				}

			}
		}
		catch(Exception exception) {
			logger.error("Something went wrong while persisting data",exception);
			throw exception;
		}
	}
	/**
	 * To get all mustard statistics
	 * @return List<MustardStatistics>
	 */
	public List<MustardStatistics> getMustardStatistics() {
		List<MustardStatistics> result=null;
		try {
			
			 result=mMustardStatisticsRepository.findAll();
		}
		catch(Exception exception) {
			logger.error("Something went wrong while fetching data",exception);
			throw exception;

		}
		return result;
	}
	
	/**
	 * Transalte entity data to response data
	 * @param list
	 * @return
	 */
	public MustardStatResponse translateToResponse(List<MustardStatistics> list) {
		MustardStatResponse objMustardStatResponse=new MustardStatResponse();
		List<MustardProduction> mustard_production=new ArrayList<MustardProduction>();
		
		objMustardStatResponse.setMustard_production(mustard_production);
		if(list!=null) {
			for(MustardStatistics must:list) {
				if(must!=null) {
					MustardProduction sMustardProduction=new MustardProduction();
					sMustardProduction.setYear(must.getYear().toString());
					sMustardProduction.setDollars(must.getDollar().toString());
					mustard_production.add(sMustardProduction);
				}
			}
			objMustardStatResponse.setMustard_production(mustard_production);
			objMustardStatResponse.setRetrivel_time(new Date());
		}
		return objMustardStatResponse;
		
	}
	/**
	 * To convert multi part to file
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
	public List<HurricaneStatistics> getHurricaneStatistics() {
			List<HurricaneStatistics> result=null;
			try {
				
				 result=sHurricaneStatisticsRepository.findAll();
			}
			catch(Exception exception) {
				logger.error("Something went wrong while fetching data",exception);
				throw exception;

			}
			return result;
	}
		

	

}
