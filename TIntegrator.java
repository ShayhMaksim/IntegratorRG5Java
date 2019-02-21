
public class TIntegrator {
   protected double Eps;
   //�������� ����
 	double u;
   public TIntegrator()
   {
	   Eps=1e-8;
   }
   
	// ����������� �����, ����������� ��������� ���������� �������������� � ������������ ���������� ����������� ����������
   public void Run(TModel Model)
   {
	   
   }
   
   public void setPrecision(double Eps)
   {
	   this.Eps = Eps;
   }
   
  
   public double getPrecision() 
   { 
	   return Eps; 
   }
}


class TDormandPrinceIntegrator extends TIntegrator{
	// ������������ a,b,c
	static double a[][] = {
	    { 0. },
	    { 1./5 },
	    { 3./40, 9./40 },
	    { 44./45, -56./15, 32./9 },
	    { 19372./6561, -25360./2187, 64448./6561, -212./729 },
	    { 9017./3168, -355./33, 46732./5247, 49./176, -5103./18656 },
	    { 35./384, 0., 500./1113, 125./192, -2187./6784, 11./84 }
	}; 
	static double c[] = { 0, 1./5, 3./10, 4./5, 8./9, 1., 1. };
	static double b1[] = { 35./384, 0., 500./1113, 125./192, -2187./6784, 11./84, 0. };
	static double b2[] = { 5179./57600, 0., 7571./16695, 393./640, -92097./339200, 187./2100, 1./40 };
	 // ������������ K[i]
	IVector K[]=new TVector[7];
	
	public TDormandPrinceIntegrator()
	{
		
	}
	public void Run(TModel Model) {
		
		double // ��� ����� ��� �������������� (������������� �� �������� ���� ��������������)
		t = Model.getT0(),
		// ��� ����� ��� ������ (������������� ��������� �� �������� ���������)
		t_out = t,
		// ��� �������� �����
		t1 = Model.getT1(),
		// ��� ��� ��������������
		h,
		// ��� ��� ����� ��������� (���������������� ���������� ������ ����������)
		h_new = Model.getSamplingIncrement(),
		// ��� ������ �� ���� ��������������
	    e = 0;

 // ��� ������ ��������� �� ������ ����
    IVector X = Model.getInitialConditions();
    // ��� ������ ��������� �� ����� ���� (������� 4-�� �������)
    IVector X1= new TVector (X.GetSize());
    // ��� ������ ��������� �� ����� ���� ��� ��������� �������� ���� (������� 5-�� �������)
    IVector X2 = new TVector(X.GetSize());
    // ��� ������ ��� ������ ����������
    IVector Xout = new TVector ( X.GetSize() );
    // ��� ����� ��� ���������� ������������� �
    IVector Y = new TVector ( X.GetSize());	

// ���������� ��������� ����������� � ������ ��� ��������� ������������� ��������� ������
Model.prepareResult();

// �������������� ����������� ������������� K[j]
for ( int i = 0; i<7 ;i++ )
{
	K[i]=new TVector(X.GetSize());
}

double v=1;
while ((1+v)>1)
{
	u=v;
	v=v/2;
}


// ������� ���������� ��������� �����
int N = 0;

// ������� ����
while ( t < t1 )
		{
// ������������� ��� �� ��������
h = h_new;

// ��������� ������������ �
K[0] = Model.getRight( X, t );
K[1] = Model.getRight(  X.Add(K[0].Mult(h*a[1][0])) , t+c[1]*h);
K[2] = Model.getRight(  X.Add(K[0].Mult(h*a[2][0]).Add(K[1].Mult(a[2][1]*h))), t+c[2]*h);
K[3] = Model.getRight(  X.Add(K[0].Mult(h*a[3][0]).Add(K[1].Mult(a[3][1]*h).Add(K[2].Mult(h*a[3][2])))), t+c[3]*h);
K[4] = Model.getRight(  X.Add(K[0].Mult(h*a[4][0]).Add(K[1].Mult(a[4][1]*h).Add(K[2].Mult(h*a[4][2]).Add(K[3].Mult(h*a[4][3]))))), t+c[4]*h);
K[5] = Model.getRight(  X.Add(K[0].Mult(h*a[5][0]).Add(K[1].Mult(a[5][1]*h).Add(K[2].Mult(h*a[5][2]).Add(K[3].Mult(h*a[5][3]).Add(K[4].Mult(h*a[5][4])))))), t+c[5]*h);
K[6] = Model.getRight(  X.Add(K[0].Mult(h*a[6][0]).Add(K[1].Mult(a[6][1]*h).Add(K[2].Mult(h*a[6][2]).Add(K[3].Mult(h*a[6][3]).Add(K[4].Mult(h*a[6][4]).Add(K[5].Mult(h*a[6][5]))))))), t+c[6]*h);


// ��������� ������� 4-�� � 5-�� ��������


X1 = X.Add ( K[0].Mult(b1[0]*h).Add(K[1].Mult(b1[1]*h).Add(K[2].Mult(b1[2]*h).Add(K[3].Mult(b1[3]*h).Add(K[4].Mult(b1[4]*h).Add(K[5].Mult(b1[5]*h).Add(K[6].Mult(b1[6]*h))))))));
X2 = X.Add ( K[0].Mult(b2[0]*h).Add(K[1].Mult(b2[1]*h).Add(K[2].Mult(b2[2]*h).Add(K[3].Mult(b2[3]*h).Add(K[4].Mult(b2[4]*h).Add(K[5].Mult(b2[5]*h).Add(K[6].Mult(b2[6]*h))))))));


// ��������� �������� ��������� ������
double[] max=new double[X.GetSize()];
double e1=0;
for(int i=0;i<X.GetSize();i++)
{
	double[] max1=new double[] {(0.00001) , Math.abs(X1.GetItem(i)), Math.abs(X.GetItem(i)) , 0.25*u/Eps};
	double a=max1[0];
	
	for(int j=0;j<4;j++)
			if (a<=max1[j]) a=max1[j]; 
	
	max[i]=a;
	e1=e1+Math.pow(h*(X1.GetItem(i)-X2.GetItem(i))/max[i],2);
}
e=Math.pow(e1/X.GetSize(), 0.5);
 

// ��������� ����� �������� ����
double min;
double max2;


if (5>Math.pow((e/Eps), 0.1)/0.5) { min=Math.pow(e/Eps, 0.1)/0.5; } else min=5;

if (0.1>=min) {max2=0.1 ;} else max2=min; 

h_new = h/max2;

// ���� ��������� ������ ��������� ������������� ��������, �������� ������� ��� ������
if ( e > Eps )
    continue;

// ������������ ����������� ��� ������ ��������� ������� ������

	while ( (t_out < t + h) && (t_out <= t1) )
		{
	
		double theta = (t_out - t)/h;
		double[] b=new double[6]; 
		// ������������ ������������ ������� ������
		b[0] = theta*(1+theta*(-1337./480+theta*(1039./360+theta*(-1163./1152))));
		b[1] = 0;
		b[2] = 100.*theta*theta*(1054./9275+theta*(-4682./27825+theta*(379./5565)))/3.;
		b[3] = -5.*theta*theta*(27./40+theta*(-9./5+theta*(83./96)))/2.;
		b[4] = 18225.*theta*theta*(-3./250+theta*(22./375+theta*(-37./600)))/848.;
		b[5] = -22.*theta*theta*(-3./10+theta*(29./30+theta*(-17./24)))/7.;
    
   

    // �������� ��������� ��� ������
		Xout=X;
		for(int j=0;j<6;j++)
		{
			Xout = Xout.Add(K[j].Mult(b[j]*h));
		}
	
    // �������� ���������� � ������
		Model.addResult(Xout, t_out); 
    // ���������� ����� ������
		t_out += Model.getSamplingIncrement();
		}
		
// ��������� X �������� 5-�� ������� � ���������� ����� �� �������� ���������� ����
X = X1;
t += h;
// ������� ���������� �������� ��� ���������� ���������� �����������
N++;
		}
		
	}
}