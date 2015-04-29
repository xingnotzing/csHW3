public class IndexedFile
{
   private Disk disk;             // disk on which the file will be written
   private char[] buffer;         // disk buffer
   private int recordSize;        // in characters //60
   private int keySize;           // in characters
   // fields describing data portion of file
   private int recordsPerSector;  // sectorSize/recordSize //5
   private int firstAllocated;    // sector number where data begins
   private int sectorsAllocated;  // sectors originally allocated for data
   private int overflowStart;     // sector number where overflow begins
   private int overflowSectors;   // count of overflow sectors in use
   // fields describing index portion of file
   private int indexStart;        // sector number where index begins
   private int indexSectors;      // number of sectors allocated for index
   private int indexRoot;         // sector number of root of index
   private int indexLevels;       // number of levels of index
   
   public IndexedFile(Disk disk, int recordSize, int keySize,
                      int firstAllocated, int indexStart,
                      int indexSectors, int indexRoot, int indexLevels)
   {
	   this.disk = disk;
	   this.recordSize = recordSize;
	   this.keySize = keySize;
	   this.firstAllocated = firstAllocated;
	   this.indexStart = indexStart;
	   this.indexSectors = indexSectors;
	   this.indexRoot = indexRoot;
	   this.indexLevels = indexLevels;
   }
   public boolean insertRecord(char[] record)
   {
	   String key = String.valueOf(record); //convert char array to string
	   key = key.substring(0, keySize);  //retrieve a substring of keySize
	   int k = Integer.parseInt(key);
	  
   
   }   
   public boolean findRecord(char[] record)
   {
	   String key = String.valueOf(record); //convert char array to string
	   key = key.substring(0, keySize);  //retrieve a substring of keySize
	   int k = Integer.parseInt(key);
	   
   }   
   // there is no delete operation
   private int getSector(char[] key)   // returns sector number indicated by key
   {
	   String key1 = String.valueOf(key); //convert char array to string
	   key1 = key1.substring(0, keySize);  //retrieve a substring of keySize
	   int k = Integer.parseInt(key1);
	   //can call disk.readsector method
	   
	   
	   for(int i = 0; i < disk[k][i].length; i++)
	   {
		   if(k == k )
			   return 
	   }
	   
	   
   }  
   
}