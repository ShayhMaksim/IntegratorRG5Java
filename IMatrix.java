
public interface IMatrix {
public double GetItem(int i,int j) ;//функция получения значения элемента
public void SetItem(int i,int j,double value);//процедура установки значения элемента
public int GetRowCount();//функции получения кол-ва строк
public int GetColCount();//функция получения кол-ва столбцов
public int GetRowHigh();//функция получения индекса последней строки
public int GetColHigh();//функция получения индекса последнего столбца
public IMatrix Clone(); //функция создания копии объекта
public void Resize(int n,int m);//процедура изменения размерности
public IMatrix Add(IMatrix a);//функция сложения матриц
public IMatrix Sub(IMatrix a);//функция вычитания матриц
public IMatrix Mult(IMatrix a);//функция умножения матрицы на матрицу
public IMatrix Mult(double a);//функция умножения матрицы на число
public IVector Mult(IVector a);//функция умножения матрицы на вектор
public double Det();//функция вычисления определителя
public IMatrix Inv();//функция обращения матрицы
public IMatrix T();//функция траспонирования матрицы
public void SwapRows(int i,int j); //процедура перестановки строк
public void SwapCols(int i,int j); //процедура перестановки столбцов
public IMatrix Invers();//функция получения обратной матрицы
public void Print();//вывод матрицы в консоле
public IMatrix Holetckogo();// метод Холецкого для симметричных матриц
public boolean Silvestr();// Критерий Сильвестра
public IMatrix InversSim(); // метод Холецкого для нахождения обратной матрицы для симметричных матриц
public IMatrix Negativ();  // негатив вектора
}
