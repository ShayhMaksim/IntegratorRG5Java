
public interface IQuaternion {
public double GetItem(int i);//������� ��������� �������� ��������
public IVector GetVect();//������� ��������� ��������� ����� �����������
public IQuaternion Clone();//������� �������� ����� �������
public IQuaternion fromElements(double q0,double q1,double q2,double q3);//������������ ������� ��� �������� ����������� �� ��� �����������
public IQuaternion fromAngleAndAxis(double phi,IVector e);//������������ ������� ��� �������� ����������� �� ���� � ��� �������� 
public IQuaternion fromKrylovAngles(double yaw,double pitch,double roll);//������������ ������� ��� �������� ����������� �� ����� �������
public IQuaternion Negative(IQuaternion a);//�������� ������� �����
public IQuaternion Add(IQuaternion a,IQuaternion b);//�������� �������� ������������
public IQuaternion Substract(IQuaternion a,IQuaternion b);//�������� ��������� ������������
public IQuaternion Multiply(IQuaternion a,IQuaternion b);//�������� ��������� ������������
public IQuaternion Multiply(IQuaternion a,double b);//�������� ��������� ����������� �� �����
public IQuaternion Multiply(double a,IQuaternion b);//�������� ��������� ����� �� ����������
public IQuaternion Multiply(IQuaternion a,IVector b);//�������� ��������� ����������� �� ������
public IQuaternion Multiply(IVector a,IQuaternion b);//�������� ��������� ������� �� �����������
public IQuaternion norm();//������� ������������ �����������
public IQuaternion conj();//������� ��������� ������������ �����������
public IQuaternion inv();//������� ��������� �����������
public IMatrix toRotateMatrix();//������� ��������� ������� �������� �� ����������� �����������
}
