import java.util.Scanner;

public class MyException extends Exception{
    private int detail;
    public MyException(int a){
        this.detail = a;
    }

    //toString:异常的打印信息

    @Override
    public String toString() {
        return "MyException{" +
                "detail=" + detail +
                '}';
    }
}