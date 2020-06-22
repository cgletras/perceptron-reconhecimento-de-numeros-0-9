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
public class Aprendizagem {
    
    private double x[][]={{1,1,1,1},{1,1,1,0},{1,1,0,1},{1,1,0,0},
                          {1,0,1,1},{1,0,1,0},{1,0,0,1},{1,0,0,0}};
    private double w[]={0,0,0,0};
    private double t[]={1,-1,-1,-1,-1,-1,-1,-1};
    private int epocas;
        
    public Aprendizagem(){  
        epocas=0;
    }
    
    public double [] getw(){
        return w;
    }
    
    public double [] gett(){
        return t;
    }    
    
    public int getepocas(){
        return epocas;
    }
    
    public double somatorio(int i){
        double yent=0;        
        for(int j=0;j<x[0].length;j++)
                yent = yent + x[i][j]*w[j];
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
    
    public void atualiza(double alfa, double f, int i){
        for(int j=0; j<x[0].length; j++)
            w[j] = w[j] + alfa * (t[i]-f) * x[i][j];
    }
    
    public double [] algoritmo(double alfa, double limiar){
       double yent, f;
       boolean mudou;       
       
       do{
           mudou=false;
           for(int i=0;i<x.length;i++){
              yent = somatorio(i);
              f=saida(yent,limiar);
              if(f != t[i]){                  
                  atualiza(alfa,f,i);
                  mudou=true;
              }
           }      
           epocas++;
       }while(mudou==true);      
       return w;
    }  
    
}
