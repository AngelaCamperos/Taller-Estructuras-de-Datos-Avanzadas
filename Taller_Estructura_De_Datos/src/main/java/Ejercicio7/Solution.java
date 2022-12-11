package Ejercicio7;


class Solution {
public String[] findRelativeRanks(int[] nums) {
    int[] sorted=nums.clone();
    Arrays.sort(sorted);
    int i=0,j=nums.length-1;
    while(i<j){int temp=sorted[i];sorted[i]=sorted[j];sorted[j]=temp;i++;j--;}
    HashMap<Integer,String> map=new HashMap();
    for(int k=0;k<nums.length;k++)map.put(sorted[k],String.valueOf(k+1));
    String[] output=new String[nums.length];
    int k=0;
    for(int a:nums){
        if(map.get(a).equals("1"))output[k]="Gold Medal";
        else if(map.get(a).equals("2"))output[k]="Silver Medal";
        else if(map.get(a).equals("3"))output[k]="Bronze Medal";
        else output[k]=map.get(a);k++;
    }
    return output;
  }
}    

/*
_____________________________ANALISIS DE EL ALGORITMO__________________________
El código que ha proporcionado es una solución Java a un problema que implica 
la clasificación de una lista de números en función de su tamaño. La solución
define una clase Solution con un único método público, findRelativeRanks(), 
que toma una matriz de enteros nums como entrada y devuelve una matriz de
cadenas como salida.

El método crea primero una copia de la matriz de entrada nums llamada sorted 
y ordena los elementos de sorted en orden ascendente. A continuación, el 
método invierte el orden de los elementos de sorted para que estén en orden descendente.

A continuación, el método crea un objeto HashMap llamado map y utiliza un bucle 
for para iterar sobre los elementos de sorted. Para cada elemento k de sorted, 
el método añade un par clave-valor a map, donde la clave es el elemento k y el 
valor es la representación de cadena del rango de k en sorted.

A continuación, el método declara una matriz de cadenas llamada output que se utilizará para almacenar los resultados finales del método. A continuación, el método utiliza otro bucle for para iterar sobre los elementos de nums. Para cada elemento a en nums, el método recupera el valor correspondiente de map y lo asigna a output[k]. Si el valor es "1", "2" o "3", el método asigna la medalla correspondiente (es decir, "Medalla de Oro", "Medalla de Plata" o "Medalla de Bronce") a output[k]. El método incrementa el valor de k después de cada iteración.

Por último, el método devuelve la matriz de salida como resultado del método findRelativeRanks().
                                                                          
 Se le da una matriz scorede números enteros de tamaño n, donde score[i]es el 
puntaje del atleta en una competencia. Se garantiza que todas las puntuaciones 
son únicas .ith
Los atletas se colocan en función de sus puntajes, donde el atleta del lugar 
tiene el puntaje más alto, el atleta del lugar tiene el puntaje más alto, y 
así sucesivamente. La ubicación de cada atleta determina su rango:1st2nd2nd
El lugar donde se encuentra el rango del atleta .1st"Gold Medal"
El lugar donde se encuentra el rango del atleta .2nd"Silver Medal"
El lugar donde se encuentra el rango del atleta .3rd"Bronze Medal"
Para el puesto del atleta del puesto, su rango es su número de puesto (
es decir, el puesto del atleta del puesto es ).4thnthxth"x"
Devuelve una matriz answerde tamaño ndonde answer[i]está el rango del atleta.ith
_________________________ANALISIS DE COMPLEJIDAD________________________________
                                                                          
La complejidad temporal de este algoritmo es O(n log n) porque la operación de ordenación realizada por el método tiene una complejidad temporal de O(n log n) y los bucles for tienen una complejidad temporal de O(n).
 */
