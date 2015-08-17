package com.ayovel.nian.utils.createdb;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fs on 2014/11/28.
 */
public class OrcConvert {

    public static String tlogPath="resource/tlog.xml";
    public static String distPath="dist/sqlscripte/";
    public static String createRedshiftShellPath =distPath+"createTable.sql";
    
    public static void main (String[] args) throws Exception {
    	File distPaht = new File(distPath);
    	if(distPaht.exists()){
    		distPaht.deleteOnExit();
    	}
    	System.out.println(distPaht.getAbsolutePath());
    	distPaht.mkdir();
    	
        CreateRedshiftTable(XMLprase(tlogPath));
    }


    private static void CreateRedshiftTable(List<Form> forms) throws IOException{


        File createTableFile = new File(createRedshiftShellPath);
        if(createTableFile.exists())createTableFile.delete();
        System.out.println(createTableFile.getAbsolutePath());
        createTableFile.createNewFile();
        FileOutputStream out = new FileOutputStream(createTableFile,false);
        StringBuffer sb = new StringBuffer();
      
        for (Form form : forms) {
            //创建一般表
            sb.append("CREATE TABLE IF NOT EXISTS " + form.getName().toLowerCase() + "(\n");
//            sb.append("iplatname string COMMENT 'null',\n");
            for (int i = 0; i < form.getFactors().size(); i++) {
                Factor factor = form.getFactors().get(i);
                sb.append("" + factor.getName() + " ");
                if (factor.getType().contains("big"))
                    sb.append(" varchar(size) NULL ");
                else if (factor.getType().contains("uint") || factor.getType().contains("utinyint"))
                    sb.append(" BIGINT NULL ");
                else if (factor.getType().contains("datetime") )
                    sb.append(" VARCHAR("+factor.getSize()+") NULL ");
                else if (factor.getType().contains("string") || factor.getType().contains("")){
                	if(factor.getName().equals("id")){
                		 sb.append(" VARCHAR("+factor.getSize()+") NOT NULL ");
                	}else{
                		sb.append(" VARCHAR("+factor.getSize()+")  NULL ");
                	}
                	 
                }
                  

                if (i < form.getFactors().size() - 1) sb.append(",\n");

            }
            sb.append(")\n");
            sb.append(";\n");
            sb.append("\n");

        }
        out.write(sb.toString().getBytes("utf-8"));
        out.close();
    
	}


	public static String attributetext(Element element, String text) {
        if (element.attribute(text) != null)
            return element.attribute(text).getText();
        else return "";
    }

    public static List<Form> XMLprase(String path) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File(path));
        Element rootElement = document.getRootElement();
        List rootnodeList = rootElement.elements("struct");
        List<Form> forms = new ArrayList<Form>();
        for (int i = 0; i < rootnodeList.size(); i++) {
            Element element = (Element) rootnodeList.get(i);
            Form form = new Form();
            form.setDesc(element.attribute("desc").getText());
            form.setId(element.attribute("id").getText());
            form.setName(element.attribute("name").getText());
            List<Factor> factors = new ArrayList<Factor>();
            List factornodelist = element.elements("entry");
            for (int j = 0; j < factornodelist.size(); j++) {
                Element tinielement = (Element) factornodelist.get(j);
                Factor factor = new Factor();
                factor.setDesc(attributetext(tinielement, "desc"));
                factor.setIndex(attributetext(tinielement, "index"));
                factor.setName(attributetext(tinielement, "name"));
                factor.setSize(attributetext(tinielement, "size"));
                factor.setType(attributetext(tinielement, "type"));
                factor.setTargetname(attributetext(tinielement, "name"));
                factors.add(factor);
            }
            form.setFactors(factors);
            forms.add(form);
        }
        return forms;
    }

}
