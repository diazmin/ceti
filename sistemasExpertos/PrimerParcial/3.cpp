#include <iostream>
#include <stdlib.h>

using namespace std;

int answer = 1;
bool founded = false;

char preguntados[] = " ";
int sizePreguntados = 0;

char seleccionados[] = " ";
int sizeSeleccionados = 0;

bool repetidos(char obj){
  bool iguales = false;
  for(int i=0; i<sizePreguntados; i++)
  {
    if(preguntados[i] == obj)
      iguales = true;
      return iguales;    
  }
}
int main() {
char Obj[4][3] = {{'A','B','C'},
{'A','M','Y'},
{'A','B','D'},
{'D','X','C'}};

cout<< "-------Bienvenido a SE encadenamiento hacia atrás------\n";
cout<<"A continuación, unas preguntas. Responda con '0' - no, '1' - sí \n";

//Objeto
for(int i=0; i<=3;i++)
{
  if (founded)
    break;

cout<<"\nObjeto"<<i+1;
//Atributos
  for(int j=0;j<=2;j++)
  {
    if(!repetidos(Obj[i][j]))
    {
      cout << "\nExperto: ¿Tiene "<< Obj[i][j]<<"?\n Usuario: ";
      cin >> answer;
      cout<<preguntados;
      preguntados[sizePreguntados] = Obj[i][j];
      sizePreguntados++;
        
      if(answer == 1){
        if(sizeSeleccionados == 3){
          // buscar();
          cout<<"Buscar";
          break;
          }
        seleccionados[sizeSeleccionados] = Obj[i][j];
        sizeSeleccionados++;
        }else if(answer == 0){continue;}
        else{cout<<"\nEscribe una respuesta válida";}
    }
    
    }
  return 0;
  }
}