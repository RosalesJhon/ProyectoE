import tkinter as tk
from tkinter import messagebox
from tkinter.font import BOLD
from tkinter import ttk, messagebox
from PIL import ImageTk, Image
import sqlite3
from cryptography.fernet import Fernet

class Verificar:
    def __init__(self):
        self.datos = [
            {"ID":"admin","CONTRA":"1234"}
        ]
    
    def ventana_principal(self):
        ventana = tk.Tk()
        ventana.geometry('{}x{}+{}+{}'.format(400, 200, 750, 300))
        ventana.title("Verificar")
        ventana.resizable(0,0)
        ventana.config(bg='#fcfcfc')
        verif_label = tk.Label(text="VERIFICAR TRABAJADOR",font=('Times',13))
        verif_label.config(bg='#fcfcfc')
        verif_label.place(x=100,y=20)

        image = Image.open("./images.png")
        image = image.resize((70, 68))
        photo = ImageTk.PhotoImage(image)
        img_label = tk.Label(image=photo)
        img_label.place(x=10,y=0)

        image1 = Image.open("./descarga.jpg")
        image1 = image1.resize((70, 68))
        photo1 = ImageTk.PhotoImage(image1)
        img_label1 = tk.Label(image=photo1)
        img_label1.place(x=310,y=0)

        id_label = tk.Label(text="USUARIO",font=('Times', 13))
        id_label.config(bg='#fcfcfc')
        id_label.place(x=50,y=70)
        pass_label = tk.Label(text="CONTRASEÑA",font=('Times', 13))
        pass_label.config(bg='#fcfcfc')
        pass_label.place(x=50,y=100)

        id_usuario = tk.Entry(highlightbackground = "black", highlightcolor= "blue", highlightthickness=1,width=30,justify="center",font=('Times', 10))
        contrasena = tk.Entry(highlightbackground = "black", highlightcolor= "blue", highlightthickness=1,width=30, show="*",justify="center",font=('Times', 10))
        id_usuario.place(x=165,y=70)
        contrasena.place(x=165,y=100)

        def verificar_usuario():
            id_user = id_usuario.get()
            contrase = contrasena.get()
            
            encontrado = False
            
            if id_user == "admin" and contrase == "1234":
                messagebox.showinfo("info","usuario admin")
                
                for widget in ventana.winfo_children():
                    widget.destroy()
                image2 = Image.open("./users.jpg")
                image2 = image2.resize((400, 200))
                photo2 = ImageTk.PhotoImage(image2)
                img_label2 = tk.Label(ventana, image=photo2)
                img_label2.image = photo2  # Evita que la imagen se borre automáticamente
                img_label2.place(x=0, y=0)
                
                def ver():
                    ven = tk.Tk()
                    ven.geometry('{}x{}+{}+{}'.format(300, 300, 750, 300))
                    ven.resizable(0,0)
                    ven.config(bg='#fcfcfc')
                    
                    users = tk.Label(ven,text="          ID          CONTRASEÑA          ",font=("Arial", 14))
                    users.place(x=0,y=0)
                    users.config(bg='skyblue')
                    
                    y = 30
                    for us in self.datos: 
                        users = tk.Label(ven,text="\n{}".format(us["ID"]),font=("Arial", 12))
                        users.place(x=40,y=y)
                        users.config(bg='#fcfcfc')

                        pwd = tk.Label(ven,text="\n{}".format(us["CONTRA"]),font=("Arial", 12))
                        pwd.place(x=170,y=y)
                        pwd.config(bg='#fcfcfc')
                        y += 50
                        if y >= 300:
                            ven.geometry('{}x{}+{}+{}'.format(300, 600, 750, 300))
                        
                    ven.mainloop()
                        
                def seguir ():
                    ventana.destroy()

                def salir():
                    ventana.destroy()
                    
                boton_ver = tk.Button(ventana,text="ver usuarios",width=15,height=1,bg='blue', bd=0,fg="white",command=ver,font=("bold"),activebackground="#00FF00", highlightbackground="black")
                boton_ver.place(x=180,y=40)
                boton_seguir = tk.Button(ventana,text="ver app",width=15,height=1,bg='blue', bd=0,fg="white",command=seguir,font=("bold"),activebackground="#FFFF00", highlightbackground="black")
                boton_seguir.place(x=180,y=90)
                boton_salir = tk.Button(ventana,text="salir",width=15,height=1,bg='blue', bd=0,fg="white",command=salir,font=("bold"),activebackground="#FF0000", highlightbackground="white")
                boton_salir.place(x=180,y=140)

            else:
                for u in self.datos:
                    if id_user == u['ID'] and contrase == u['CONTRA']:
                        encontrado = True
                        break
                
                if encontrado:
                    mensaje = messagebox.askokcancel("Éxito", "Usuario encontrado")
                    if mensaje ==True:
                        ventana.destroy()
                        ventana.mainloop()
                else:
                    messagebox.showerror("Error", "Usuario no encontrado")

        ok_boton = tk.Button(text="OK", width=10,bg='cyan', bd=0,fg="black", command=verificar_usuario,font=('Times'),activebackground="#00FF00", highlightbackground="black")
        ok_boton.place(x=80,y=150)

        def agregar_usuario():
            ventana_nueva = tk.Toplevel(ventana)
            ventana_nueva.geometry('{}x{}+{}+{}'.format(400, 200, 750, 300))
            ventana_nueva.title("AÑADIR TRABAJADOR")
            ventana_nueva.config(bg='#fcfcfc')

            image2 = Image.open("./robot.jpg")
            image2 = image2.resize((70, 68))
            photo2 = ImageTk.PhotoImage(image2)
            img_label2 = tk.Label(ventana_nueva, image=photo2)
            img_label2.image = photo2  # Evita que la imagen se borre automáticamente
            img_label2.place(x=10, y=120)

            image2 = Image.open("./im2.jpg")
            image2 = image2.resize((70, 68))
            photo2 = ImageTk.PhotoImage(image2)
            img_label2 = tk.Label(ventana_nueva, image=photo2)
            img_label2.image = photo2  # Evita que la imagen se borre automáticamente
            img_label2.place(x=310, y=0)

            titulo = tk.Label(ventana_nueva, text="ANADIR TRABAJADOR",font=('Times',13))
            titulo.place(x=130, y=20)
            titulo.config(bg='#fcfcfc')

            id_label = tk.Label(ventana_nueva, text="CREAR ID",font=('Times',13))
            id_label.place(x=40,y=60)
            id_label.config(bg='#fcfcfc')
            pass_label = tk.Label(ventana_nueva, text="CREAR CONTRA",font=('Times',13))
            pass_label.place(x=40,y=90)
            pass_label.config(bg='#fcfcfc')

            id_usuario_nuevo = tk.Entry(ventana_nueva,highlightbackground = "black", highlightcolor= "blue", highlightthickness=1, width=30,justify="center")
            contrasena_nueva = tk.Entry(ventana_nueva,highlightbackground = "black", highlightcolor= "blue", highlightthickness=1, width=30, show="*",justify="center")
            id_usuario_nuevo.place(x=170,y=60)
            contrasena_nueva.place(x=170,y=90)

            chek = tk.BooleanVar()

            box = tk.Checkbutton(ventana_nueva, text="No soy un robot",font=("bold"), variable=chek)
            box.place(x=160,y=120)
            box.config(bg='#fcfcfc')

            def guardar_usuario():
                id_usuario_t = id_usuario_nuevo.get()
                contrasena_t = contrasena_nueva.get()
                
                key = Fernet.generate_key()
                fernet = Fernet(key)
                
                encypted_pwd = fernet.encrypt(contrasena_t.encode('utf-8'))
                desencypted_pwd = fernet.decrypt(encypted_pwd).decode('utf-8')

                conn = sqlite3.connect('TKINTER_ID.db')
                cursor = conn.cursor()

                cursor.execute('''CREATE TABLE IF NOT EXISTS usuarios(id INTEGER PRIMARY KEY AUTOINCREMENT,user_id TEXT , contraseña TEXT)''')

                def resgistrar(id_us,cont):
                    cursor.execute('''INSERT INTO usuarios(user_id, contraseña) VALUES (?,?)''',(id_us,cont))
            
                    conn.commit()

                id_us = id_usuario_t
                cont = encypted_pwd

                resgistrar(id_us,cont)
                conn.close()

                if chek.get() == 1:
                    print("\nexito al crear id y contraseña\n")
                    self.registrar_usuario(id_usuario_t, contrasena_t)
                    messagebox.showinfo("Éxito", "Usuario registrado")
                    print('ID: '+id_usuario_t)
                    print('CONTRA: '+contrasena_t)
                    print("La contraseña desencryptada es: "+desencypted_pwd)
                    ventana_nueva.destroy()
                else:
                    messagebox.showwarning("info","checkbox no marcado")
                    return

            boton_guardar = tk.Button(ventana_nueva, text="Guardar", width=10,bg='#00FF00', bd=0,fg="black", command=guardar_usuario,font=("bold"),activebackground="#FFFF00", highlightbackground="black")
            boton_guardar.place(x=160,y=150)

        boton_agregar = tk.Button(text="AÑADIR", width=10,bg='cyan', bd=0,fg="black", command=agregar_usuario,font=("bold"),activebackground="#00FF00", highlightbackground="black")
        boton_agregar.place(x=220,y=150)

        ventana.mainloop()

    def registrar_usuario(self, id_usuario, contrasena):
        self.datos.append({"ID": id_usuario, "CONTRA": contrasena})
        
verificador = Verificar()
verificador.ventana_principal()