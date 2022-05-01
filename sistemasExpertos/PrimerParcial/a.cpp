#include <iostream>
#include <stdlib.h>

int main() {


    std::string objs[4]= {"ABC", "AMY", "DXC", "ABD"};

    std::string answer = "";
    int founded = 0;


    std::cout<< "-------Bienvenido a SE encadenamiento hacia adelante------\n";
    std::cout<<"Experto: Ingresa los hechos iniciales \nUsuario: ";
    std::cin>>answer;

    for(int i=0; i<4; i++){
        
        if(answer == objs[i]){
            std::cout<<"Es el objeto "<<i+1;
            break;
        }else if(i==3 && answer!=objs[i]){
            std::cout<<"El objeto no existe";
            }
    }

    

}