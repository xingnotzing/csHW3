import java.io.*;
import java.util.Scanner;

/** Xing Chen G00577180
	CS 310 Disk 
	Date: 4/14/15
*/
public class DiskDriver {
	
	public static void main(String[] args) throws IOException {
		
		Disk disk = new Disk();
		int sectorCount = 0; //counting number of sectors
	
	try {
		FileReader file = new FileReader("mountain.txt");  //input file
		BufferedReader br = new BufferedReader(file);  
		String s;	
		String rec [] = new String [3]; //array to split each record into 3 fields
		char [] record = new char[60]; // array to hold one record
		char bufferSector[] = new char[512]; //array to hold 5 records
		int sectorNum = 1000; // initial sector to insert add
		int k = 0;   //counter for 5 records
		
		
		try {
			while((s = br.readLine()) != null ) { 
				
				rec = s.split("#");  //split input into 3 fields
				
				for(int i = 0; i<rec[0].length() && i <= 27; i++) //name
				{
					record[i] = rec[0].charAt(i);
			
				}
				
				for(int i = 0; i < rec[1].length() && i <= 27; i++) //country
				{
	
					record[i+27] = rec[1].charAt(i);		//starting after name, record[i] = country name
				}
				
				for(int i = 0; i < rec [2].length() && i <= 6; i++)//altitude 
				{
					record[i+54] = rec[2].charAt(i);
				}
				
				
				for(int j = 0; j < record.length; j++)  //loop through buffer array and write to sector
				{			
					bufferSector[k] = record[j];
					if(k == 299)  //once 5 records, write to disk
					{
						disk.writeSector(sectorNum, bufferSector); //write to disk 
						k = 0; //reset to 0 for sector
						sectorNum++; //increment to next sector
						sectorCount++;
					}
					else
					{
						k++;
					}
						
				}
			
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
			//System.out.print(sectorCount);
			int indexSectorStart = 1588;   //firstAllocted + number of sectors filled(587);
			int sectorNum = 1000;
			for(int i = 0; i < 15; i++)
			{
				makeIndexRecord(sectorNum + i, disk);
				
			}
	
	}
	
	public static char [] makeIndexRecord(int sectorNum, Disk disk)
	{
		
		char [] indexRecord = new char [512]; //char Array to index Record 27 key field + 7 sectorNum
		disk.readSector(sectorNum, indexRecord);
		char [] iRecord = new char [34];   //return char of index record
		
		String s = String.valueOf(sectorNum); //convert input to string
		
		//read 27th key to char array
		for(int i = 0; i < 27; i++)
		{
			iRecord[i] = indexRecord[i];
		}
		
		int j = 0;
		for(int i = 27; i < 34; i++)
		{
			iRecord[i] = s.charAt(j);
			j++;		
		}
		
		return iRecord;
	}

}
