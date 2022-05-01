#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Sep  9 11:37:36 2021

@author: rosasantana
"""

from reportlab.pdfgen import canvas #Libreria instalada desde la consola/ comando -> pip install reportlab


nom = input("Ingresa tu nombre: ")#se esta guardando con el nombre del usuario el archivo pdf
diagnostico = canvas.Canvas(nom+".pdf") 
#tipo de letra
diagnostico.setFont("Times-Roman", 20)
diagnostico.setFillColor("red")
diagnostico.drawString(220, 790, "Diagnostico Médico")
diagnostico.setFont("Times-Roman", 12)
#Color de letra, debe ir antes del texto que elijamos con ese color
diagnostico.setFillColor("blue")
# los primeros dos parametros son posiciones en x & y la coordenada (0,0) esta en la parte inferior derecha, es para escribir una sola linea
diagnostico.drawString(50,750,"La ciudadana con el nombre de " + nom); 
diagnostico.setFillColor("green")
#agregar imagenes, hay que poner la ruta si la imagenes no se encuentra en la carpeta del archivo .py, los sig dos parametros son la posicion en x & y 
#con width y heigth el tamaño de la imagen
diagnostico.drawImage("yoda.jpeg",500, 750, width=20, height=20)
#agrega la separacion de una linea
diagnostico.line(50,700,500,700)
#se crea un objeto para manejar el texto, acepta el salgo de linea
tratamiento = diagnostico.beginText(100, 500)
tratamiento.setFont("Times-Roman", 12)
tratamiento.textLines("El tratamiento que de debe seguir es el siguiente: \n Comer Frutas y verduras")
diagnostico.drawText(tratamiento)
diagnostico.save()


