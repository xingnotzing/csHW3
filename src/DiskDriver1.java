import java.util.Scanner;

/** Xing Chen G00577180
	CS 310 Disk 
	Date: 4/14/15
*/
public class DiskDriver {

	public static void main(String[] args) {

		Disk disk = new Disk(10000,60);
//		IndexedFile recordFile = new IndexedFile(disk,60,27,1000);
		IndexedFile indexFile;
		IndexedFile overFlowFile;
		
		int answer = 1;			//use while loop to keep printing menu
		while(answer != 3){
			System.out.println("1. Insert new record");
			System.out.println("2. Find record");
			System.out.println("3. Quit");
			
			Scanner in = new Scanner (System.in);
			System.out.println("choose operations");
			answer = in.nextInt();
			switch(answer){   //switch statement to choose right function call
			case 1:
//				recordFile.insertRecord(null);		
				break;
			case 2:
				System.out.println("Enter the key");
				String key = in.nextLine();
				char [] record = new char [27];
//				recordFile.findRecord(record);
				break;
			case 3: 
				System.exit(0);
				break;
			}
		}
	}
}