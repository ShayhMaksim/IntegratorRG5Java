
public interface IVector {
public double GetItem(int i);//функция получения значения элемента
public void SetItem(int i,double value);//процедура установки значения элемента
public int GetSize();//функция получения размера вектора
public int GetHight();//функция получения индекса последнего элемента
public IVector Clone();//функция создания копии объекта
public void Resize(int n);//функция изменения размера вектора
public IVector Add(IVector a);//функция сложения векторов
public IVector Sub(IVector a);//функция вычитания векторов
public IVector Mult(double a);//функция умножения вектора на число
public IVector Mult(IMatrix a);//функция умножения вектора на матрицу
public double Mult(IVector a);//функция скалярного произведения векторов
public IVector Cross(IVector a);//функция векторного произведения векторов
public double Length();//функция получения модуля вектора
public IVector Norm();//функция нормирования вектора
public IVector Negativ();// функция негатива вектора
public void Print();// вывод вектора в консоле
}
