#include <iostream>
#include <stdlib.h>
#include <vector>

using namespace std;
 char Obj[4][3]  = {{'A','B','C'}, 
                    {'A','M','Y'},
                    {'A','B','D'},  
                    {'D','X','C'}};  
  
  int answer = 1;
  bool founded = false;
  bool iguales = false;

  char preguntados[] = " ";
  char seleccionados[] = " ";

  int seleccionadosSize = 0;
  int preguntadosSize = 0;

  // char imprimir(char array[], int size)
  // {  
  //   for(int i = 0; i<= size-1; i++)
  //     return array[i];
  // }

  void agregar(char array[], char valor, int size)
  {
      array[size] = valor;
  }

  int main(){
    // Objeto
    for(int i=0; i<=3; i++)
    {
      //Atributo
      for(int j=0; j<=2; j++)
      {
        cout<<"\nPreguntados: " << preguntados;
        cout<<"\nSeleccionados: " << seleccionados;
        //¿Ya se preguntó?

        if(!iguales)
        {
          cout << "\nExperto: ¿Tiene "<< Obj[i][j]<<"?\n Usuario: ";
          cin >> answer;
          switch (answer)
          {
          case 0:  
            agregar(preguntados, Obj[i][j],sizeof(preguntados));
            break;
          case 1:
            if(sizeof(seleccionados) == 3)
            {
              break;
            }
            agregar(seleccionados, Obj[i][j], sizeof(seleccionados));
            agregar(preguntados, Obj[i][j], sizeof(preguntados));
            break;
          
          default:
            cout<<"\nEscribe una respuesta válida";
            break;
          }    
        }
      }
    }

    return 0;
  }