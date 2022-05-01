import tkinter as tk
from tkinter import ttk
from tkinter.messagebox import showinfo
# from docx import Document
# from docx.shared import Cm
# from docx.enum.text import WD_ALIGN_PARAGRAPH
# from reportlab.pdfgen import canvas
# from reportlab.lib.pagesizes import A4
from functools import partial
import os

# --------Inscripciones------------
root = tk.Tk(className='Inscríbete')
frm = ttk.Frame(root, padding=10)
generos = ("hombre","mujer")
# Variables
genero_seleccionado = tk.StringVar()
categoria_seleccionada = tk.StringVar()
nombre = tk.StringVar()
apellido = tk.StringVar()
estado = tk.StringVar()
ciudad = tk.StringVar()
colonia = tk.StringVar()
cp = tk.StringVar()
calle = tk.StringVar()
numero = tk.StringVar()
curp = tk.StringVar()
escuela = tk.StringVar()
bdd = []
user_data_temp = []

name = ""
lastname = ""
genre = ""
state = ""
city = ""
col = ""
code = ""
street = ""
number = ""
c = ""
school = ""
category = ""
precio = ""

#Funciones    
def save_data():
    """ callback when the suscribe button clicked
    """
    name = f'{nombre.get()}'
    lastname = f'{apellido.get()}'
    genre = f'{genero_seleccionado.get()}'
    state = f'{estado.get()}'
    city = f'{ciudad.get()}'
    col = f'{colonia.get()}'
    code = f'{cp.get()}'
    street = f'{calle.get()}'
    number = f'{numero.get()}'
    c = f'{curp.get()}'
    school = f'{escuela.get()}'
    category = f'{categoria_seleccionada.get()}'
    precio = ""

    if(category == "Infantil"):
        precio = "10"
    elif(category == "Aficionado"):
        precio = "50"
    elif(category == "Avanzado"):
        precio = "100"
    elif(category == "Libre"):
        precio = "80"
    user_data_temp = [name, lastname, genre, state, city, col, code, street, number, c, school, category, precio]
    bdd.append(user_data_temp)
    print(user_data_temp)
    print(bdd)

    showinfo(
        title='Inscripción hecha!',
        message=f'Te has inscrito al torneo!'
        # message= f'Tus datos son: {name, lastname, genre, state, city, col, code, street, number, c, school, category} Y pagarás un total de ${precio}MXN'
    )
def show_data():
    #docx, pdf, txt
    pass

frm.grid()
# Titulo 
ttk.Label(frm, text="Torneo de comida!").grid(column=1, row=0)
ttk.Label(frm, text="Nombre: ").grid(column=0, row=1)
txtNombre = ttk.Entry(frm, textvariable=nombre).grid(column=1, row=1)
ttk.Label(frm, text="Apellido: ").grid(column=0, row=2)
txtApellido = ttk.Entry(frm, textvariable=apellido).grid(column=1, row=2)
ttk.Label(frm, text="Sexo: ").grid(column=0, row=3)
genero = ttk.OptionMenu(frm,  genero_seleccionado, "Hombre", "Mujer").grid(column=1, row=3)
ttk.Label(frm, text="Dirección").grid(column=1, row=6, pady=8)

ttk.Label(frm, text="Estado:").grid(column=0, row=7)
txtEstado = ttk.Entry(frm, textvariable=estado).grid(column=1, row=7)
ttk.Label(frm, text="Ciudad:").grid(column=0, row=8)
txtCiudad =ttk.Entry(frm, textvariable=ciudad).grid(column=1, row=8)
ttk.Label(frm, text="Colonia:").grid(column=0, row=9)
txtColonia =ttk.Entry(frm, textvariable=colonia).grid(column=1, row=9)
ttk.Label(frm, text="Código postal:").grid(column=0, row=10)
txtCP = ttk.Entry(frm, textvariable=cp).grid(column=1, row=10)
ttk.Label(frm, text="Calle:").grid(column=0, row=11)
txtCalle = ttk.Entry(frm, textvariable=calle).grid(column=1, row=11)
ttk.Label(frm, text="Número").grid(column=0, row=12)
txtNumero = ttk.Entry(frm, textvariable=numero).grid(column=1, row=12)
ttk.Label(frm, text="CURP:").grid(column=0, row=13, pady=8)
txtCURP = ttk.Entry(frm, textvariable=curp).grid(column=1, row=13)
ttk.Label(frm, text="¿Eres estudiante?").grid(column=1, row=14, pady=3)
ttk.Label(frm, text="Ingresa tu escuela: ").grid(column=0, row=15)
txtEscuela = ttk.Entry(frm, textvariable=escuela).grid(column=1, row=15)
ttk.Label(frm, text="Categoría: ").grid(column=0, row=16, pady=3)
categoria = ttk.OptionMenu(frm,  categoria_seleccionada, "Infantil", "Aficionado", "Avanzado", "Libre").grid(column=1, row=16, sticky='ew')
ttk.Button(frm, text="Inscribirme", command=save_data).grid(column=1, row=19)
# ttk.Button(frm, text="Buscar").grid(column=0, row=19)
ttk.Button(frm, text="Mostrar", command=show_data).grid(column=0, row=19)
ttk.Button(frm, text="Salir", command=root.destroy).grid(column=2, row=19)
root.mainloop()

# --------Reconocimientos-----------
# participantes = []
# participantesNombre = []

# menu = tk.Tk(className='Menu')
# frm2 = ttk.Frame(root, padding=10)
# frm2.grid()

# def buscar(nombre, vista):
#   mostrar = tk.Tk()
#   mostrar.geometry("300x300")
#   mostrar.title("Participante")
#   mostrar.resizable(False, False)
#   mainTitle = Label(mostrar, text = "Participante: ")
#   mainTitle.pack()
#   if nombre in participantesNombre:
#     for dato in participantes:
#       if dato["nombre"] == nombre:
#         nombreLabel = Label(mostrar, text = "Nombre: " + dato["nombre"], fg = "black")
#         nombreLabel.place(x = 100, y = 120)
#         nombreLabel = Label(mostrar, text = "Apellido: " + dato["apellido"], fg = "black")
#         nombreLabel.place(x = 100, y = 150)
#         nombreLabel = Label(mostrar, text = "CURP: " + dato["curp"], fg = "black")
#         nombreLabel.place(x = 100, y = 180)
#         nombreLabel = Label(mostrar, text = "Sexo: " + dato["sexo"], fg = "black")
#         nombreLabel.place(x = 100, y = 210)
#         nombreLabel = Label(mostrar, text = "Categoria: " + dato["categoria"], fg = "black")
#         nombreLabel.place(x = 100, y = 240)      
#   else:
#     nombreLabel = Label(mostrar, text = "No se encontró",  fg = "black")
#     nombreLabel.place(x = 100, y = 120)



# def ventanaBuscar():
#     nombreBuscar = StringVar()
#     def nombre():
#         nombre_info = txtnombre.get()
#         buscar(nombre_info, mostrar)
#     mostrar = tk.Tk()
#     mostrar.geometry("500x200")
#     mostrar.title("Participantes")
#     mostrar.resizable(False, False)
    
#     mainTitle = Label(mostrar, text = "Buscar",)
#     lblnombre = Label(mostrar, text = "Nombre", fg="black")
#     lblnombre.place(x = 140, y = 40)
#     txtnombre = Entry(mostrar, textvariable = nombreBuscar, width = "30")
#     txtnombre.place(x = 130, y = 70)
#     btnmandar = Button(mostrar, width=15, text="Buscar", command=nombre)
#     btnmandar.place(x = 140, y = 100)
#     mainTitle.pack()



# def ventanamostrar():
#     ventana = Tk()
#     ventana.geometry("950x950")
#     ventana.title("Participantes")
#     ventana.resizable(False, False)
#     ventana.config(background = "")

#     #scrollbar = Scrollbar(ventana, orient = HORIZONTAL)
#     scrollbar = Scrollbar(ventana)
#     scrollbar.pack( side = RIGHT, fill = Y )
#     mylist = Listbox(ventana, xscrollcommand = scrollbar.set, width = 155 )
#     for participante in participantes:
#         mylist.insert(END, "\n----------------------")
#         mylist.insert(END, "\nNombre: " + participante["nombre"])
#         mylist.insert(END, "\nApellido: " + participante["apellido"])
#         mylist.insert(END, "\nCURP: " + participante["curp"])
#         mylist.insert(END, "\nSexo: " + participante["sexo"])
#         mylist.insert(END, "\nEdad: " + participante["Edad"])
#         mylist.insert(END, "\nEstado: " + participante["estado"])
#         mylist.insert(END, "\nCiudad: " + participante["ciudad"])
#         mylist.insert(END, "\nColonia: " + participante["colonia"])
#         mylist.insert(END, "\nCodigo Postal: " + participante["cp"])
#         mylist.insert(END, "\nCalle: " + participante["calle"])
#         mylist.insert(END, "\nNumero: " + participante["numero"])
#         mylist.insert(END, "\Escuela: " + participante["Escuela"])
#         mylist.insert(END, "\nCategoria: " + participante["categoria"])

#     mylist.pack( side = LEFT, fill = BOTH )
#     scrollbar.config( command = mylist.yview )

#     mainloop()