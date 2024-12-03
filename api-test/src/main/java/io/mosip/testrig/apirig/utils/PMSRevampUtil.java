package io.mosip.testrig.apirig.utils;
import org.apache.log4j.Logger;
import org.testng.SkipException;

import io.mosip.testrig.apirig.dbaccess.DBManager;
import io.mosip.testrig.apirig.dto.TestCaseDTO;
import io.mosip.testrig.apirig.testrunner.BaseTestCase;

public class PMSRevampUtil extends AdminTestUtil {

	private static final Logger logger = Logger.getLogger(PMSRevampUtil.class);
	
	public static String isTestCaseValidForExecution(TestCaseDTO testCaseDTO) {
		String testCaseName = testCaseDTO.getTestCaseName();
		
		if (SkipTestCaseHandler.isTestCaseInSkippedList(testCaseName)) {
			throw new SkipException(GlobalConstants.KNOWN_ISSUES);
		}
		return testCaseName;
}
	
	public static void DbCleanRevamp() {
		BaseTestCase.currentModule = GlobalConstants.PARTNERNEW;
		DBManager.executeDBQueries(PMSRevampConfigManger.getPMSDbUrl(), PMSRevampConfigManger.getPMSDbUser(),
				PMSRevampConfigManger.getPMSDbPass(), PMSRevampConfigManger.getPMSDbSchema(),
				getGlobalResourcePath() + "/" + "config/partnerRevampDataDeleteQueries.txt");

		DBManager.executeDBQueries(PMSRevampConfigManger.getKMDbUrl(), PMSRevampConfigManger.getKMDbUser(),
				PMSRevampConfigManger.getKMDbPass(), PMSRevampConfigManger.getKMDbSchema(),
				getGlobalResourcePath() + "/" + "config/partnerRevampDataDeleteQueriesForKeyMgr.txt");

		DBManager.executeDBQueries(PMSRevampConfigManger.getIdaDbUrl(), PMSRevampConfigManger.getIdaDbUser(),
				PMSRevampConfigManger.getPMSDbPass(), PMSRevampConfigManger.getIdaDbSchema(),
				getGlobalResourcePath() + "/" + "config/partnerRevampDataDeleteQueriesForIDA.txt");
	}
}
