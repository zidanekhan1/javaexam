package com.stqa;

import jxl.*;
import jxl.write.*;
import org.testng.annotations.Test;

import java.io.File;

public class updatestudrecords {

    @Test
    public void updateRecords() throws Exception {

        File inputFile = new File("/home/zizou/IdeaProjects/practical_3/myBook1.xls");

        Workbook workbook = Workbook.getWorkbook(inputFile);
        Sheet sheet = workbook.getSheet(0);

        WritableWorkbook output =
                Workbook.createWorkbook(
                        new File("/home/zizou/IdeaProjects/practical_3/myBook1res.xls"),
                        workbook
                );

        WritableSheet writableSheet = output.getSheet(0);

        // Add Result heading
        writableSheet.addCell(
                new Label(3, 0, "Result")
        );

        // Process student records
        for (int row = 1; row < sheet.getRows(); row++) {

            String marksText = sheet.getCell(2, row).getContents();
            int marks = Integer.parseInt(marksText);

            String result;

            if (marks > 35) {
                result = "pass";
            } else {
                result = "fail";
            }

            writableSheet.addCell(
                    new Label(3, row, result)
            );
        }

        output.write();
        output.close();
        workbook.close();

        System.out.println("Student records updated successfully.");
    }
}
