class Machine {
    boolean power;
    long epoch;
    String name;

    public Machine(String name){
        this.power = false;
        this.epoch = System.currentTimeMillis();
        this.name = name;
    }

    public void powerOn(){
        this.power = true; 
        System.out.println(this.name + " power: " + this.power + " at : " + this.epoch);
    }

    public void powerOff(){
        this.power = false; 
        System.out.println(this.name + " power: " + this.power);
    }

    public void powerStatus(){
        System.out.println("Power: " + this.power);
    }

    public void makeNoise(){
        System.out.println("Brrr");
    }
}

class Printer extends Machine {
    public Printer(String name){
        super(name);
    }

    @Override
    public void makeNoise(){
        System.out.println("Brrh, Click, Clatter, Clunk");
    }

    public void print(){
        System.out.println("Printing Page");
    }
}

class Sorter extends Machine {

    public Sorter(String name){
        super(name);
    }

    @Override
    public void makeNoise(){
        System.out.println("Riffle, Riffle, Riffle");
    }
}

class MatrixPrinter extends Printer {

    public MatrixPrinter(String name){
        super(name);
    }

    @Override
    public void makeNoise(){
        super.makeNoise();
        System.out.println("Click, Click Click");
    }
}

public class Main {
    public static void main(String[] args) {
        Machine[] machines = {new Printer("Brother"), new Sorter("Casio"), new MatrixPrinter("HP")};
        System.out.println("Running my machine examples");
        for(Machine machine: machines){
            machine.powerOn();
            machine.makeNoise();
            machine.powerOff();
        }
        System.out.println("--------------------------");

        Printer printy = new Printer("Cannon");
        printy.powerOn();
        printy.print();

        Machine badPrinty =  printy; 
        badPrinty.powerStatus();
        badPrinty.powerOff();

        printy.powerStatus();
    }
}