package util;

import bean.teacherBean;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class uploadExcel {
    public List<teacherBean> readXls(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        teacherBean user = null;
        List<teacherBean> list = new ArrayList<>();
        // ѭ��������Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // ѭ����Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    user = new teacherBean();
                    HSSFCell username = hssfRow.getCell(0);
                    HSSFCell realname = hssfRow.getCell(1);
                    user.setTeacherId(getValue(username));
                    user.setTeacherName(getValue(realname));
                    list.add(user);
                }
            }
        }
        return list;
    }

    @SuppressWarnings("static-access")
    private String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            // ���ز������͵�ֵ
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            // ������ֵ���͵�ֵ
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            // �����ַ������͵�ֵ
            return String.valueOf(hssfCell.getStringCellValue());
        }

    }
}
