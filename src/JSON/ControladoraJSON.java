package JSON;

import Jugador.Usuario;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

    public class ControladoraJSON
    {
        public static ArrayList<Usuario> leerArchivo()
        {
            String json_response =JsonUtiles.leer(ConsumoAPI.getInfo("https://api.api-ninjas.com/v1/randomuser"));

            ArrayList<Usuario> usuarios = new ArrayList<>();
            try
            {
                JSONObject jsonObject = new JSONObject(json_response);
                Usuario usuario = new Usuario();
                usuario.setEmail(jsonObject.getString("email"));
                usuario.setNombre(jsonObject.getString("name"));
                usuario.setFechaNacimiento(jsonObject.getString("birthday"));
                usuario.setNombreDeUsuario(jsonObject.getString("username"));
                System.out.println(usuario.toString());
                usuarios.add(usuario);

            }
            catch (JSONException exception)
            {
                System.out.println("JSON mal formado "+exception.getMessage());
            }
            return usuarios;
        }
        /*
        public static void grabarEnJSON(ArrayList<Personaje> personajeArrayList)
        {
            try
            {
                JSONArray jsonArray = new JSONArray();
                for (Personaje p : personajeArrayList)
                {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("name", p.getName());
                    jsonObject.put("id",p.getId());
                    jsonArray.put(jsonObject);
                }
                System.out.println(jsonArray.toString());
                JsonUtiles.grabar(jsonArray,"miArchivo");
            }
            catch (JSONException ex)
            {
                System.out.println("Me estas mandando un null como clave");
            }
        }
    }*/
}
