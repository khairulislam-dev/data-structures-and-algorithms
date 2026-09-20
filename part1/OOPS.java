class CountsClass {
    static int count = 0;

    CountsClass(int count) {
        this.count = count;
        count++;
    }
}

class Complex {
    int real;
    int imag;

    public Complex(int real, int imag) {
        this.real = real;
        this.imag = imag;
    }

    static Complex add(Complex a, Complex b) {
        return new Complex(a.real + b.real, a.imag + b.imag);
    }

    static Complex sub(Complex a, Complex b) {
        return new Complex((a.real - b.real), (a.imag - b.imag));
    }

    void printComplexResult() {

        if (this.real == 0 && this.imag != 0) {
            System.out.println(imag + "i");
        } else if (this.real != 0 && this.imag == 0) {
            System.out.println(this.real + "r");
        } else if (this.real != 0 && this.imag != 0) {
            System.out.println(this.real + "r +  " + this.imag + "i");
        }
    }
}

public class OOPS {
    public static void main(String[] args) {

        Complex a = new Complex(8, 4);
        Complex b = new Complex(8, 4);
        // Complex add = Complex.add(a, b);
        Complex sub1 = Complex.sub(a, b);

        // add.printComplexResult();
        sub1.printComplexResult();

        // System.out.println("Count: " + CountsClass.count);
        // CountsClass c1 = new CountsClass(1);
        // CountsClass c2 = new CountsClass(1);
        // CountsClass c3 = new CountsClass(1);
        // System.out.println("Count: " + CountsClass.count);

        // Pen matardo = new Pen(); // create obj and call constructor
        // matardo.setColor("red");
        // matardo.setTip(4);
        // matardo.getPen();

        // // create student obj
        // Student s1 = new Student();
        // s1.setName("Muhammad Khairul");
        // s1.setRoll(724083);
        // s1.setReg(141241251);
        // s1.setGrads(3.96f);
        // s1.marks[0] = 100;
        // s1.marks[1] = 99;
        // s1.marks[2] = 95;
        // s1.Getinfo();

        // this is copy constructor
        // Student s2 = new Student(s1);
        // s2.setReg(987654321);
        // s2.setGrads(4.00f);
        // s2.Getinfo();
        // System.out.println("-------------");

        // s1.marks[0] = 89;
        // s2.Getinfo();
        // s1.Getinfo();

        // Deer d1 = new Deer();
        // d1.eat();

        // MathLibrary math = new MathLibrary();
        // math.sum(1, 2, 3);
        // math.sum(1, 3);

        // Student s = new Student();
        // Student.name = "Muhammad";
        // // s.name = "Khairul";
        // System.out.println(s.name);

        A obj = new B();
        obj.show();
    }
}

// asocation
// aggrigation
// composition
class A {
    void show() {
        System.out.println("Class x");
    }
}

class B extends A {
    void show() {
        System.out.println("class y");
    }
}

// function overloading
class MathLibrary {
    void sum(int a, int b) {
        System.out.println(a + b);
    }

    void sum(int a, int b, int c) {
        System.out.println(a + b + c);
    }
}

// function overriding
class Animal {
    void eat() {
        System.out.println("Eats anything...");
    }
}

class Deer extends Animal {
    void eat() {
        System.out.println("eats grass");
    }
}

// Class: groups of entity (Blue Print)
class Pen {
    String color;
    int tip;

    void setColor(String newColor) {
        this.color = newColor;
    }

    void setTip(int newTip) {
        this.tip = newTip;
    }

    void getPen() {
        System.out.println("Pen Color: " + this.color);
        System.out.println("Pen Tip: " + this.tip);
    }
}

class Student {
    static String name;
    int roll;
    int reg;
    float cgpa;
    int marks[];

    Student() {
        // not peramitarized constructor
        this.marks = new int[3];
    }

    // // shallow copy constructor
    // Student(Student s1) {
    // this.name = s1.name;
    // this.roll = s1.roll;
    // this.reg = s1.reg;
    // this.cgpa = s1.cgpa;
    // this.marks = s1.marks;
    // }

    // deep copy (Carbon Copy)
    Student(Student s1) {
        this.name = s1.name;
        this.roll = s1.roll;
        this.reg = s1.reg;
        this.cgpa = s1.cgpa;
        this.marks = new int[3];

        for (int i = 0; i < this.marks.length; i++) {
            this.marks[i] = s1.marks[i];
        }
    }

    void setName(String newName) {
        this.name = newName;
    }

    void setRoll(int newRoll) {
        this.roll = newRoll;
    }

    void setReg(int newReg) {
        this.reg = newReg;
    }

    void setGrads(float cgpa) {
        this.cgpa = cgpa;
    }

    void Getinfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Roll: " + this.roll);
        System.out.println("CGPA: " + cgpa + "%");
        for (int mark : this.marks) {
            System.out.print(mark + " ");
        }
    }

}