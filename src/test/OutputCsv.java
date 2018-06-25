package test;

import java.io.IOException;
import java.nio.charset.Charset;

import csvreader.CsvReader;
import csvreader.CsvWriter;

public class OutputCsv {

	public  void read(){

        String filePath = "E:\\lian_workspace\\ApiExtractor\\test.csv";

        try {
            // ����CSV������
            CsvReader csvReader = new CsvReader(filePath);

            // ����ͷ
            csvReader.readHeaders();
            while (csvReader.readRecord()){
                // ��һ����
                System.out.println(csvReader.getRawRecord());
                // �����е�ĳһ��
                //System.out.println(csvReader.get("Link"));
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public  void write(){

        String filePath = "E:\\lian_workspace\\ApiExtractor\\test.csv";

        try {
            // ����CSVд����
            CsvWriter csvWriter = new CsvWriter(filePath,',', Charset.forName("GBK"));
            //CsvWriter csvWriter = new CsvWriter(filePath);

            // д��ͷ
            String[] headers = {"���","����","����"};
            String[] content = {"12365","��ɽ","34"};
            csvWriter.writeRecord(headers);
            csvWriter.writeRecord(content);
            csvWriter.close();

        } catch (IOException e) {
        	
            e.printStackTrace();
        }
    }
	
	public static void main(String[] argv)
	{
		new OutputCsv().read();
	}
	
	
}
