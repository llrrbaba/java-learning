package cn.rocker;

import org.apache.poi.hssf.usermodel.*;
import org.junit.Test;

/**
 * @author: rocker
 * @create: 2019-12-30 20:22
 * @since:
 **/
public class POIDemo {

    @Test
    public void test() {
        // 创建workBook
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();

        // 创建sheet页
        HSSFSheet hssfSheet = hssfWorkbook.createSheet("推荐数据分析");

        // 创建表头
        createTitle(hssfSheet);

        // 设置日期格式
        HSSFCellStyle dateStyle = hssfWorkbook.createCellStyle();
        dateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("mm/dd/yyyyy hh:mm"));

    }

    /**
     * 创建表头
     *
     * @param sheet
     */
    private void createTitle(HSSFSheet sheet) {
        String[] headers = {"订单号", "评测类型", "评测人名称", "支付流水", "支付截图"};
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
    }

}
