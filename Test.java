import java.io.*;



public class Test {
	
	public static void main(String[] args) 
    {	
		TIntegrator Integrator = new TDormandPrinceIntegrator();
		Integrator.setPrecision(1e-16);
		TModel Model1 = new TArenstorfModel1(0, 85.4, 0.1); //85.4
		TModel Model2 = new TArenstorfModel2(0, 55.6, 0.1);
		Integrator.Run( Model1 );
		IMatrix Result = Model1.getResults();
		
		
		try(FileWriter writer=new FileWriter("notes3.txt",false))
		{
	    String lineSeparator=System.getProperty("line.separator");
			for (int i=0;i<Result.GetRowCount()-1;i++)
			{
				
					writer.write( Double.toString(Result.GetItem(i, 0)));
					writer.write(" ");
					writer.write( Double.toString(Result.GetItem(i, 1)));
					writer.write(" ");
					writer.write( Double.toString(Result.GetItem(i, 2)));
					writer.write(" ");
					writer.write( Double.toString(Result.GetItem(i, 3)));
					writer.write(" ");
					writer.write( Double.toString(Result.GetItem(i, 4)));
					writer.write(" ");
					writer.write(lineSeparator);

			}
			writer.close();
		}
		catch(IOException ex)
		{
		  System.out.println(ex.getMessage());
		}
		
		Integrator.Run( Model2 );
		Result = Model2.getResults();
		try(FileWriter writer=new FileWriter("notes4.txt",false))
		{
	    String lineSeparator=System.getProperty("line.separator");
			for (int i=0;i<Result.GetRowCount()-1;i++)
			{
				
					writer.write( Double.toString(Result.GetItem(i, 0)));
					writer.write(" ");
					writer.write( Double.toString(Result.GetItem(i, 1)));
					writer.write(" ");
					writer.write( Double.toString(Result.GetItem(i, 2)));
					writer.write(" ");
					writer.write( Double.toString(Result.GetItem(i, 3)));
					writer.write(" ");
					writer.write( Double.toString(Result.GetItem(i, 4)));
					writer.write(" ");
					writer.write(lineSeparator);
					//writer.flush();
			}
			writer.close();
		}
		catch(IOException ex)
		{
		  System.out.println(ex.getMessage());
		}
		
    }
}
