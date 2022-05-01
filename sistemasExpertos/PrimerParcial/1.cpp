#include <iostream>
#include <stdlib.h>
using namespace std;
int main() {
char Obj[4][3] = {{'A','B','C'},
{'A','M','Y'},
{'A','B','D'},
{'D','X','C'}};

int answer = 1;
bool founded = false;

char preguntados[] = " ";
int sizePreguntados = 0;

cout<< "-------Bienvenido a SE encadenamiento hacia atrás------\n";
cout<<"A continuación, unas preguntas. Responda con '0' - no, '1' - sí \n";

//Objeto
for(int i=0; i<=3;i++){
if (founded)
break;
// cout<<"\nObjeto"<<i+1;
//Atributos
for(int j=0;j<=2;j++){
cout << "\nExperto: ¿Tiene "<< Obj[i][j]<<"?\n Usuario: ";
cin >> answer;
preguntados[sizePreguntados] = Obj[i][j];
sizePreguntados++;

if(answer == 0){
if (i == 3)
cout<<"No es ninguno";
break;
}
else if (j == 2 && answer == 1)
{
cout<<"\nEs el Objeto " << i+1;
founded = true;
break;
}
}
}
return 0;
}