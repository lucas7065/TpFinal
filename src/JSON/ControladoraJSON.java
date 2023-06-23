package JSON;

import Exceptions.NombreDeUsuarioExistenteException;
import Jugador.ControladoraUsuario;
import Jugador.Usuario;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import org.json.JSONException;

public class ControladoraJSON {

        public static ControladoraUsuario leerArchivo()
        {

            String json_response =ConsumoAPI.getInfo("https://jsonplaceholder.typicode.com/users");
            ControladoraUsuario cu=new ControladoraUsuario();
            ArrayList<Usuario> usuarios = new ArrayList<>();
            try
            {
                JSONArray jsonArray= new JSONArray(json_response);
                for(int i=0; i< jsonArray.length(); i++ ) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject = jsonArray.getJSONObject(i);
                    Usuario usuario = new Usuario();
                    usuario.setNombreDeUsuario(jsonObject.getString("username"));
                    usuario.setNombreCompleto(jsonObject.getString("name"));
                    usuario.setEmail(jsonObject.getString("email"));
                    String json_password =ConsumoAPI.getInfo("https://www.psswrd.net/api/v1/password/?length=8&lower=1&upper=0&int=1&special=0");
                    JSONObject password=new JSONObject(json_password);
                    usuario.setPassword(password.getString("password"));
                    //usuario.setPassword("123");
                    try {
                        cu.registrarUsuario(usuario);
                    } catch (NombreDeUsuarioExistenteException e) {
                        System.out.println(e.getMessage());
                    }
                }

            }
            catch (JSONException exception)
            {
                System.out.println("JSON mal formado "+exception.getMessage());
            }
            return cu;
        }




}
