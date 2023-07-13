package com.frame;

import java.io.FileOutputStream;

public class CreateExcelfile {
	public void excel() {
		try {
			String filename = "E:\\TrainingTestNG\\src\\test\\resources\\MDL_test.xlsx";
			FileOutputStream fileOut = new FileOutputStream(filename);
			fileOut.close();
			System.out.println("File Excel được tạo thành công.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
