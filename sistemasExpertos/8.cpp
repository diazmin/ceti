#include <iostream>
#include <list>
#include <string>

using namespace std;

class Objetos {
public:
    list<string> objetos;
    list<string> atributosA;
    list<string> atributosR;
    list <list<string> > objatr;

    void agregarObjeto(string r);
    void consultar();
    bool Rechazados(list<string>::iterator atr, list<list<string> >::iterator listaA);
    bool Aceptados(string it2);
    void mostrar();
};

void Objetos::agregarObjeto(string r) {
    objetos.clear();
    if (r != "0") {
        objetos.push_back(r);
        cout << "Introduce los atributos (0 para salir)" << endl;
        while (r != "0") {
            cout << "- ";
            getline(cin, r);
            if (r != "0")
                objetos.push_back(r);
        }
        objatr.push_back(objetos);
    }
}

bool Objetos::Aceptados(string it2) {
    list<string>::iterator it = atributosA.begin();
    if (atributosA.empty())
        return false;
    while (it != atributosA.end()) {
        if (it2 == *it) {
            return true;
        }
        *it++;
    }
    return false;

}

bool Objetos::Rechazados(list<string>::iterator atr, list<list<string> >::iterator listaA) {
    list<string>::iterator it = atributosR.begin();
    if (atributosR.empty())
        return true;
    while (it != atributosR.end()) {
        while (atr != listaA->end()) {
            if (*atr == *it) {
                return false;
            }
            *atr++;
        }
        *it++;
    }
    return true;
}

void Objetos::consultar() {
    list<list<string> >::iterator ls = objatr.begin();
    list<string>::iterator ls2 = ls->begin();
    string eleccion;
    int encontro = 0;
    while (ls != objatr.end())
    {
        if (encontro == 1)
            break;
        ls2 = ls->begin();
        ls2++;
        if (Rechazados(ls2, ls)) {
            while (ls2 != ls->end()) {
                if (ls2->empty()) {
                    *ls2++;
                }
                if (!Aceptados(*ls2)) {
                    cout << "Tu objeto: " << *ls2 << "?" << " (s = si n = no)" << endl;
                    cout << "- ";
                    cin >> eleccion;
                    if (eleccion == "s") {
                        atributosA.push_back(*ls2);
                    }
                    else if (eleccion == "n") {
                        atributosR.push_back(*ls2);
                        break;
                    }
                }
                *ls2++;
                if (ls2 == ls->end() && eleccion == "s") {
                    encontro++;
                    cout << "Tu objeto es: " << *ls->begin() << endl;
                }
            }
        }
        *ls++;
    }
    atributosA.clear();
    atributosR.clear();
    if (encontro == 0) {
        cout << "no existe tu objeto" << endl;
    }
}

int main()
{
    int menu = 0;
    string r;
    Objetos objeto;
    while (menu != 5)
    {
        cout << "1) Introducir objetos a la BC" << endl;
        cout << "2) Consultar al SE" << endl;
        cout << "3) Guardar la BC" << endl;
        cout << "4) Usar una BC existente" << endl;
        cout << "5) Salir" << endl;
        cout << "Digite la opcion: ";
        cin >> menu;

        switch (menu)
        {
        case 1:
            r = "";
            while (r != "0") {
                cout << "Introduzca el nombre del objeto (0 para salir)" << endl;
                cout << "- ";
                cin >> r;
                if (r != "0") {
                    objeto.agregarObjeto(r);
                }
            }
            system("pause");
            system("cls");
            break;
        case 2:
            objeto.consultar();
            system("pause");
            system("cls");
            break;
        case 3:
            cout << "Guardando BC..." << endl;
            system("pause");
            system("cls");
            break;
        case 4:
            cout << "Usando una BC existente..." << endl;
            system("pause");
            system("cls");
            break;
        default:
            if (menu < 1 || menu > 5)
            {
                cout << "Este numero no es valido" << endl;
                system("pause");
                system("cls");

            }
            break;
        }
    }
}
