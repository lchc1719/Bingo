package bingo;

import java.util.Collections;

public class BingoAmericano extends Bingo{
    public BingoAmericano() {
        super();
        
        bolaMayor = 75;
        tamanoCarton = 25;
    }
    @Override
    public int girar(){
        int bola;
        do{
            Collections.shuffle(bombo);
            bola = ultimaBola;
            ultimaBola = bombo.get(0);
        }while(bola+1 != ultimaBola);
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
    @Override
    public boolean aceptable(Carton o) {
        Integer suma = 0;
        for(int i = 0 ; i < o.getNumeros().size();i++){
            suma += o.getNumeros().get(i);
        }
        suma = suma/o.getNumeros().size();
        return (suma <=50);
    }
}
