package com.metacube.program;

import org.junit.Test;

public class CouncellingTest {
	@Test
	public void counsellingTest(){
		Counselling process = new Counselling();
		String path = "output.xlsx";
		String studentDetails = "studentDetails.xls";
		String programDetails = "programDetails.xls";
		process.studentCounselling(path, studentDetails, programDetails);
	}

}
