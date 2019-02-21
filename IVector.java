
public interface IVector {
public double GetItem(int i);//������� ��������� �������� ��������
public void SetItem(int i,double value);//��������� ��������� �������� ��������
public int GetSize();//������� ��������� ������� �������
public int GetHight();//������� ��������� ������� ���������� ��������
public IVector Clone();//������� �������� ����� �������
public void Resize(int n);//������� ��������� ������� �������
public IVector Add(IVector a);//������� �������� ��������
public IVector Sub(IVector a);//������� ��������� ��������
public IVector Mult(double a);//������� ��������� ������� �� �����
public IVector Mult(IMatrix a);//������� ��������� ������� �� �������
public double Mult(IVector a);//������� ���������� ������������ ��������
public IVector Cross(IVector a);//������� ���������� ������������ ��������
public double Length();//������� ��������� ������ �������
public IVector Norm();//������� ������������ �������
public IVector Negativ();// ������� �������� �������
public void Print();// ����� ������� � �������
}
