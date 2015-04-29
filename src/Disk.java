/** Xing Chen G00577180
	CS 310 Disk 
	Date: 4/14/15
*/
public class Disk
{
   private int sectorCount;   // sectors on the disk
   private int sectorSize;    // characters in a sector
   private char[][] store;    // all disk data is stored here
   
   public Disk()    // for default sectorCount and sectorSize
   {
	   sectorCount = 10000;
	   sectorSize = 512;
	   store = new char [sectorCount][sectorSize]; 	   
   }
   
   public Disk(int sectorCount, int sectorSize)
   {
	   this.sectorCount = sectorCount;
	   this.sectorSize = sectorSize;
	   store = new char [sectorCount][sectorSize];
	   
   }
   
   public void readSector(int sectorNumber, char[] buffer)   // sector to buffer 
   {
	   for(int i = 0; i < sectorSize; i++) //loop through entire row and copy to buffer array
	   {
		   buffer[i] = store[sectorNumber][i];
		  
	   }
   }                                                        
   public void writeSector(int sectorNumber, char[] buffer)  // buffer to sector
   {
	   for(int i = 0; i < buffer.length; i++)  //loop through buffer array and write to sector
	   {
		    store[sectorNumber][i] = buffer[i];
	   }
   }                                                        
   public int getSectorCount()
   {
      return sectorCount;
   }
   public int getSectorSize()
   {
      return sectorSize;
   }
}