package bingo;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Bingo {
    protected int bolaMayor;
    protected ArrayList<Integer> bombo;
    protected ArrayList<Integer> bolasExtraidas;
    protected int ultimaBola;
    protected int tamanoCarton;
    protected ArrayList<Carton> cartones;
    protected ArrayList<Carton> cartonesBingo;
    protected boolean finalizado;
    
    public Bingo() {
        this.bombo = new ArrayList<>();
        for( int i=1;i<=bolaMayor;i++){
            bombo.add(i);    
        }
        
        bolasExtraidas = new ArrayList<>();
        cartones = new ArrayList<>();
        cartonesBingo = new ArrayList<>();
        this.ultimaBola = 0;
        finalizado = false;
    }
    public Carton generarUnCarton(){
        ArrayList<Integer> numerosPosibles = new ArrayList<>();
        ArrayList<Integer> numeros = new ArrayList<>();
        Carton o;
        do{
            for( int i=1;i<=bolaMayor;i++){
                numerosPosibles.add(i);    
            }
            Collections.shuffle(numerosPosibles);
            for( int i=1;i<=tamanoCarton;i++){
                numeros.add(numerosPosibles.get(i));
            }
            o = new Carton(numeros);
            System.out.println(o.toString());
        }while(aceptable(o) && cartones.contains(o));
        cartones.add(o);
        return o;
    }
    public abstract boolean aceptable(Carton o);
    public int girar(){
        Collections.shuffle(bombo);
        ultimaBola = bombo.get(0);
        bolasExtraidas.add(bombo.get(0));
        bombo.remove(0);
        for(int i = 0; i<cartones.size();i++){
            if(cartones.get(i).comprobar(bolasExtraidas)){
                cartonesBingo.add(cartones.get(i));
                this.finalizado = true;
            }
        }
        return ultimaBola;
    }

    public int getBolaMayor() {
        return bolaMayor;
    }

    public ArrayList<Integer> getBombo() {
        return bombo;
    }

    public ArrayList<Integer> getBolasExtraidas() {
        return bolasExtraidas;
    }

    public int getUltimaBola() {
        return ultimaBola;
    }

    public int getTamanoCarton() {
        return tamanoCarton;
    }

    public ArrayList<Carton> getCartonesBingo() {
        return cartonesBingo;
    }
    
}
