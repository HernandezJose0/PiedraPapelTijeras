import java.util.Scanner;

public class Supervivencia {
    private int sets, vidas = 3, ronda=0, derrotas = 0, setsA;
    public Supervivencia(int sets) throws Exception{
        if(sets % 2 == 0) throw new Exception("El número de sets debe ser impar");
        this.sets = sets;
        setsA = sets;
    }

    public int getSetsA() {
        return setsA;
    }

    public int Set(int seleccion) throws Exception {
        Resultado r = new Resultado(seleccion);
        r.seleccionPC();
        System.out.println(r.Veredicto());
        if (r.Veredicto() == "Derrota") ++derrotas;
        if (r.Veredicto() == "Empate") ++setsA;
        --setsA;
        return derrotas;
    }

    public int Ronda(int derrotas) throws Exception {
            if (derrotas > sets/2) --vidas;
            else ++ronda;
            this.derrotas = 0;
            setsA = sets;
        return ronda;
    }

    public boolean Vidas(){
        System.out.println("Vidas: "+vidas);
        if (vidas <= 0) return false;
        else return true;
    }
    public static void main(String[] args){//Los System.ou.println se deben adaptar a la interfaz grafica
        Scanner leer = new Scanner(System.in);
        int n,s,r=0;
        System.out.println("Sets: ");
        n = leer.nextInt();//El valor se dará por el botón
        try{
            Supervivencia su = new Supervivencia(n);
            while (su.Vidas()){
                int d = 0;
                System.out.println("Ronda: "+r);
                while(n > 0){
                    System.out.println("seleccion: ");
                    s = leer.nextInt();//El valor se dará por el botón
                    d = su.Set(s);
                    n = su.getSetsA();
                }
                System.out.println("Derrotas: "+d);
                r = su.Ronda(d);
                n = su.getSetsA();
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }

    }

}
