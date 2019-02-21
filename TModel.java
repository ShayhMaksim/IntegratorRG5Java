
public  class TModel {
   public IVector X0;
   public IMatrix Result;
   public double T1;
   public double T0;
   public double SamplingIncrement;
   public int N;
   public TModel()
   {
	   Result=new TMatrix();
	   SamplingIncrement = 1e-1 ;
        T0= 0 ;
        T1= 1 ;
		 N= 0 ;
   }
   
   // ������ ����������� (� ���� ������ � ���������� ��������� ������������ ������ � ���� 
	// ������ ��� ������ � ����������� ������� �����������)
   public void addResult(IVector xout, double t)
   {
	// ��������, ������� �� ������� ����� � ������� ����������� �� ������� ��������� ������
		// ���� ��, �� �������� ���������� ����� �� 1
		if (N == Result.GetRowCount())
			Result.Resize(N + 1, getOrder() + 1);
		// �������� ���������� � ��������� ������ ������� Result
		// ������ ������� ���������� � 0-�� �������, ������ ��������� - � ��������� �������
		Result.SetItem(N, 0, t);
		for (int i = xout.GetSize(); i>0; i--)
			Result.SetItem(N, i, xout.GetItem(i-1));       
		// �������� N
		N++;
   }
   // ��������� ��������� �������
   public IVector getInitialConditions()
   {
	return X0; 
   }
   
// ��������� ������� �����������
   public IMatrix getResults()
   {
	   return Result;
   }
   
   // ����������� ������������� ������� ������ ������ �� (X - ������ ���������, t - ����������� ��������)
   public IVector getRight(IVector x,double T)
   {
	   return null;
   }
  
   
// �������� ������ �����������
   public double getSamplingIncrement()
   {
	   return SamplingIncrement;
   }
   
// ���������� ��������� ���������� ��������������
   public double getT0()
   {	return T0; 	}
   public double getT1()
   {   	return T1;  }
   
   // ������� ������� - �� ����������� ������� ��������� �������
   public int getOrder() { return X0.GetSize(); }
   
// ������� ������� ����������� (��� ����� � ������������)
   public void clearResult() 
   { 
   	// ������� ������� ����������� � ������� ������� �����
   	Result.Resize(0, 0); 
   	N = 0;
	
   }
  
// ���������� ������� ����������� ��� ����� ������������ ��������� ������
   public void prepareResult() 
   { 
   	// ������� ������� ����������� ����� ������, ����� ����������� ��� �������� ������� ���������
   	// � ��������������� �� �������� ������� �� ��������� [t0; t1] � ����� SamplingIncrement
   	Result.Resize((int)((T1 - T0)/SamplingIncrement) + 1, (int) (getOrder() + 1));
   	// ������� ������� ����� � ������� �����������
   	N = 0; 
   }


}
