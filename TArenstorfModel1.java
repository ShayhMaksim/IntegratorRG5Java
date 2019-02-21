 //---------------------------------------------------------------------------
// Задача Аренсторфа (начальные условия 1)

//t=17.0652165601579625588917206249
public class TArenstorfModel1 extends TModel {
	double m=0.012277471;
	double m1=(1-0.012277471);
	public TArenstorfModel1(double t0, double t1, double SamplingIncrement)
	{	
		this.T0=t0;
	    this.T1=t1;
		this.SamplingIncrement=SamplingIncrement;
		X0=new TVector(4);
	    X0.SetItem(0, 0.994);
	    X0.SetItem(1, 0);
	    X0.SetItem(2, 0);
	    X0.SetItem(3, -2.00158510637908252240537862224);
	 
	}
    @Override
	public IVector getRight(IVector X, double t)
	{
    	IVector Y=new TVector(4);
    	
    	double D1=Math.pow(Math.pow((X.GetItem(0)+m),2)+ Math.pow(X.GetItem(1), 2), 1.5);
    	double D2=Math.pow(Math.pow((X.GetItem(0)-m1),2)+ Math.pow(X.GetItem(1), 2), 1.5);
    	
    	Y.SetItem(0, X.GetItem(2));
    	Y.SetItem(1, X.GetItem(3));
        Y.SetItem(2, X.GetItem(0)+2*X.GetItem(3)-m1*(X.GetItem(0)+m)/D1-m*(X.GetItem(0)-m1)/D2);
        Y.SetItem(3, X.GetItem(1)-2*X.GetItem(2)-m1*X.GetItem(1)/D1-m*X.GetItem(1)/D2);
       
        return Y;  	
	}
}

//---------------------------------------------------------------------------
//Задача Аренсторфа (начальные условия 2)

//t=11.124340337266085134999734047
class TArenstorfModel2 extends TArenstorfModel1 {
	public TArenstorfModel2(double t0, double t1, double SamplingIncrement)
	{
		super(t0,t1,SamplingIncrement);
		X0=new TVector(4);
	    X0.SetItem(0, 0.994);
	    X0.SetItem(1, 0);
	    X0.SetItem(2, 0);
	    X0.SetItem(3, -2.0317326295573368357302057924);
	 
	}
}
