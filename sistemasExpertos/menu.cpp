#include <iostream>
#include <string>
using namespace std;

struct Objeto{
    string nombre;
    struct Atributo *atributos;
    Objeto *siguiente;
    };

struct Atributo{
    string descripcion;
    Atributo *siguiente;
};

string o;
Atributo *r = new Atributo();
Atributo *a = new Atributo();

void agregarObjeto(Objeto *&, string, Atributo *);
void agregarAtributo(Atributo *&, string);
void mostrarObjetos(Objeto *);
void mostrarAtributos(Atributo *lista2);
bool atributoRepetido(Atributo *, string);
bool encontrarCoincidencia(Atributo *, Atributo *);
void consultarObjetos(Objeto *);
void encontrarObjeto(Objeto *, Atributo *);
bool compararListas(Atributo *, Atributo *);

int main(){
    Objeto *objetos = NULL;
    Atributo *atributos = NULL;

    string objName = "";
    string descripcion = "";
    
    int opc;
    do{
        cout<<"\nElige una opción:\n 1.- Agregar objetos a la BC \n 2.- Consultar al SE\n 3.- Guardar la BC\n 4.- Usar una BC existente\n 5.- Salir"<<endl;
        cin>>opc;
        switch(opc){
            case 1:
                do{
                    cout<<"\nNombre del objeto (salir con 0): ";
                    cin>>objName;
                    if(objName == "0")
                        break;
                    cout<<"\nAtributos: "<<endl;
                    atributos = new Atributo();
                    do{
                        cout<<": ";
                        cin>>descripcion;
                        if(descripcion != "0"){ 
                            if(!atributoRepetido(atributos, descripcion)){
                                agregarAtributo(atributos, descripcion);
                            }else{
                                cout<<"Already exists, write other"<<endl;
                            }
                        }
                    }while(descripcion != "0");
                    agregarObjeto(objetos, objName, atributos);
                }while(objName != "0");
                break;
            case 2:
                consultarObjetos(objetos);
                break;
            case 5:
                exit(-1);
            case 7:
                mostrarObjetos(objetos);
                break;
            default:
                cout<<"\nElige una opción válida\n";
        }

    }while(opc != 5);

    return 0;
    }
    void agregarObjeto(Objeto *&lista, string nombre, Atributo *atributos){
        Objeto *nuevo_nodo = new Objeto();
        nuevo_nodo->nombre = nombre;
        nuevo_nodo->atributos = atributos;
        
        Objeto *aux1 = lista;

        if(lista == NULL){
            nuevo_nodo->siguiente = NULL;
        }else{
            nuevo_nodo->siguiente = aux1;
        }
        lista = nuevo_nodo;
        cout<<"\nObjeto agregado\n";

    }

    void agregarAtributo(Atributo *&lista, string descripcion){
        Atributo *nuevo_nodo = new Atributo();
        nuevo_nodo->descripcion = descripcion;
        Atributo *aux1 = lista;
        Atributo *nodo_anterior, *aux_ant = lista;

        if(lista == NULL){
            nuevo_nodo->siguiente = NULL;
        }else{
            nuevo_nodo->siguiente = aux1; 
        }
        lista = nuevo_nodo;
    }

    void mostrarObjetos(Objeto *lista){
        Objeto *actual = new Objeto();

        actual = lista;
        while(actual != NULL){
            cout<<"\nObjeto: ";
            cout<<actual->nombre;
            mostrarAtributos(actual->atributos);
            actual = actual->siguiente;
        }
    }

 void mostrarAtributos(Atributo *lista2){
        Atributo *actual2 = new Atributo();
        actual2 = lista2;

        while(actual2 != NULL){
            cout<<"\n"<<actual2->descripcion<<endl;
            actual2 = actual2->siguiente;
        }
    }

    void consultarObjetos(Objeto *lista){
        Objeto *actual = new Objeto();
        Atributo *aceptados = new Atributo();
        Atributo *rechazados = new Atributo();          
        actual = lista;
        int opc;
        string opc2 = "y";
        cout<<"\n¿Qué desea hacer?\n Consultar SE -- 1 \nVer status actual -- 2 \n: ";
        cin>>opc;
        if(opc==2){
            if(o.compare("") == 1){
                cout<<"\nSe considera al objeto "<<o<<" porque es ";
                mostrarAtributos(a);
                cout<<" Y no es ";
                mostrarAtributos(r);
                cout<<"\n¿Desea buscar otra solución? (y/n): ";
                cin>>opc2;
                if(opc2 == "y"){
                    encontrarObjeto(lista, aceptados);
                }
            }else
                cout<<"\nAún no se ha consultado"<<endl; 
        }else if(opc==1){
            if(actual == NULL){
                cout<<"\nNo se han agregado objetos a la BC"<<endl;
            }else{
                //Cada objeto de la lista
                while(actual != NULL){
                    // cout<<"\nObjeto: ";
                    // cout<<actual->nombre;
                    Atributo *actual2 = new Atributo(); 
                    actual2 = actual->atributos;
                    // mostrarAtributos(actual2);
                    string answer = "y";
                    //Rechaza objeto con atributos que fueron rechazados
                    if(!encontrarCoincidencia(rechazados, actual->atributos)){
                        //Cada atributo de la lista
                        while(actual2->siguiente != NULL){
                            if(!atributoRepetido(rechazados, actual2->descripcion) && !atributoRepetido(aceptados, actual2->descripcion)){

                                cout<<"\n¿Es "<<actual2->descripcion<<"? (y/n): ";
                                cin>>answer;
                                if(answer == "y"){
                                    agregarAtributo(aceptados, actual2->descripcion);
                                }else if(answer == "n"){
                                    agregarAtributo(rechazados, actual2->descripcion);
                                    break;
                                }else{
                                    cout<<"\ny/n para continuar: ";
                                    break;}
                            }else{
                                actual2 = actual2->siguiente;    
                            }
                        }
                        actual = actual->siguiente; 
                    }else{
                        actual = actual->siguiente; 
                    }
                }
                a = aceptados;
                r = rechazados;
                encontrarObjeto(lista, aceptados);
            }
        }else
           cout<<"\nIngrese una opción válida";
    }

 void encontrarObjeto(Objeto *lista, Atributo *aceptados){
      Objeto *actual = new Objeto(); 
      actual = lista;
        //Cada objeto de la lista
        while(actual != NULL){
            Atributo *actual2 = new Atributo(); 
            actual2 = actual->atributos;
            if(compararListas(aceptados, actual->atributos)){
                cout<<"Es el objeto "<<actual->nombre<<endl;
                o = actual->nombre;
                break;
            }else{
                actual = actual->siguiente; 
            }       
        }
 }   
 bool atributoRepetido(Atributo *lista, string descripcion){
        Atributo *aux = new Atributo();
        aux = lista;
        while(aux->siguiente != NULL){
            if(aux->descripcion.compare(descripcion) == 0){
                return true;
            }
            aux = aux->siguiente;
        }
        return false;
    }
 bool encontrarCoincidencia(Atributo *lista, Atributo *lista2){
     Atributo *aux = new Atributo();
     Atributo *aux2 = new Atributo();
     aux = lista; //del objeto
     aux2 = lista2; //rechazados 

     while(aux->siguiente != NULL){
            while(aux2->siguiente != NULL){
                if(aux->descripcion == aux2->descripcion){
                    return true;
                }
                aux2 = aux2->siguiente;
            }
            aux = aux->siguiente;
            aux2 = lista2;
        }
        return false;  
 } 
 bool compararListas(Atributo *lista, Atributo *lista2){
      Atributo *aux = new Atributo();
     Atributo *aux2 = new Atributo();
     aux = lista; 
     aux2 = lista2;
     int matches = 0;
     int sizeList = 0;

     while(aux->siguiente != NULL){
            while(aux2->siguiente != NULL){
                if(aux->descripcion == aux2->descripcion){
                    matches++;
                }
                aux2 = aux2->siguiente;
            }
            aux = aux->siguiente;
            aux2 = lista2;
            sizeList++;
        }
    if(matches == sizeList){
        return true;
    }
    else
        return false;
 }
 