/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptronand3entradas;

/**
 *
 * @author Clarimundo
 */
public class Validacao {
    
    public Validacao(){
        
    }
    
    public double somatorio(int usuario[], double w[]){
        double yent=0;        
        for(int j=0;j<usuario.length;j++)
                yent = yent + usuario[j]*w[j];
        return yent;
    }

    public double saida(double yent, double limiar){
        if(yent>limiar)
            return 1;
        else
            if(yent<-limiar)
                return -1;
            else 
                return 0;
    }
    
    public String teste(int usuario[], double w[], double t[], double limiar){
       double yent, f;
              
       yent = somatorio(usuario,w);
       f = saida(yent,limiar);
       return new Integer((int) f).toString();
//       if(t[0]==f)
//           return "1";
//       else
//           return "0";
              
    }             
    
}
