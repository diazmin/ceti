#include <iostream>
#include <string>

using namespace std;
string question = "";
int matches = 0;

void match(string atributo){
    
    string question1 = question.substr(0,1);
    string question2 = question.substr(1);

    if(atributo == question1 || atributo == question2){
        matches++;
        cout<<"\nMatches " << matches;
    }
}

int buscar1(string hechos){
    
    string hecho1 = hechos.substr(0,1);
    string hecho2 = hechos.substr(1);

    // cout<<"\nH1: " << hecho1;
    // cout<<"\nH2: " << hecho2;
    
    if(matches == question.length()-1){
        cout<<"\nMatches1 " << matches;
        return 1;
    }
    
    if (hecho1 == "H") {
        match("A");
        return buscar1("A" + hecho2);
    }
    else if (hecho1 == "A") {
        match("E");
        return buscar1("E" + hecho2);
    }
    else if (hecho1 == "L") {
        match("K");
        return buscar1("K" + hecho2);
    }
    else if (hecho1 == "B") {
        match("B");
        return buscar1("1" + hecho2);
    }

    if (hecho2 == "H") {
        match("H");
        return buscar1(hecho1 + "A");
    }
    else if (hecho2 == "A") {
        return buscar1(hecho1 + "E");
    }
    else if (hecho2 == "L") {
        match("L");
        return buscar1(hecho1 + "K");
    }
    else if (hecho2 == "B") {
        return buscar1(hecho1 + "1");
    }

    if (hechos == "GK") {
        return buscar1("A");
    }
    else if (hechos == "KE") {
        return buscar1("B");
    }
    matches = 0;
    return 0;
}

int buscar2(string hechos) {

    string hecho1 = hechos.substr(0, 1);
    string hecho2 = hechos.substr(1);
   
    // cout<<"\n2H1: " << hecho1;
    // cout<<"\n2H2: " << hecho2;

    if(matches == question.length()-1){
        cout<<"\nMatches2 " << matches;
        return 2;
    }

    if (hecho1 == "J") {
        match("G");
        return buscar2("G" + hecho2);
    }
    else if (hecho1 == "F") {
        match("F");
        return buscar2("2" + hecho2);
    }

    if (hecho2 == "J") {
        match("J");
        return buscar2(hecho1 + "G");
    }
    else if (hecho2 == "F") {
        return buscar2(hecho1 + "2");
    }

    if (hechos == "EG") {
        match("E");
        return buscar2("F");
    }
    matches = 0;
    return 0;
}

int buscar3(string hechos) {

    string hecho1 = hechos.substr(0, 1);
    string hecho2 = hechos.substr(1);

    // cout<<"\n3H1: " << hecho1;
    // cout<<"\n3H2: " << hecho2;

    if(matches == question.length()-1){
        cout<<"\nMatches3 " << matches;
        return 3;
    }

    if (hecho1 == "J") {
        match("D");
        return buscar3("D" + hecho2);
    }
    else if (hecho1 == "H") {
        match("H");
        return buscar3("D" + hecho2);
    }
    else if (hecho1 == "A") {
        match("E");
        return buscar3("E" + hecho2);
    }
    else if (hecho1 == "C") {
        match("C");
        return buscar3("3" + hecho2);
    }

    if (hecho2 == "J") {
        match("J");
        return buscar3(hecho1 + "D");
    }
    else if (hecho2 == "H") {
        return buscar3(hecho1 + "D");
    }
    else if (hecho2 == "A") {
        match("A");
        return buscar3(hecho1 + "E");
    }
    else if (hecho2 == "C") {
        return buscar3(hecho1 + "3");
    }

    if (hechos == "DE") {
        return buscar3("C");
    }
    matches = 0;
    return 0;
}

void evaluar(string answer) {
    if (buscar1(answer) == 1) {
        cout << "\nEs el objeto 1\n";
    }
    if (buscar2(answer) == 2) {
        cout << "\nEs el objeto 2\n";
    }
    if (buscar3(answer) == 3) {
        cout << "\nEs el objeto 3\n";
    }
}



int main(){
    string hechos = "";

    cout<<"Escribe los hechos iniciales: ";
    cin>>hechos;
    question = hechos;

    evaluar(hechos);
}



