/**
 * 
 */
package com.zebra.service;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author agl
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestImportDataService {
	
	@Mock
	DataService mDataService;

	@Test
	public void testImportData() throws Exception {
		mDataService.importData(null);
		mDataService.getMustardStatistics();
	}
	

}
