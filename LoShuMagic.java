
public class LoShuMagic 
{
		//check if the numbers 1-9 are used only once
	private boolean test1(int array[][])
	{
		boolean numbersUsed[] = new boolean[10];
		
		//preset the numbers used to false except cell 0
		for(int i = 0; i<numbersUsed.length; i++)
			numbersUsed[i] = false;
		
		numbersUsed[0] = true;
		
		//check ONLY the numbers 1-9 are used
		for(int i=0; i< array.length; i++)
		{
			for(int j=0; j < array[i].length; j++)
			{
				if(array[i][j]<1 || array[i][j]>9)
					return(false);
			}
		}
		
		//check if all the numbers are used once
		for(int i=0; i< array.length; i++)
		{
			for(int j=0; j < array[i].length; j++)
			{
				if(numbersUsed[ array[i][j] ] == true)
				{
					return(false);
				}
				else
					numbersUsed[ array[i][j] ] = true;
			}
		}
		
		return(true);
	}	
		//check if the rows columns and diagonals add up to the same number
	private boolean test2(int array[][])
	{
		int sum = array[0][0] + array[0][1] + array[0][2];
		
		//rows
		for(int i=0; i< array.length; i++)
		{
			if(sum != array[i][0] + array[i][1] + array[i][2])
				return(false);
		}
		//System.out.println("end of rows");
		
		//columns
		for(int i=0; i< array.length; i++)
		{
			if(sum != array[0][i] + array[1][i] + array[2][i])
				return(false);
		}
		//System.out.println("end of columns");
		
		//diagonals
		if(sum != array[0][0] + array[1][1] + array[2][2])
			return(false);
		
		//System.out.println(array[0][2] +"+"+ array[1][1] +"+"+ array[2][0] + "=" + (array[0][2] + array[1][1] + array[0][2]) );
		
		if(sum != array[0][2] + array[1][1] + array[2][0])
			return(false);
		//System.out.println("end of diagonals");
		
		return(true);
	}
		
		//check if the 2d array is a LoShu square
	public boolean test(int array[][])
	{		
		//System.out.println("\n" + test1(array) + " " + test2(array) );
		
		if(test1(array)==true && test2(array)==true)
			return(true);
	
		return(false);
	}
}
