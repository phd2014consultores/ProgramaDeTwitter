/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.twitterConexion;
import Controlador.Utilitaria;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author David Botello
 */
public class Twit 
{
    // region atributos
    private String _mensaje;
 //   private date _fecha;
    private byte _media;
    private int _id;
    private twitterConexion conexion;
    
    // end region atributos
    


    // region metodos
    /**
     * El metodo updateTwit se encarga de postear un nuevo tweet 
     * @param mensaje parametro que recibe el mensaje escrito por 
     * en la ventana, se utiliza un web service rest, tomado de la 
     * pagina twitter developer
     */
     
   public void updateTwit(String mensaje)
    {
        
     try 
     {
            // TODO code application logic here
            this.conexion = new twitterConexion();
            OAuthConsumer oAuthConsumer = this.conexion.getOAuthConsumer();
            
            HttpPost httpPost = new HttpPost("https://api.twitter.com/1.1/statuses/update.json?status="+Utilitaria.espacioBlancosAPorcentaje20(mensaje));
            
            oAuthConsumer.sign(httpPost);
            HttpClient httpClient = new DefaultHttpClient();
            HttpResponse httpResponse = httpClient.execute(httpPost);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            System.out.println(httpResponse.getStatusLine().getReasonPhrase());
            System.out.println(statusCode + ':' + httpResponse.getStatusLine().getReasonPhrase());
            System.out.println(IOUtils.toString(httpResponse.getEntity().getContent()));
     } 
     catch (Exception ex) 
     {
        
     }
    
    }
    
    /**
     * Metodo Showtwit se encarga de devolver la conexion establecida a la cuenta de twitter 
     * @return Twitter, tipo de dato que contiene la informacion recogida de la cuanta de twitter 
     */
    public JSONArray showTwit()
    {
       
        try 
        {
            this.conexion = new twitterConexion();
            OAuthConsumer oAuthConsumer = this.conexion.getOAuthConsumer();
            
            //Se coloca 200 en el parametro count, ta que es el maximo de registro que permite twitter consultar
            //de no colocarse el parametro count, twitter retorna por defecto 20 registros
            HttpGet httpget = new HttpGet("https://api.twitter.com/1.1/statuses/home_timeline.json?count=50");
            oAuthConsumer.sign(httpget);
            HttpClient httpClient = new DefaultHttpClient();    
            HttpResponse httpResponse = httpClient.execute(httpget);

           
            BufferedReader br = new BufferedReader( new InputStreamReader((httpResponse.getEntity().getContent())));
            String output;
            StringBuffer result = new StringBuffer();

            while ((output = br.readLine()) != null)
            {
	      result.append(output);
	    }
          System.out.println(result.toString());
         return new JSONArray(result.toString());
                
        } 
        catch (Exception ex)
        {
           
        }
        return null;
    }
    
    // end region metodos
    
    
    // region get y set
    public String getMensaje() {
        return _mensaje;
    }

    public void setMensaje(String _mensaje) {
        this._mensaje = _mensaje;
    }
/*
    public Date getFecha() {
        return _fecha;
    }

    public void setFecha(Date _fecha) {
        this._fecha = _fecha;
    }
*/
    public byte getMedia() {
        return _media;
    }

    public void setMedia(byte _media) {
        this._media = _media;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }
    
    // end region get y set
    
}
