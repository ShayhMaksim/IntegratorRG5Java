
public class TVector implements IVector {

	protected double[] data;
	
	public TVector()
	{
		this.data=new double[1];
	}
	
	public TVector(int n)
	{
		this.data=new double[n];
	}
	
	@Override
	public double GetItem(int i) {
		// TODO Auto-generated method stub
			return data[i];
	}

	@Override
	public void SetItem(int i, double value) {
		// TODO Auto-generated method stub
          data[i]=value;
	}

	@Override
	public int GetSize() {
		// TODO Auto-generated method stub
		 
		return data.length;
	}

	@Override
	public int GetHight() {
		// TODO Auto-generated method stub
		return data.length-1;
	}

	@Override
	public IVector Clone() {
		// TODO Auto-generated method stub	
		IVector vect=new TVector(this.GetSize());
		for(int i=0;i<this.GetSize();i++)
		{
			vect.SetItem(i, this.GetItem(i));
		}
		return vect;
	}

	@Override
	public void Resize(int n) {
		// TODO Auto-generated method stub
		 double[] a=new double[this.GetSize()];
		  a=this.data;
		
        this.data=new double[n];
        for(int i=0;i<n;i++)
        {
         if (i<a.length) 
  		   {
  		   this.SetItem(i,  a[i]);
  		   }
        }
        
	}

	@Override
	public IVector Add(IVector a) {
		// TODO Auto-generated method stub
		try {
		if (a.GetSize()!=this.GetSize()) throw new Exception("Несовместимые размерности");
		}
		catch(Exception ex)
		{
			Resize(a.GetSize());
		}
		IVector vect=new TVector(a.GetSize());
	   for(int i=0; i<a.GetSize();i++)
	   {
		  vect.SetItem(i,(a.GetItem(i)+this.GetItem(i)));
	   }
		return vect;
	}

	@Override
	public IVector Sub(IVector a) {
		// TODO Auto-generated method stub
		try {
			if (a.GetSize()!=this.GetSize()) throw new Exception("Несовместимые размерности");
			}
			catch(Exception ex)
			{
				Resize(a.GetSize());
			}
			IVector vect=new TVector(a.GetSize());
		   for(int i=0; i<this.GetSize();i++)
		   {
			  vect.SetItem(i,(this.GetItem(i)-a.GetItem(i)));
		   }
		return vect;
	}

	@Override
	public IVector Mult(double a) {
		// TODO Auto-generated method stub
		IVector vect=new TVector(this.GetSize());
		for(int i=0; i<this.GetSize();i++)
		   {
			  vect.SetItem(i,(this.GetItem(i)*a));
		   }
		return vect;
	}

	@Override
	public IVector Mult(IMatrix a) {
		// TODO Auto-generated method stub
		IVector vect=new TVector(a.GetColCount());
		for(int j=0;j<a.GetColCount();j++)
		   {
			 for(int i=0; i<a.GetRowCount();i++)
			 {
				 vect.SetItem(j, (vect.GetItem(j)+a.GetItem(i, j)*this.GetItem(i)));
			 }
		   }
		return vect;
	}

	@Override
	public double Mult(IVector a) {
		// TODO Auto-generated method stub
		try {
			if (a.GetSize()!=this.GetSize()) throw new Exception("Несовместимые размерности");
			}
			catch(Exception ex)
			{
				Resize(a.GetSize());
			}
        double b = 0;
		for(int i=0;i<this.GetSize();i++)
		{
			b+=a.GetItem(i)*this.GetItem(i);
		}
		return b;
	}

	@Override
	public IVector Cross(IVector a) {
		// TODO Auto-generated method stub
		IVector Cross=new TVector(this.GetSize());
		if (a.GetSize()==3 & this.GetSize()==3){
			Cross.SetItem(0, this.GetItem(1)*a.GetItem(2)-this.GetItem(2)*a.GetItem(1));
			Cross.SetItem(1, this.GetItem(2)*a.GetItem(0)-this.GetItem(0)*a.GetItem(2));
			Cross.SetItem(2, this.GetItem(0)*a.GetItem(1)-this.GetItem(1)*a.GetItem(0));
		}
		else System.out.println("Не подходящая размерность");
		return Cross;
	}

	@Override
	public double Length() {
		// TODO Auto-generated method stub
		double b=0;
		for(int i=0;i<this.GetSize();i++)
        {
       	 b+=this.GetItem(i)*this.GetItem(i);
        }
		return Math.pow(b, 0.5);
	}

	@Override
	public IVector Norm() {
		// TODO Auto-generated method stub
		IVector vect=new TVector(this.GetSize());
		for(int i=0; i<this.GetSize();i++)
		   {
			  vect.SetItem(i,(this.GetItem(i)/this.Length()));
		   }
		return vect;
	}
	
	@Override
	public void Print() {
		System.out.print("( ");
		for (int i=0; i<GetSize(); i++) {
			System.out.print(GetItem(i)+" ");
		}
		System.out.println(")");
	}
	
	@Override
	public IVector Negativ() {
		IVector Neg = this.Clone();
		for (int i=0; i<Neg.GetSize(); i++) {
			if (Neg.GetItem(i)>0) {
				Neg.SetItem(i, Neg.GetItem(i)*(-1));
			}
		}
		return Neg;
	}

}
