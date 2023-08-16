import tkinter as tk
from tkinter import*
from tkinter import messagebox
from tkinter import ttk, messagebox

class CountdownTimer:
    def __init__(self, master, seconds):
        self.master = master
        self.seconds = seconds
        self.label = tk.Label(master, text=self.seconds, font=("Arial", 24))
        self.label.place(x=80,y=30)
        self.label.config(bg='#fcfcfc')
        self.imp =tk.Label(master,text="IMPRIMIENDO...",font=("Arial", 14))
        self.imp.place(x=30,y=90)
        self.imp.config(bg='#fcfcfc')
        self.update_clock()

    def update_clock(self):
        if self.seconds == 0:

            self.label.config(text="Exito", font=('Times', 14))
            messagebox.showinfo("info","Boleta Imprimida")
            ventana_imp.destroy()
            return
        self.seconds -= 1
        self.label.config(text=self.seconds)
        self.master.after(1000, self.update_clock)

ventana_imp = tk.Tk()
timer = CountdownTimer(ventana_imp, 10)

ventana_imp.geometry('{}x{}+{}+{}'.format(200, 200, 750, 300))
ventana_imp.title("PERFIL")
ventana_imp.resizable(0,0)
ventana_imp.config(bg='#fcfcfc')
ventana_imp.configure(cursor="circle")


ventana_imp.mainloop()