from tkinter import *
from docx import Document
from docx.shared import Cm
from docx.enum.text import WD_ALIGN_PARAGRAPH
from reportlab.pdfgen import canvas
from reportlab.lib.pagesizes import A4
from functools import partial
import docx
import reportlab
participantes = []
participantesNombre = []

menu = Tk()
menu.title("Menu")
ancho_ventana = 400
alto_ventana = 100
x_ventana = menu.winfo_screenwidth() // 2 - ancho_ventana // 2
y_ventana = menu.winfo_screenheight() // 2 - alto_ventana // 2
posicion = str(ancho_ventana) + "x" + str(alto_ventana) + "+" + str(x_ventana) + "+" + str(y_ventana)
menu.geometry(posicion)
menu.resizable(0, 0)

def buscar(nombre, vista):
  mostrar = Tk()
  mostrar.geometry("300x300")
  mostrar.title("Participante")
  mostrar.resizable(False, False)
  mainTitle = Label(mostrar, text = "PARTICIPANTE DEL TORNEO")
  mainTitle.pack()
  if nombre in participantesNombre:
    for dato in participantes:
      if dato["nombre"] == nombre:
        nombreLabel = Label(mostrar, text = "Nombre: " + dato["nombre"], fg = "black")
        nombreLabel.place(x = 100, y = 120)
        nombreLabel = Label(mostrar, text = "Apellido: " + dato["apellido"], fg = "black")
        nombreLabel.place(x = 100, y = 150)
        nombreLabel = Label(mostrar, text = "CURP: " + dato["curp"], fg = "black")
        nombreLabel.place(x = 100, y = 180)
        nombreLabel = Label(mostrar, text = "Sexo: " + dato["sexo"], fg = "black")
        nombreLabel.place(x = 100, y = 210)
        nombreLabel = Label(mostrar, text = "Categoria: " + dato["categoria"], fg = "black")
        nombreLabel.place(x = 100, y = 240)      
  else:
    nombreLabel = Label(mostrar, text = "NO SE ENCONTRO EL PARTICIPANTE",  fg = "black")
    nombreLabel.place(x = 100, y = 120)



def ventanaBuscar():
    nombreBuscar = StringVar()
    def nombre():
        nombre_info = txtnombre.get()
        buscar(nombre_info, mostrar)
    mostrar = Tk()
    mostrar.geometry("500x200")
    mostrar.title("Participantes")
    mostrar.resizable(False, False)
    
    mainTitle = Label(mostrar, text = "BUSCAR COMPETIDOR",)
    lblnombre = Label(mostrar, text = "Nombre", fg="black")
    lblnombre.place(x = 140, y = 40)
    txtnombre = Entry(mostrar, textvariable = nombreBuscar, width = "30")
    txtnombre.place(x = 130, y = 70)
    btnmandar = Button(mostrar, width=15, text="Buscar", command=nombre)
    btnmandar.place(x = 140, y = 100)
    mainTitle.pack()



def ventanamostrar():
    ventana = Tk()
    ventana.geometry("950x950")
    ventana.title("Participantes")
    ventana.resizable(False, False)
    ventana.config(background = "")

    #scrollbar = Scrollbar(ventana, orient = HORIZONTAL)
    scrollbar = Scrollbar(ventana)
    scrollbar.pack( side = RIGHT, fill = Y )
    mylist = Listbox(ventana, xscrollcommand = scrollbar.set, width = 155 )
    for participante in participantes:
        mylist.insert(END, "\n----------------------")
        mylist.insert(END, "\nNombre: " + participante["nombre"])
        mylist.insert(END, "\nApellido: " + participante["apellido"])
        mylist.insert(END, "\nCURP: " + participante["curp"])
        mylist.insert(END, "\nSexo: " + participante["sexo"])
        mylist.insert(END, "\nEdad: " + participante["Edad"])
        mylist.insert(END, "\nEstado: " + participante["estado"])
        mylist.insert(END, "\nCiudad: " + participante["ciudad"])
        mylist.insert(END, "\nColonia: " + participante["colonia"])
        mylist.insert(END, "\nCodigo Postal: " + participante["cp"])
        mylist.insert(END, "\nCalle: " + participante["calle"])
        mylist.insert(END, "\nNumero: " + participante["numero"])
        mylist.insert(END, "\Escuela: " + participante["Escuela"])
        mylist.insert(END, "\nCategoria: " + participante["categoria"])

    mylist.pack( side = LEFT, fill = BOTH )
    scrollbar.config( command = mylist.yview )

    mainloop()


def ventanaRegistro():
    ventana = Toplevel(menu)
    #menu.iconify()
    ventana.title("REGISTRO AL TORNEO DE TKD")
    ancho_ventana = 780
    alto_ventana = 260
    x_ventana = menu.winfo_screenwidth() // 2 - ancho_ventana // 2
    y_ventana = menu.winfo_screenheight() // 2 - alto_ventana // 2
    posicion = str(ancho_ventana) + "x" + str(alto_ventana) + "+" + str(x_ventana) + "+" + str(y_ventana)
    ventana.geometry(posicion)
    ventana.resizable(False, False)


    


    def Registro():
        nombre_info = nom.get()
        apellido_info = ap.get()
        sexo_info = sexo.get()
        edad_info = ed.get()        
        estado_info = estado.get()
        ciudad_info = ciudad.get()
        colonia_info = colonia.get()
        codigoPostal_info = cp.get()
        calle_info = calle.get()
        numero_info = numeroIn.get()
        curp_info = curp.get()
        escuela_info = nomEscuela.get()
        categoria_info = cat.get()
        
        participantes.append({"nombre":nombre_info,"apellido":apellido_info,"curp": curp_info,"sexo": sexo_info,"Edad": edad_info,"estado": estado_info,"ciudad": ciudad_info,"colonia":colonia_info, 
                                "cp": codigoPostal_info,"calle": calle_info,"Escuela": escuela_info,"numero": numero_info,"categoria": categoria_info}) 
        participantesNombre.append(nombre_info)
        ventana.destroy()
        
        
    lblnombre = Label(ventana, text="Ingresa tu nombre: ", fg="black").place(x=10,y=20)
    lblapellidos = Label(ventana, text="Ingresa tus apellidos: ", fg="black").place(x=10,y=40)
    lblsexo = Label(ventana, text="Sexo:", fg="black").place(x=10, y=60)
    lbledad = Label(ventana, text="Edad:", fg="black").place(x=10, y=80)
    lbldireccion= Label(ventana, text="Ingrese Direccion: ", fg="black").place(x=10, y=100)
    lbldireccion = Label(ventana, text="Estado", fg="black").place(x=140, y=120)
    lbldireccion = Label(ventana, text="Ciudad", fg="black").place(x=240, y=120)
    lbldireccion = Label(ventana, text="Colonia", fg="black").place(x=340, y=120)
    lbldireccion = Label(ventana, text="C.P", fg="black").place(x=440, y=120)
    lbldireccion = Label(ventana, text="Calle", fg="black").place(x=540, y=120)
    lbldireccion = Label(ventana, text="Numero Int.", fg="black").place(x=640, y=120)
    lblcurp = Label(ventana, text="Ingresa tu CURP: ", fg="black").place(x=10,y=140)
    lblescuela = Label(ventana, text="Ingresa tu escuela: ", fg="black").place(x=10,y=160)


    nom = StringVar()
    ap = StringVar()
    sexo = StringVar()
    sex = ['Femenino', 'Masculino']
    ed = StringVar()
    estado = StringVar()
    ciudad = StringVar()
    colonia  = StringVar()
    cp = StringVar()
    calle = StringVar()
    numeroIn = StringVar()
    curp = StringVar()
    nomEscuela = StringVar()
    cat = StringVar()
    catalogo =  ["Infantil:  ", "Aficionado:  ", "Avanzado:  ", "Libre:  "]
    Precios =  ["$100", "$200", "$400", "$300"]
    catalogo2 = [catalogo[0] + Precios[0], catalogo[1] + Precios[1], catalogo[2] + Precios[2], catalogo[3] + Precios[3]]


    txtnombre = Entry(ventana,textvariable = nom, width = "40")
    txtapellidosC = Entry(ventana,textvariable=ap)
    cbosexo = Spinbox(ventana, values=sex, textvariable=sexo, state="readonly").place(x=140, y=60)
    cboedad = Spinbox(ventana, from_=9, to=40, textvariable=ed, state="readonly").place(x=140, y=80)
    txtestado = Entry (ventana,textvariable=estado)
    txtciudad = Entry (ventana,textvariable=ciudad)
    txtcolonia = Entry (ventana,textvariable=colonia)
    txtcp = Entry (ventana,textvariable=cp)
    txtcalle = Entry (ventana,textvariable=calle)
    txtnumeroIn = Entry (ventana,textvariable=numeroIn)
    txtcurp = Entry(ventana,textvariable=curp)
    txtescuela = Entry(ventana,textvariable=nomEscuela)
    cbocatalogo = Spinbox(ventana, values=catalogo2, textvariable=cat , state="readonly").place(x=10, y=180)
    
    txtnombre.place(x=140,y=20)
    txtapellidosC.place(x=140,y=40)
    txtestado.place(x=140,y=100)
    txtciudad.place(x=240,y=100)
    txtcolonia.place(x=340,y=100)
    txtcp.place(x=440,y=100)
    txtcalle.place(x=540,y=100)
    txtnumeroIn.place(x=640,y=100)
    txtcurp.place(x=140,y=140)
    txtescuela.place(x=140,y=160)
    

    
    btnregistro = Button(ventana,width=20, height=3, text='Registrar', command=Registro).place(x=440,y=150)


btnRegistro = Button(menu, width=45 , text="Registro", command=ventanaRegistro).place(x=40, y=20)
btnConsultar = Button(menu, width=20, text="Participantes", command=ventanamostrar).place(x=40, y=60)
btnBuscar = Button(menu, width=20, text="Buscar", command=ventanaBuscar).place(x=215, y=60)

menu.mainloop() 
