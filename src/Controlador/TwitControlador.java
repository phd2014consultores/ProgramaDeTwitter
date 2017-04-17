/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Twit;
import org.json.JSONArray;
import twitter4j.Twitter;
/**
 *
 * @author David Botello
 */
public class TwitControlador 
{
   private Twit tweet;

    public TwitControlador() 
    {
        this.tweet = new Twit();
    }
   
   
   /**
    * @param mensaje parametro que contiene el mensaje escrito en la ventana del programa
    * este metodo se encarga de invocar el metodo en la capa modelo cumpliendo con la arquitectura MVC
    */
    
   public void updateTwit(String mensaje)
   {
     this.tweet.updateTwit(mensaje);
   }
   /**
    * Metodo que se encarga de invocar en la capa modelo el metodo para devolver los tweets
    * @return Twitter tipo de dato que contiene la informacion generada en Twitter
    */
    public JSONArray showTwit()
    {
      return this.tweet.showTwit();
    }
}
