/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;


/**
 *
 * @author David Botello
 */
public class twitterConexion 
{
    
   private String consumerKeyStr;
    private String consumerSecretStr;
    private String accessTokenStr;
    private String accessTokenSecretStr;
    private OAuthConsumer oAuthConsumer;
    /**
     * Metodo invocado por la capa modelo para establecer la conexion con la cuenta de Twitter segun los parametros
     * generados en la pagina twitter developer para manipular la cuenta desde la aplicacion en Java
     * @return Twitter
     */   
    
    public twitterConexion(){};
    
    public twitterConexion(String consumerKeyStr, String consumerSecretStr, String accessTokenStr, String accessTokenSecretStr)
    {
        this.consumerKeyStr = consumerKeyStr;
        this.consumerSecretStr = consumerSecretStr;
        this.accessTokenStr = accessTokenStr;
        this.accessTokenSecretStr = accessTokenSecretStr;  
    }

    public OAuthConsumer getOAuthConsumer() {
        consumerKeyStr = "OzEDI6OSX2PqYtws1tR7rFUpp";
        consumerSecretStr = "71cux8lGFmeqhWbbdOuQopox4O4awQF6bKE0iyrVs3RvClkbhg";
        accessTokenStr = "850735731677040640-DbjD7e6TW7Iz1t8xiL1jqTUmAIAJbT3";
        accessTokenSecretStr = "rQwKukt6fQ8bqDz3OPaKa5wstRw5ND42nbw9caGuqK3WO";
        
        this.oAuthConsumer = new CommonsHttpOAuthConsumer(consumerKeyStr,consumerSecretStr);
        this.oAuthConsumer.setTokenWithSecret(accessTokenStr, accessTokenSecretStr);
        return this.oAuthConsumer;
    }
}
