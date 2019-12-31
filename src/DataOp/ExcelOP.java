package DataOp;

import org.apache.poi.hssf.usermodel.*;

import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ExcelOP {

    private final int SPLIT_COUNT = 50;

    private ArrayList fieldName = null;

    private ArrayList fieldData = null;

    private HSSFWorkbook workBook = null;

    public ExcelOP(ArrayList fieldName,ArrayList fieldData){
        this.fieldName = fieldName;
        this.fieldData = fieldData;
    }

    public HSSFWorkbook createWorkBook(){
        workBook = new HSSFWorkbook();
        int row = fieldData.size();
        int sheetNum = 0;
        if(row % SPLIT_COUNT == 0){
            sheetNum = row / SPLIT_COUNT;
        }else{
            sheetNum = row / SPLIT_COUNT + 1;
        }

        for(int i = 1; i <= sheetNum;i++){
            HSSFSheet sheet = workBook.createSheet("Page" + i);
            HSSFRow headRow = sheet.createRow((short)0);
            for(int j = 0; j < fieldName.size();j++){
                HSSFCell cell = headRow.createCell((short)j);

                sheet.setColumnWidth((short)j,(short)6000);

                HSSFCellStyle cellStyle = workBook.createCellStyle();

                HSSFFont font = workBook.createFont();
                font.setColor(HSSFFont.COLOR_RED);

                cellStyle.setFont(font);

                if(fieldName.get(j) != null){
                    cell.setCellStyle(cellStyle);
                    cell.setCellValue((String) fieldName.get(j));
                }else{
                    cell.setCellStyle(cellStyle);
                    cell.setCellValue("-");
                }
            }

            for(int k = 0; k < (Math.min(row, SPLIT_COUNT)); k++){
                HSSFRow excelRow = sheet.createRow((short)(k + 1));
                ArrayList rowList = getFieldValue(fieldData.get((i - 1) * SPLIT_COUNT + k)); //?
                for(int n = 0; n < rowList.size(); n++){
                    HSSFCell cell = excelRow.createCell((short) n);

                    if(rowList.get(n) != null){
                        cell.setCellValue(rowList.get(n).toString());
                    }else{
                        cell.setCellValue("");
                    }
                }

            }

        }
        return workBook;
    }

    public void exportExcel(OutputStream os){
        try{
            workBook = createWorkBook();
            workBook.write(os);
            os.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private ArrayList<String> getFieldValue(Object obj){
        ArrayList<String> fieldValue = new ArrayList<>();
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(obj);
                fieldValue.add(value.toString());
            }
            return fieldValue;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
}
