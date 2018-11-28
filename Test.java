
public class Test {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Asmuo a = new Asmuo();
        a.setAmzius(112);

        System.out.println(a.getAmzius());

        //a.amzius = -112;
    }
}


class Asmuo{
    String vardas;
    String pavarde;
    private int amzius;

    int getAmzius(){
        return amzius;
    }

    void setAmzius(int amzius){
        if (amzius>0) this.amzius = amzius;
        else this.amzius = 0;
    }
}