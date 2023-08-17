import tkinter as tk
from tkinter import*
from tkinter import messagebox
import datetime
from tkinter import filedialog
from PIL import Image, ImageTk, ImageDraw, ImageOps
import sqlite3

import verificar

class Trabajador:
    def __init__(self,nombres,categoria,horasextra,tardanzas):
        self.nombres = nombres
        self.categoria = categoria
        self.horasextra = horasextra
        self.tardanzas = tardanzas
        self.soless = []
        
    @classmethod
    def ventana(cls):

        #CREAMOS VENTANA GRAFICA
        ventana = tk.Tk()
        ventana.geometry('{}x{}+{}+{}'.format(400, 400, 750, 300))
        ventana.resizable(0,0)
        
        ventana.title("FERROTEK SAC | APK - POO_PY")
        ventana.config(bg='#fcfcfc')

        #Titulo
        image2 = Image.open("./descarga.png")
        image2 = image2.resize((120, 78))
        photo2 = ImageTk.PhotoImage(image2)
        img_label2 = tk.Label(ventana, image=photo2)
        img_label2.image = photo2  # Evita que la imagen se borre automáticamente
        img_label2.place(x=150, y=5)

        #Campos Y Entrada
        #NOMBRES
        nombres = Label(text="NOMBRES")
        nombres.place(x=40,y=100)
        nombres.config(bg='#fcfcfc')
        entrada_nombre = tk.Entry(width=35,highlightbackground = "black", highlightcolor= "blue", highlightthickness=1,justify="center")
        entrada_nombre.place(x=140,y=100)
        #CATEGORIA
        categoria = Label(text=("CATEGORIA"))
        categoria.place(x=40,y=150)
        categoria.config(bg='#fcfcfc')
        entrada_categoria = tk.Entry(width=35,highlightbackground = "black", highlightcolor= "blue", highlightthickness=1,justify="center")
        entrada_categoria.place(x=140,y=150)
        #HORAS EXTRA
        horas_extra = Label(text="HORAS EXTRA")
        horas_extra.place(x=40,y=200)
        horas_extra.config(bg='#fcfcfc')
        entrada_horas_extra = tk.Entry(width=35,highlightbackground = "black", highlightcolor= "blue", highlightthickness=1,justify="center")
        entrada_horas_extra.place(x=140,y=200)
        #TARDANZAS
        tardanza = Label(text="TARDANZAS")
        tardanza.place(x=40,y=250)
        tardanza.config(bg='#fcfcfc')
        entrada_tardanza = tk.Entry(width=35,highlightbackground = "black", highlightcolor= "blue", highlightthickness=1,justify="center")
        entrada_tardanza.place(x=140,y=250)

        #BOTONES 
        #Boton OK
        #Funcion Boton 1
        def ok():
             #CONVERITR ENTRADAS - ENTRY
            nomb = str(entrada_nombre.get())
            cate = str(entrada_categoria.get())
            horext = float(entrada_horas_extra.get())
            tardan = float(entrada_tardanza.get())
            
            @staticmethod
            def sueldo_basico():
                if cate.lower() == 'a':
                    return 3000
                elif cate.lower() == 'b':
                    return 2500
                elif cate.lower() == 'c':
                    return 2000
                else:
                    return 0
            #SALIDAS
            descuentoportardanza=sueldo_basico()/24*tardan/60
            pagoporhorasextra = sueldo_basico()/24*horext
            sueldoneto = round(sueldo_basico()+pagoporhorasextra-descuentoportardanza,2)

            conn = sqlite3.connect('TKINTER_Trabajadores.db')
            cursor = conn.cursor()

            cursor.execute('''CREATE TABLE IF NOT EXISTS Trabajadores(id INTEGER PRIMARY KEY AUTOINCREMENT,nombres TEXT , categoria TEXT, sueldo_neto DOUBLE)''')

            def resgistrar(nomb,cate,sueldoneto):
                cursor.execute('''INSERT INTO Trabajadores(nombres,categoria,sueldo_neto) VALUES (?,?,?)''',(nomb,cate,sueldoneto))
            
                conn.commit()

            resgistrar(nomb,cate,sueldoneto)
            conn.close()

            #LIMPIAR VENTANA
            for widget in ventana.winfo_children():
                widget.destroy()
            #########SALIDA########
            #Titulo salida
            titulo_salida = Label(ventana,text="BOLETA DE PAGO")
            titulo_salida.place(x=160,y=20)
            titulo_salida.config(bg='#fcfcfc')
            #FECHA Y HORA
            #FECHA
            fecha = datetime.datetime.now().strftime("%d/%m/%Y")
            etiqueta_fecha = tk.Label(ventana, text="" + fecha)
            etiqueta_fecha.place(x=50,y=60)
            etiqueta_fecha.config(bg='#fcfcfc')
            #HORA
            hora = datetime.datetime.now().strftime("%I:%M:%S %p")
            etiqueta_hora = tk.Label(ventana, text=" " + hora)
            etiqueta_hora.place(x=240,y=60)
            etiqueta_hora.config(bg='#fcfcfc')
            #salida nombre
            salida_nombre = Label(ventana,text="NOMBRE \t\t\t"+"| "+nomb)
            salida_nombre.place(x=50,y=100)
            salida_nombre.config(bg='#fcfcfc')
            #salida categoria
            salida_categoria = Label(ventana,text="CATEGORIA \t\t\t"+"| "+cate)
            salida_categoria.place(x=50,y=130)
            salida_categoria.config(bg='#fcfcfc')
            #salida seldo basico
            salida_sueldo_basico = Label(ventana,text="SUELDO BASICO \t\t\t"+"| "+str(round(sueldo_basico(),2)))
            salida_sueldo_basico.place(x=50,y=160)
            salida_sueldo_basico.config(bg='#fcfcfc')

            salida_descuento_tardanza = Label(ventana,text="DESCUENTO TARDANZA \t\t"+"| "+str(round(descuentoportardanza,2)))
            salida_descuento_tardanza.place(x=50,y=190)
            salida_descuento_tardanza.config(bg='#fcfcfc')

            salida_pago_hora = Label(ventana,text="PAGO POR HORAS EXTRA \t\t"+"| "+str(round(pagoporhorasextra,2)))
            salida_pago_hora.place(x=50,y=220)
            salida_pago_hora.config(bg='#fcfcfc')

            salida_sueldo_neto = Label(ventana,text="SUELDO NETO \t\t\t"+"| "+str(round(sueldoneto,2)))
            salida_sueldo_neto.place(x=50,y=250)
            salida_sueldo_neto.config(bg='#fcfcfc')

            def imprimir_boleta():
                
                mensaje = messagebox.askokcancel("INFORMACION","Comenzar Con El Proceso??")
                if mensaje == True:
                    import secon
                    
                elif mensaje == False:
                    ventana.destroy()
                    messagebox.showinfo("INFORMACION","La Tarea Fallo Con Exito")
                    Trabajador.ventana()
                    
            boton_imprimir = tk.Button(text="IMPRIMIR BOLETA",width=20,height=2,bg='magenta', bd=0,fg="white",command=imprimir_boleta)
            boton_imprimir.place(x=70,y=320)

            def perfil():
                ventana.destroy()
                
                ventana_perfil = tk.Tk()
                ventana_perfil.geometry('{}x{}+{}+{}'.format(400, 400, 750, 300))
                ventana_perfil.title("PERFIL")
                ventana_perfil.resizable(0,0)
                ventana_perfil.config(bg='#fcfcfc')

                def exi():
                    ventana_perfil.destroy()
                    Trabajador.ventana()

                boton_atras = tk.Button(text="Salir",width=15,height=2,bg='#FF0000', bd=0,fg="WHITE",command=exi)
                boton_atras.place(x=70,y=340)
                
                #banco falso xd
                def banco():

                    listaa = []
                    listaa = [sueldoneto]
                    listaa[0]

                    def depositar(saldo_a_depositar):

                        listaa[0] += float(saldo_a_depositar)
                        balance_label.configure(text="${:.2f}".format(listaa[0]))

                    def retirar(saldo_a_retirar):
                        
                        if saldo_a_retirar == float(saldo_a_retirar):

                            if listaa[0] >= saldo_a_retirar:
                                listaa[0] -= saldo_a_retirar
                                balance_label.configure(text="${:.2f}".format(listaa[0]))
                            else:
                                saldo_en.delete(0, tk.END)
                                saldo_en.insert(0, "No hay suficiente saldo")
                                messagebox.showwarning("ERROR","Saldo insuficiente. Realiza un depósito")
                        else:
                            messagebox.showwarning("ERROR", "Por favor ingresa un valor numérico")

                    ventana = tk.Tk()
                    ventana.geometry('{}x{}+{}+{}'.format(400, 400, 750, 300))
                    ventana.resizable(0, 0)
                    ventana.title("Banco")
                    ventana.config(bg='#fcfcfc')

                    salir_button = tk.Button(ventana, text="Salir", width=30, height=2,bg='#00FFFF', bd=0,fg="black", command=ventana.destroy)
                    salir_button.place(x=100, y=300)

                    balance_label = tk.Label(ventana, text="${:.2f}".format(listaa[0]), font=("Arial", 24))
                    balance_label.place(x=130, y=40)
                    balance_label.config(bg='#fcfcfc')

                    saldo_en = tk.Entry(ventana, width=30,highlightbackground = "black", highlightcolor= "blue", highlightthickness=1, justify="center")
                    saldo_en.place(x=110, y=120)

                    deposita_button = tk.Button(ventana, text="Depositar", width=30, height=2,bg='#00FF00', bd=0,fg="black", command=lambda: depositar(float(saldo_en.get())))
                    deposita_button.place(x=100, y=180)

                    retira_button = tk.Button(ventana, text="Retirar", width=30, height=2,bg='#FF0000', bd=0,fg="white", command=lambda: retirar(float(saldo_en.get())))
                    retira_button.place(x=100, y=240)

                    ventana.mainloop()

                boton_banco = tk.Button(text="IR A BANCO",width=15,height=2,bg='#0000FF', bd=0,fg="white",command=banco)
                boton_banco.place(x=220,y=340)


                def cargar_imagen():
                    # Lista de extensiones de archivo válidas
                    extensiones_validas = [".jpg", ".jpeg", ".png", ".bmp", ".gif"]

                    # Abre el cuadro de diálogo para seleccionar un archivo
                    ruta_imagen = filedialog.askopenfilename()

                    # Verifica que se haya seleccionado un archivo de imagen válido
                    if not ruta_imagen:
                        return
                    elif not ruta_imagen.endswith(tuple(extensiones_validas)):
                        tk.messagebox.showerror("Error", "Por favor seleccione un archivo de imagen válido.")
                        return
                    try:
                        # Carga la imagen en un objeto Image de PIL
                        imagen_pil = Image.open(ruta_imagen)
                    except:
                        tk.messagebox.showerror("Error", "No se pudo abrir la imagen seleccionada.")
                        return
                    # Crea una máscara circular de la misma dimensión que la imagen
                    mascara = Image.new("L", imagen_pil.size, 0)
                    draw = ImageDraw.Draw(mascara)
                    draw.ellipse((0, 0, imagen_pil.size[0], imagen_pil.size[1]), fill=255)

                    # Aplica la máscara a la imagen
                    imagen_pil.putalpha(mascara)

                    # Escala la imagen para que quepa en el widget
                    imagen_pil = imagen_pil.resize((100, 100), Image.ANTIALIAS)

                    # Crea un objeto ImageTk de Tkinter a partir de la imagen de PIL
                    imagen_tk = ImageTk.PhotoImage(imagen_pil)
                    etiqueta_imagen = tk.Label()
                    etiqueta_imagen.pack()
                    etiqueta_imagen.config(bg='#fcfcfc')
                    # Actualiza la etiqueta con la imagen cargada
                    etiqueta_imagen.configure(image=imagen_tk)
                    etiqueta_imagen.image = imagen_tk

                    # Muestra un mensaje de éxito
                    tk.messagebox.showinfo("Éxito", "La imagen se cargó correctamente.")

                boton_cargar = tk.Button(text="Cargar imagen", command=cargar_imagen)
                boton_cargar.place(x=160,y=120)

                bol = Label(text="__________DATOS__________")
                bol.place(x=140,y=165)
                bol.config(bg='#fcfcfc')

                dato_nombre = Label(text="NOMBRES\t\t\t"+"| "+nomb)
                dato_nombre.place(x=80,y=210)
                dato_nombre.config(bg='#fcfcfc')

                dato_cate = Label(text="CATEGORIA\t\t\t"+"| "+cate)
                dato_cate.place(x=80,y=250)
                dato_cate.config(bg='#fcfcfc')

                dato_id = Label(text="SUELDO\t\t\t\t"+"| "+str(round(sueldoneto,2)))
                dato_id.place(x=80,y=290)
                dato_id.config(bg='#fcfcfc')

                ventana_perfil.mainloop()

            bton_perfil = tk.Button(text="VER PERFIL",width=20,height=2,bg='#00FFFF', bd=0,fg="black",command=perfil)
            bton_perfil.place(x=220,y=320)

            ventana.bind('<Return>', lambda event=None: boton_imprimir.invoke())

        boton_ok = tk.Button(text="OK",width=10,height=1,bg='#00FF00', bd=0,fg="black",command=ok,font=("bold"))
        boton_ok.place(x=50,y=320)
        #Boton Salir
        #Funcion Boton 2
        def salir():
            ventana.destroy()

        boton_salir = tk.Button(text="SALIR",width=10,height=1,bg='#FF0000', bd=0,fg="black",command=salir,font=("bold"))
        boton_salir.place(x=220,y=320)

        ventana.bind('<Return>', lambda event=None: boton_ok.invoke())
        ventana.mainloop()
Trabajador.ventana()