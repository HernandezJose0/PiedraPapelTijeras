
public class Resultado {
    private int seleccionJ, seleccionPC;

    public Resultado(int seleccionJ) {// El constructor pide el valor del botón pulsado
        this.seleccionJ = seleccionJ;
    }

    public int seleccionPC() {
        seleccionPC = (int) (Math.random() * 5 + 1);// la elección de la cpu es aleatoria en el rango 1-5
        System.out.println("Seleccion contrincante: "+seleccionPC);
        return seleccionPC;// Regresa la opción elegida para mostrarla
    }

    public String Veredicto() throws Exception{
        /* Suponiendo
        1: piedra
        2: papel
        3: tijeras
        4: lagarto
        5: Spock
        */
        if (seleccionJ == seleccionPC) return "Empate";
        switch (seleccionJ) {
            case 1:
                if (seleccionPC == 3 || seleccionPC == 4) return "Victoria";
                else return "Derrota";
            case 2:
                if (seleccionPC == 5 || seleccionPC == 1) return "Victoria";
                else return "Derrota";
            case 3:
                if (seleccionPC == 2 || seleccionPC == 4) return "Victoria";
                else return "Derrota";
            case 4:
                if (seleccionPC == 2 || seleccionPC == 5) return "Victoria";
                else return "Derrota";
            case 5:
                if (seleccionPC == 3 || seleccionPC == 1) return "Victoria";
                else return "Derrota";
            default:
                return "Error en seleccion";
        }
    }
}