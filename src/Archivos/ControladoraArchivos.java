package Archivos;
import Jugador.Usuario;

import java.io.*;
import java.util.ArrayList;

public class ControladoraArchivos {
        public static void grabar(ArrayList<Usuario>usuarioArrayList)
        {
            FileOutputStream fileOutputStream = null;
            ObjectOutputStream objectOutputStream = null;

            try
            {
                fileOutputStream = new FileOutputStream("usuarios.dat");
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                for (Usuario persona : usuarioArrayList)
                {
                    objectOutputStream.writeObject(persona);
                }
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }
            finally {
                try {
                    if (fileOutputStream != null)
                        fileOutputStream.close();

                    if (objectOutputStream != null)
                        objectOutputStream.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        }

        public static ArrayList<Usuario> leer(String s)
        {
            ArrayList<Usuario>usuarioArrayList = new ArrayList<>();

            FileInputStream fileInputStream = null;
            ObjectInputStream objectInputStream = null;

            try
            {
                fileInputStream = new FileInputStream("usuarios.dat");
                objectInputStream = new ObjectInputStream(fileInputStream);

                while (true)
                {
                    Usuario aux = (Usuario) objectInputStream.readObject();
                    usuarioArrayList.add(aux);
                }
            }
            catch (EOFException ex)
            {
                System.out.println("FIN de ARCHIVO");
            }
            catch (ClassNotFoundException ex)
            {
                System.out.println(ex.getMessage());
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }
            finally
            {
                try
                {
                    if (fileInputStream!=null)
                        fileInputStream.close();

                    if (objectInputStream!=null)
                        objectInputStream.close();
                }
                catch (IOException ex)
                {
                    System.out.println(ex.getMessage());
                }

            }

            return usuarioArrayList;
        }
    }
