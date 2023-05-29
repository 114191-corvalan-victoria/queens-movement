package ar.edu.utn.frc.tup.lciii;

import java.util.List;
import java.util.stream.StreamSupport;
import java.util.*;

public class Queen {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */
    public Integer queensAttack(Integer n, Integer k, Integer r_q, Integer c_q, List<List<Integer>> obstacles) {
        // Write your code here
        int contador=0;
        int[] distancias={
                c_q-1, //izquierda
                Math.min(n-r_q,c_q-1), //izquierda arriba
                n-r_q, //arriba
                Math.min(n-r_q,n-c_q), //derecha arriba
                n-c_q, //derecha
                Math.min(r_q-1,n-c_q), //derecha abajo
                r_q-1, //abajo
                Math.min(r_q-1,c_q-1) //izquierda abajo

        };

        for(int i=0; i<k; i++)
        {
            int r = obstacles.get(i).get(0);
            int c = obstacles.get(i).get(1);
            int dist_r = r-r_q;
            int dist_c = c-c_q;
            if(dist_r>0){
                if(dist_c==-dist_r){
                    distancias[1] = Math.min(distancias[1],dist_r-1); //izquierda arriba
                }else if(dist_c == 0){
                    distancias[2] = Math.min(distancias[2],dist_r-1); //arriba
                }else if(dist_c == dist_r){
                    distancias[3] = Math.min(distancias[3],dist_r-1); //derecha arriba
                }
            }else if(dist_r == 0){
                if(dist_c>0){
                    distancias[4] = Math.min(distancias[4],dist_c-1);  //derecha
                }else{
                    distancias[0] = Math.min(distancias[0],-dist_c-1); //izquierda
                }
            }else{
                if(dist_c == -dist_r){
                    distancias[5] = Math.min(distancias[5],-dist_r-1);//derecha arriba
                }else if(dist_c ==0){
                    distancias[6] = Math.min(distancias[6],-dist_r-1);//abajo
                }else if(dist_c == dist_r){
                    distancias[7] = Math.min(distancias[7],-dist_r-1);//izquierda abajo
                }
            }
        }
        for(int dist:distancias){
            contador += dist;
        }

        return contador;
    }

}






