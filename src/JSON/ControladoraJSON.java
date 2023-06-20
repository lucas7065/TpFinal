package JSON;

import Jugador.ControladoraUsuario;
import Jugador.Usuario;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import org.json.JSONException;

public class ControladoraJSON {
    public static ControladoraUsuario leerArchivo() {
        String json_response =ConsumoAPI.getInfo("https://jsonplaceholder.typicode.com/users%22");
        ControladoraUsuario cu=new ControladoraUsuario();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            JSONArray jsonArray= new JSONArray(json_response);
            for(int i=0; i< jsonArray.length(); i++ ) {
                JSONObject jsonObject = new JSONObject();
                jsonObject = jsonArray.getJSONObject(i);
                Usuario usuario = new Usuario();
                usuario.setNombreDeUsuario(jsonObject.getString("username"));
                usuario.setNombre(jsonObject.getString("name"));
                usuario.setEmail(jsonObject.getString("email"));
                System.out.println(usuario.toString());
                cu.registrarUsuario(usuario);
            }
        }
        catch (JSONException exception) {
            System.out.println("JSON mal formado "+exception.getMessage());
        }
        return cu;
    }
}
