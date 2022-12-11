package Ejercicio8;


#include<functional>
#include<stdio.h>
#include<string.h>
#include<queue>
using namespace std;
typedef struct
{
	char stu[20];
	int x;
}carry;
carry str[1000005],str1[1000005];
int  main()
{
	int n,m,j=0;
	priority_queue<int, vector<int>,greater<int> >k;
	scanf("%d",&n);
	for(int i=1;i<=n;i++)
	{
		scanf(" %s",str[i].stu);
		if(strcmp(str[i].stu,"removeMin")!=0)
			scanf("%d",&str[i].x);
		if(strcmp(str[i].stu,"insert")==0)
		{
			k.push(str[i].x);
			str1[j++]=str[i];
		}
		else if(strcmp(str[i].stu,"removeMin")==0)
		{
			if(k.empty())
			{
				k.push(1);
				strcpy(str1[j].stu,"insert");
				str1[j++].x=1;
			}
			k.pop();
			str1[j++]=str[i];
		}
		else if(strcmp(str[i].stu,"getMin")==0)
		{
            if(k.empty())
			{
				strcpy(str1[j].stu,"insert");
				str1[j++].x=str[i].x;
				k.push(str[i].x);
				strcpy(str1[j].stu,"getMin");
				str1[j++].x=str[i].x;
			}
			else
			{
				while(k.top()<str[i].x)
				{
					strcpy(str1[j++].stu,"removeMin");
					k.pop();
					if(k.empty())
					{
						strcpy(str1[j].stu,"insert");
						str1[j++].x=str[i].x;
						k.push(str[i].x);
					}
				}
				if(k.top()>str[i].x)
				{
					strcpy(str1[j].stu,"insert");
					str1[j++].x=str[i].x;
					k.push(str[i].x);
				}
				if(k.top()==str[i].x)
				{
					strcpy(str1[j].stu,"getMin");
					str1[j++].x=str[i].x;
				}
			}
		}
	}
	printf("%d\n",j);
	for(int i=0;i<j;i++)
	{
		if(strcmp(str1[i].stu,"removeMin")==0)
			printf("%s\n",str1[i].stu);
		else
			printf("%s %d\n",str1[i].stu,str1[i].x);
	}
}


/* ______________________ANALISIS DE EL ALGORITMO______________________________-
 * 
 * 
Este código es una implementación de una estructura de datos de cola utilizando 
una cola de prioridad. Permite tres operaciones en la cola: insert, removeMin,
y getMin. Está escrito en C++ y utiliza la clase priority_queue de la biblioteca
estándar para implementar la cola de prioridad.

El código define primero una estructura carry que tiene dos miembros: un array 
char llamado stu para almacenar el nombre de una operación y un int llamado x 
para almacenar un argumento entero para la operación. Luego declara dos matrices
de carry structs llamadas str y str1 para almacenar las operaciones de entrada y
salida, respectivamente.

En la función principal, el código lee el número de operaciones, n, de la entrada
estándar y, a continuación, lee n líneas de entrada, cada una de las cuales 
contiene una operación y su argumento. Para cada operación, actualiza la cola de
prioridad de la siguiente manera:

* Para una operación de inserción, coloca el argumento entero en la cola de
prioridad. También añade la operación a la matriz str1.


* Para una operación removeMin, elimina el elemento más pequeño de la cola de
prioridad. Si la cola de prioridad está vacía, coloca un elemento ficticio 
con valor 1 en la cola de prioridad. A continuación, añade la operación removeMin
a la matriz str1.


* Para una operación getMin, extrae repetidamente elementos de la cola de prioridad
hasta que el elemento más pequeño de la cola de prioridad es mayor o igual que el 
argumento entero para la operación getMin. Si el elemento más pequeño de la cola de
prioridad es mayor que el argumento, empuja el argumento a la cola de prioridad. 
A continuación, añade la operación getMin a la matriz str1.
Una vez procesadas todas las operaciones, el código muestra el número de operaciones
en la matriz str1, seguido de las propias operaciones.


  En primer lugar, esta pregunta utiliza una cola de prioridad, que es la base para resolver esta pregunta.
  ¿Qué es una cola de prioridad?
   Archivo de encabezado de llamada:
  #include<queue>
  usando el espacio de nombres std; (la plantilla de la cola necesita definir el tipo de contenedor)
       uso detallado (parte): 
  Priority_queue<Type> k; ------ Defina una cola ordenada (el elemento superior es el más grande El uno)
  priority_queue<(el tipo de datos de los elementos en la cola), (el tipo del contenedor subyacente utilizado para almacenar y acceder a los elementos de la cola), (reglas de comparación) > k ------ ( forma estándar) define una cola ordenada
  Por ejemplo: cola_prioridad<int, vector<int>, mayor<int> > k; (nota: debe haber un espacio después de la regla de comparación)
define una cola ordenada, y la regla de clasificación es de grande a pequeño (el elemento superior es el más pequeño El que está en la parte superior del mayor) (el más pequeño en la parte superior de mayor, el más grande en la parte superior de menor)


  k.empty() ------ Verifique si es un ejemplo vacío, en caso afirmativo, devuelve 1, no devuelve 0
  k.push(i) ------ Desde Agregar elemento i después del elemento existente (el tamaño del equipo no está predeterminado)
  k.pop() - ----- Borrar el elemento superior (por supuesto, después de ordenar, lo mismo a continuación)
  k.top() ---- -- Mostrar el elemento superior
  k.size() ------ Mostrar el número de elementos existentes
 
Luego mira la solución específica de la pregunta:
  En primer lugar, hay insert, getmin, removemin, tres formas.
insert y removemin no se detallarán aquí;
Concéntrese en discutir la situación de getmin. Realmente llevó demasiado tiempo depurar en ese momento.
(1) Cuando la cola está vacía, inserte directamente + getmin;
(2) Cuando el valor mínimo actual de la cola es menor que el valor mínimo en getmin, es necesario eliminar continuamente el valor mínimo en la cola hasta que sea mayor o igual a
Valor mínimo en getmin
(3) Cuando el valor mínimo actual en la cola es mayor que getmin, inserte directamente;
(4) Cuando se elimina el valor mínimo en la cola, la cola está vacía y se inserta directamente;
---------------ANALISIS DE COMPLEJIDA____________________________________
El algoritmo tiene una complejidad de O(N)

La complejidad temporal de este algoritmo es O(n log n), donde n es el número de
operaciones. Esto se debe a que cada operación tarda O(log n) en ejecutarse, ya 
que la clase priority_queue utiliza un montón binario como estructura de datos subyacente.
La complejidad espacial es O(n), porque las matrices str y str1 tienen un tamaño n.

   */