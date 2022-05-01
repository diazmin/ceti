#include <iostream>
#include <string>

using namespace std;
int answer = 0;

int buscar1(string hechos){
    
    string hecho1 = hechos.substr(0,1);
    string hecho2 = hechos.substr(1);
    
    if (hecho1 == "H") {
        return buscar1("A" + hecho2);
    }
    else if (hecho1 == "A") {
        return buscar1("E" + hecho2);
    }
    else if (hecho1 == "L") {
        return buscar1("K" + hecho2);
    }
    else if (hecho1 == "B") {
        return 1;
    }

    if (hecho2 == "H") {
        return buscar1(hecho1 + "A");
    }
    else if (hecho2 == "A") {
        return buscar1(hecho1 + "E");
    }
    else if (hecho2 == "L") {
        return buscar1(hecho1 + "K");
    }
    else if (hecho2 == "B") {
        return 1;
    }

    if (hechos == "GK") {
        return buscar1("A");
    }
    else if (hechos == "KE") {
        return buscar1("B");
    }
    return 0;
}

int buscar2(string hechos) {

    string hecho1 = hechos.substr(0, 1);
    string hecho2 = hechos.substr(1);

    if (hecho1 == "J") {
        return buscar2("G" + hecho2);
    }
    else if (hecho1 == "F") {
        return 2;
    }

    if (hecho2 == "J") {
        return buscar2(hecho1 + "G");
    }
    else if (hecho2 == "F") {
        return 2;
    }

    if (hechos == "EG") {
        return buscar2("F");
    }

    return 0;
}

int buscar3(string hechos) {

    string hecho1 = hechos.substr(0, 1);
    string hecho2 = hechos.substr(1);

    if (hecho1 == "J") {
        return buscar3("D" + hecho2);
    }
    else if (hecho1 == "H") {
        return buscar3("D" + hecho2);
    }
    else if (hecho1 == "A") {
        return buscar3("E" + hecho2);
    }
    else if (hecho1 == "C") {
        return 3;
    }

    if (hecho2 == "J") {
        return buscar3(hecho1 + "D");
    }
    else if (hecho2 == "H") {
        return buscar3(hecho1 + "D");
    }
    else if (hecho2 == "A") {
        return buscar3(hecho1 + "E");
    }
    else if (hecho2 == "C") {
        return 3;
    }

    if (hechos == "DE") {
        return buscar3("C");
    }

    return 0;
}

void evaluar(string answer) {
    if (buscar1(answer) == 1) {
        cout << "Es el objeto 1\n";
    }
    if (buscar2(answer) == 2) {
        cout << "Es el objeto 2\n";
    }
    if (buscar3(answer) == 3) {
        cout << "Es el objeto 3\n";
    }
}



int main(){

    string hechos = "";

    cout<<"Escribe los hechos iniciales: ";
    cin>>hechos;

    evaluar(hechos);
}



