import tkinter as tk
from tkinter import ttk

class App(tk.Tk):
    
    def mostrar_precio(self, *args):
        self.precio['text'] = f'$ {self.categoria_seleccionada.get()}'

    def __init__(self):
        super().__init__()
        self.title('Inscríbete')

        # Opciones para optionMenus
        self.categorias = ("Infantil", "Aficionado", "Avanzado", "Libre")
        self.generos = ("Hombre", "Mujer")

        # Variables
        self.categoria_seleccionada = tk.StringVar(self)
        self.genero_seleccionado = tk.StringVar(self)

        # crear widgets
        # self.create_wigets()
    

    def create_wigets(self):
        # padding for widgets using the grid layout
        paddings = {'padx': 5, 'pady': 5}

        # label
        ttk.Label(self, text="Torneo de comida!").grid(column=1, row=0)
        ttk.Label(self, text="Nombre: ").grid(column=0, row=1)
        ttk.Entry(self).grid(column=1, row=1)
        ttk.Label(self, text="Apellido: ").grid(column=0, row=2)
        ttk.Entry(self).grid(column=1, row=2)
        ttk.Label(self, text="Sexo: ").grid(column=0, row=3)
        genero = ttk.OptionMenu(
            self,  variable=self.genero_seleccionado, values=self.generos).grid(column=1, row=3)
        
        ttk.Label(self, text="Dirección").grid(column=1, row=6, pady=8)
        ttk.Label(self, text="Estado:").grid(column=0, row=7)
        ttk.Entry(self).grid(column=1, row=7)
        ttk.Label(self, text="Ciudad:").grid(column=0, row=8)
        ttk.Entry(self).grid(column=1, row=8)
        ttk.Label(self, text="Colonia:").grid(column=0, row=9)
        ttk.Entry(self).grid(column=1, row=9)
        ttk.Label(self, text="Código postal:").grid(column=0, row=10)
        ttk.Entry(self).grid(column=1, row=10)
        ttk.Label(self, text="Calle:").grid(column=0, row=11)
        ttk.Entry(self).grid(column=1, row=11)
        ttk.Label(self, text="Número").grid(column=0, row=12)
        ttk.Entry(self).grid(column=1, row=12)
        ttk.Label(self, text="CURP:").grid(column=0, row=13, pady=8)
        ttk.Entry(self).grid(column=1, row=13)
        ttk.Label(self, text="¿Eres estudiante?").grid(column=1, row=14, pady=3)
        ttk.Label(self, text="Ingresa tu escuela: ").grid(column=0, row=15)
        ttk.Entry(self).grid(column=1, row=15)
        ttk.Label(self, text="Categoría: ").grid(column=0, row=16, pady=3)
        categoria = ttk.OptionMenu(
            self,  variable=self.categoria_seleccionada, values=self.categorias)
        categoria.grid(column=1, row=16, sticky='ew')

        ttk.Label(self, text="Costo inscripción: ").grid(column=0, row=17, pady=4)
        precio = ttk.Label(self,foreground='blue').grid(column=0, row=18, pady=4)
        ttk.Button(self, text="Quit", command=self.destroy).grid(column=2, row=19)


if __name__ == "__main__":
    app = App()
    app.create_wigets()
    app.mainloop()



