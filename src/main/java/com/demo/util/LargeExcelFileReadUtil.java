package com.demo.util;

import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.demo.upload.SheetHandler;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * @author： wangxs
 * @date：Create by 2018/8/6 9:36
 */
public class LargeExcelFileReadUtil {
    private  LinkedHashMap<String, String>rowContents=new LinkedHashMap<String, String>();
    private SheetHandler sheetHandler;

    public LinkedHashMap<String, String> getRowContents() {
        return rowContents;
    }
    public void setRowContents(LinkedHashMap<String, String> rowContents) {
        this.rowContents = rowContents;
    }

    public SheetHandler getSheetHandler() {
        return sheetHandler;
    }
    public void setSheetHandler(SheetHandler sheetHandler) {
        this.sheetHandler = sheetHandler;
    }
    /**
     * 处理一个sheet
     */
    public void processOneSheet(String filename) throws Exception {
        InputStream sheet2=null;
        OPCPackage pkg =null;
        try {
            pkg = OPCPackage.open(filename);
            XSSFReader r = new XSSFReader(pkg);
            SharedStringsTable sst = r.getSharedStringsTable();
            XMLReader parser = fetchSheetParser(sst);
            sheet2 = r.getSheet("rId1");
            InputSource sheetSource = new InputSource(sheet2);
            parser.parse(sheetSource);
            setRowContents(sheetHandler.getRowContents());
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally{
            if(pkg!=null){
                pkg.close();
            }
            if(sheet2!=null){
                sheet2.close();
            }
        }
    }
    /**
     * 处理多个sheet
     */
    public void processAllSheets(String filename) throws Exception {
        OPCPackage pkg =null;
        InputStream sheet=null;
        try{
            pkg=OPCPackage.open(filename);
            XSSFReader r = new XSSFReader( pkg );
            SharedStringsTable sst = r.getSharedStringsTable();
            XMLReader parser = fetchSheetParser(sst);
            Iterator<InputStream> sheets = r.getSheetsData();
            while(sheets.hasNext()) {
                System.out.println("Processing new sheet:\n");
                sheet = sheets.next();
                InputSource sheetSource = new InputSource(sheet);
                parser.parse(sheetSource);
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally{
            if(pkg!=null){
                pkg.close();
            }
            if(sheet!=null){
                sheet.close();
            }
        }
    }

    public XMLReader fetchSheetParser(SharedStringsTable sst) throws SAXException {
        XMLReader parser =
                XMLReaderFactory.createXMLReader(
                        "com.sun.org.apache.xerces.internal.parsers.SAXParser"
                );
        setSheetHandler(new SheetHandler(sst));
        ContentHandler handler =  sheetHandler;
        parser.setContentHandler(handler);
        return parser;
    }

    /**
     * 测试
     * @throws Exception
     */
    public static void main (String[] args)throws Exception {
        Long time=System.currentTimeMillis();
        LargeExcelFileReadUtil example = new LargeExcelFileReadUtil();

        example.processOneSheet("F:/download/CallTemp (1).xlsx");
        Long endTime=System.currentTimeMillis();
        LinkedHashMap<String, String> map=example.getRowContents();
        Iterator<Entry<String, String>> it= map.entrySet().iterator();
        int count=0;
        String prePos="";
        while (it.hasNext()){
            Map.Entry<String, String> entry = it.next();
            String pos=entry.getKey();
            if(!pos.substring(1).equals(prePos)){
                prePos=pos.substring(1);
                count++;
            }
            System.out.println(pos+";"+entry.getValue());
        }
        System.out.println("解析数据"+count+"条;耗时"+(endTime-time)/1000+"秒");
    }

}
