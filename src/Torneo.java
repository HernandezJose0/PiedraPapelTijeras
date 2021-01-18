import java.util.Scanner;

public class Torneo {
    private int sets = 5, ronda=1, derrotas = 0, setsA=5, oponentes;
    public Torneo(int participantes) throws Exception{
        oponentes = participantes;
    }

    public int getSetsA() {
        return setsA;
    }

    public int getOponentes() {
        return oponentes;
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
            if (derrotas < 3){
                oponentes--;
                ++ronda;
            }
            this.derrotas = 0;
            setsA = sets;
            return ronda;
        }

        public static void main(String[] args){//Los System.ou.println se deben adaptar a la interfaz grafica
            Scanner leer = new Scanner(System.in);
            int n,s,r=1;
            System.out.println("Oponentes: ");
            n = leer.nextInt();//El valor se dará por el botón
            try{
                Torneo t = new Torneo(n);
                int v = t.getOponentes();
                while (v > 0){
                    int d = 0;
                    System.out.println("Ronda: "+r);
                    while(n > 0){
                        System.out.println("seleccion: ");
                        s = leer.nextInt();//El valor se dará por el botón
                        d = t.Set(s);
                        n = t.getSetsA();
                    }
                    System.out.println("Derrotas: "+d);
                    r = t.Ronda(d);
                    n = t.getSetsA();
                    v = t.getOponentes();
                }
                System.out.println("Ganaste el torneo");
            }catch (Exception e){
                System.out.println(e.toString());
            }
    }
}