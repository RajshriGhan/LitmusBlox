import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvData {

	public static void main(String[] args) throws IOException {
		String fileToParse = "JavaProject (2) (2).csv";	
		try
		{
			String line = "";
			int Actual_hrs_total=0;
			double FixedCost_total=0;

			//Create the file reader
			BufferedReader reader = new BufferedReader(new FileReader(fileToParse));
			//Read the file line by line
			int count=0;
			while ((line = reader.readLine()) != null) 
			{
				String[] array =line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				String Fixed_Cost = array[8].replace("\"","");

				//String[] array =line.split("\"(,\")?");
				//System.out.println(array);

				//Get all tokens available in line

				//result = array[8].replaceAll("[^a-zA-Z0-9]", "");
				count++;
				if(count==1) {
					System.out.println(array[0]+ "\t \t \t" + array[1] + "\t\t\t" + array[2] + "\t\t" + Fixed_Cost +  "\t\t" + array[10] );
					continue;
				}
				System.out.println(array[0]+ "\t\t\t" + array[1] + "\t \t\t" + array[2] + "\t \t\t" + Fixed_Cost + "\t  \t\t"+ array[10] );
				//System.out.println(Fixed_Cost.replace(",", "").substring(1));

				FixedCost_total+= Double.parseDouble(Fixed_Cost.replace(",", "").substring(1));			
				Actual_hrs_total+= Integer.parseInt(array[10]);
			}
			System.out.println("\n\t\t\t\t\t\t\t\t\tFixed Cost Total: $"+FixedCost_total+"\t Total of Actual Hrs: "+Actual_hrs_total);

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}


