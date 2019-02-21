
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
   
   // Запись результатов (в этом методе в наследнике допустимо организовать запись в файл 
	// вместо или вместе с наполнением матрицы результатов)
   public void addResult(IVector xout, double t)
   {
	// Проверим, выходит ли счётчик строк в матрице результатов за пределы последней строки
		// Если да, то увеличим количество строк на 1
		if (N == Result.GetRowCount())
			Result.Resize(N + 1, getOrder() + 1);
		// Поместим результаты в последнюю строку матрицы Result
		// Момент времени помещается в 0-ой столбец, вектор состояния - в остальные столбцы
		Result.SetItem(N, 0, t);
		for (int i = xout.GetSize(); i>0; i--)
			Result.SetItem(N, i, xout.GetItem(i-1));       
		// Увеличим N
		N++;
   }
   // Получение начальных условий
   public IVector getInitialConditions()
   {
	return X0; 
   }
   
// Получение матрицы результатов
   public IMatrix getResults()
   {
	   return Result;
   }
   
   // Абстрактная перегружаемая функция правых частей ДУ (X - вектор состояния, t - независимый аргумент)
   public IVector getRight(IVector x,double T)
   {
	   return null;
   }
  
   
// Интервал выдачи результатов
   public double getSamplingIncrement()
   {
	   return SamplingIncrement;
   }
   
// Управление временным интервалом интегрирования
   public double getT0()
   {	return T0; 	}
   public double getT1()
   {   	return T1;  }
   
   // Порядок системы - по размерности вектора начальных условий
   public int getOrder() { return X0.GetSize(); }
   
// Очистка матрицы результатов (или файла с результатами)
   public void clearResult() 
   { 
   	// Очистим матрицу результатов и сбросим счётчик строк
   	Result.Resize(0, 0); 
   	N = 0;
	
   }
  
// Подготовка матрицы результатов для более эффективного выделения памяти
   public void prepareResult() 
   { 
   	// Зададим матрице результатов такой размер, чтобы поместились все значения вектора состояния
   	// и соответствующих им моментов времени на интервале [t0; t1] с шагом SamplingIncrement
   	Result.Resize((int)((T1 - T0)/SamplingIncrement) + 1, (int) (getOrder() + 1));
   	// Сбросим счётчик строк в матрице результатов
   	N = 0; 
   }


}
