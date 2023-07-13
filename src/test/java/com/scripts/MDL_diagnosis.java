package com.scripts;
import com.frame.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Common;

public class MDL_diagnosis extends DriverFactory {
    login login;
    GetDriver link;
    create_new_case_intake new_case_intake;
    new_to_assign to_assign;
    assign_to_approved to_approved;
    approved_to_complete to_complete;
    search_case search;
    log_out logout;
    assign_provider ass;
    ExcelHelpers excel;
    getInfo getinfo;
    approve_to_assign_follow_up to_AFU;
    billing billing;
    FPC_Approved fpc;

    @Override
    public void setUpforTest() {
        link = new GetDriver(driver);
        login = PageFactory.initElements(driver, login.class);
        new_case_intake = PageFactory.initElements(driver, create_new_case_intake.class);
        to_assign = PageFactory.initElements(driver, new_to_assign.class);
        to_approved = PageFactory.initElements(driver, assign_to_approved.class);
        to_complete = PageFactory.initElements(driver, approved_to_complete.class);
        search = PageFactory.initElements(driver, search_case.class);
        ass = PageFactory.initElements(driver, assign_provider.class);
        logout = PageFactory.initElements(driver, log_out.class);
        excel = new ExcelHelpers();
        getinfo = PageFactory.initElements(driver, getInfo.class);
        to_AFU = PageFactory.initElements(driver, approve_to_assign_follow_up.class);
        billing = PageFactory.initElements(driver, billing.class);
        fpc = PageFactory.initElements(driver, FPC_Approved.class);
    }

    @Test
    public void MDL_diagnosis_create_case() throws Exception {
        Actions action = new Actions(driver);
        excel.setExcelFile("src/test/resources/MDL_diagnosis.xlsx", "Sheet1");
        String business = excel.getCellData("business", 1);
        String vertical = excel.getCellData("vertical", 1);
        String MG = excel.getCellData("MG", 1);
        String lab = excel.getCellData("lab", 1);
        String type = excel.getCellData("type", 1);
        String first_name = excel.getCellData("first_name", 1);
        String last_name = excel.getCellData("last_name", 1);
        String DOB = excel.getCellData("DOB", 1);
        String medicare_ID = excel.getCellData("medicare_ID", 1);
        String zipcode = excel.getCellData("zipcode", 1);
        login.URL_intake();

        login.intake("123456");
        Common.waitSec(6);
        new_case_intake.MDL_diagnosis_create_new_case(business, vertical, MG, lab, type, first_name, last_name, DOB, medicare_ID, zipcode);
        Common.waitSec(3);

        String id = to_assign.find_id();
        excel.setCellData(id, 1, 0);
        System.out.println("Case-ID: " + id);
    }

    @Test
    public void MDL_diagnosis_new_to_assign() throws Exception {
        excel.setExcelFile("src/test/resources/MDL_diagnosis.xlsx", "Sheet1");
        login.URL_intake();
        login.pss("111111");
        Common.waitSec(5);

        String id = excel.getCellData("id", 1);
        search.search_from_intake(id);
        Common.waitSec(5);

        to_assign.MDL_diagnosis_to_assign();
        Common.waitSec(5);
    }

    @Test
    public void MDL_diagnosis_assign_to_approve() throws Exception {

        excel.setExcelFile("src/test/resources/MDL_diagnosis.xlsx", "Sheet1");
        login.URL_intake();
        login.provider("123456");
        Common.waitSec(5);

        String id = excel.getCellData("id", 1);
        search.search_from_intake(id);
        Common.waitSec(5);

        billing.billing();
        Common.waitSec(3);

        to_approved.MDL_diagnosis_to_approve1();
        Common.waitSec(3);

    }

    @Test
    public void MDL_diagnosis_to_complete() throws Exception {
        excel.setExcelFile("src/test/resources/MDL_diagnosis.xlsx", "Sheet1");
        login.URL_intake();
        login.pss("111111");
        Common.waitSec(5);

        String id = excel.getCellData("id", 1);
        search.search_from_intake(id);
        Common.waitSec(5);

        to_complete.Covid_complete();
        Common.waitSec(5);
    }

    @Test
    public void MDL_diagnosis() throws Exception {
        //create new case
        Actions action = new Actions(driver);
        excel.setExcelFile("src/test/resources/MDL_diagnosis.xlsx", "Sheet1");
        String business = excel.getCellData("business", 1);
        String vertical = excel.getCellData("vertical", 1);
        String MG = excel.getCellData("MG", 1);
        String lab = excel.getCellData("lab", 1);
        String type = excel.getCellData("type", 1);
        String first_name = excel.getCellData("first_name", 1);
        String last_name = excel.getCellData("last_name", 1);
        String DOB = excel.getCellData("DOB", 1);
        String medicare_ID = excel.getCellData("medicare_ID", 1);
        String zipcode = excel.getCellData("zipcode", 1);
        login.URL_intake();

        login.intake("123456");
        Common.waitSec(6);
        new_case_intake.MDL_diagnosis_create_new_case(business, vertical, MG, lab, type, first_name, last_name, DOB, medicare_ID, zipcode);
        Common.waitSec(3);

        String id = to_assign.find_id();

        excel.setCellData(id, 1, 0);
        System.out.println("Case-ID: " + id);

        //new to assign

        logout.logout();
        Common.waitSec(5);
        login.pss("111111");
        Common.waitSec(5);

        search.search_from_intake(id);
        Common.waitSec(5);

        to_assign.MDL_diagnosis_to_assign();
        Common.waitSec(5);

        //assign to approve
        logout.logout();
        Common.waitSec(5);
        login.provider("123456");
        Common.waitSec(5);

        search.search_from_intake(id);
        Common.waitSec(5);

//        billing.billing();
        Common.waitSec(3);

        to_approved.MDL_diagnosis_to_approve1();
        Common.waitSec(3);

        //to complete
        logout.logout();
        Common.waitSec(5);
        login.pss("111111");
        Common.waitSec(5);

        search.search_from_intake(id);
        Common.waitSec(5);

        to_complete.Covid_complete();
        Common.waitSec(5);
    }
}

